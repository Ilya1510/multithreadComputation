/**
 * Created by ilya on 31.10.17.
 */
package ru.mipt.java2017.hw2;

import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Server {
  private static final Logger logger = LoggerFactory.getLogger("Server");

  private int portNumber;
  private int coresCount;
  private io.grpc.Server server;

  private Server(int coresCount, int portNumber) {
    this.coresCount = coresCount;
    this.portNumber = portNumber;
  }

  private void start() throws IOException {
    server = ServerBuilder.forPort(portNumber)
        .addService(new ComputatorImpl())
        .build()
        .start();
    logger.info("Server started, listening on " + portNumber);

    Runtime.getRuntime().addShutdownHook(new Thread() {
      @Override
      public void run() {
        // Use stderr here since the logger may have been reset by its JVM shutdown hook.
        System.err.println("*** shutting down gRPC server since JVM is shutting down");
        Server.this.stop();
        System.err.println("*** server shut down");
      }
    });
  }

  private void stop() {
    if (server != null) {
      server.shutdown();
    }
  }
  /**
   * Await termination on the main thread since the grpc library uses daemon threads.
   */
  private void blockUntilShutdown() throws InterruptedException {
    if (server != null) {
      server.awaitTermination();
    }
  }

  public static void main(String[] args) {
    final Server server = new Server(
        Integer.parseInt(args[0]), Integer.parseInt(args[1]));
    try {
      server.start();
      server.blockUntilShutdown();
    } catch (IOException | InterruptedException e) {
      server.stop();
    }
  }

  class ComputatorImpl extends ComputatorGrpc.ComputatorImplBase {

    private long getSumOfPrimeNumbers(long a, long b) throws ExecutionException, InterruptedException { //! [a, b)
      PrimeChecker checker = new PrimeChecker(coresCount);
      Long d = b - a;
      long sum = 0;
      List<Future<Boolean>> promises = new ArrayList<>(d.intValue());
      for (long value = a; value < b; ++value) {
        Future<Boolean> promise = checker.isPrimePromise(value);
        promises.add(promise);
      }

      for (int i = 0; i < d; ++i) {
        Future<Boolean> promise = promises.get(i);
        if (promise.get()) {
          logger.info("Number {} is prime!", a + i);
          sum += a + i;
        }
      }
      return sum;
    }

    @Override
    public void compute(SegmentRequest req, StreamObserver<SumReply> responseObserver) {
      try {
        logger.info("Got request from client: {}, {}", req.getLeft(), req.getRight());
        SumReply reply = SumReply.newBuilder().setResultSum(getSumOfPrimeNumbers(
            req.getLeft(), req.getRight())).build();
        responseObserver.onNext(reply);
        responseObserver.onCompleted();
      } catch (ExecutionException | InterruptedException e) {
        server.shutdown();
      }
    }
  }
}
