/**
 * Created by ilya on 31.10.17.
 */

package ru.mipt.java2017.hw2;

import static com.google.common.util.concurrent.MoreExecutors.directExecutor;
import static java.lang.Math.min;
import static java.lang.Thread.sleep;

import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import javafx.util.Pair;
import javax.annotation.Nullable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.mipt.java2017.hw2.ComputatorGrpc.ComputatorFutureStub;

public class Client {
  private static final Logger logger = LoggerFactory.getLogger("Client");

  private final LinkedList<ManagedChannel> channels;
  private final LinkedList<ComputatorFutureStub> futureStubs;
  private final Map<Pair<Long, Long>, ListenableFuture<SumReply>> jobs;

  private Lock lockSum = new ReentrantLock();
  private boolean isComplete;
  private long fullSum = 0;

  private int getServersCount() {
    return channels.size();
  }

  private void finilize() {
    isComplete = true;
  }

  private void sendJobsToServers(long a, long b) {
    int n = getServersCount();
    if (n == 0) {
      isComplete = true;
    }
    Long d = (b - a) / n + ((b - a) % n == 0 ? 0 : 1);
    long curA = a;
    long curB = a + d;
    Iterator<ManagedChannel> channelIterator = channels.iterator();
    for (ComputatorGrpc.ComputatorFutureStub futureStub : futureStubs) {
      sendSegmentToServer(channelIterator.next(), futureStub, curA, curB);
      curA += d;
      curB += d;
      curB = min(curB, b);
    }
  }

  private void sendSegmentToServer(final ManagedChannel channel,
      final ComputatorGrpc.ComputatorFutureStub futureStub, final Long a, final Long b) {
    logger.debug("Will try to send segment {}, {} ... ", a, b);
    SegmentRequest request = SegmentRequest.newBuilder()
        .setLeft(a)
        .setRight(b)
        .build();
    ListenableFuture<SumReply> response = futureStub.compute(request);
    Pair<Long, Long> segment = new Pair<>(a, b);
    lockSum.lock();
    jobs.put(segment, response);
    lockSum.unlock();

    Futures.addCallback(response,
        new FutureCallback<SumReply>() {
          @Override
          public void onSuccess(@Nullable SumReply result) {
            if (result == null) {
              logger.warn("result " + a + " " + b + " can't come");
            } else {
              logger.debug("Get sum from {} to {}", a, b);
              lockSum.lock();
              fullSum += result.getResultSum();
              jobs.remove(new Pair<>(a, b));
              if (jobs.isEmpty()) {
                finilize();
              }
              lockSum.unlock();
            }
          }
          @Override
          public void onFailure(@Nullable Throwable t) {
            futureStubs.remove(futureStub);
            channels.remove(channel);
            if (t != null) {
              logger.warn(a + " " + b + " can't compute " + t.getMessage());
            } else {
              logger.warn(a + " " + b + " can't compute.");
            }
            lockSum.lock();
            jobs.remove(new Pair<>(a, b));
            lockSum.unlock();
            sendJobsToServers(a, b);
          }
        },
        directExecutor());
  }

  private static LinkedList<ManagedChannel> getChannels(
      LinkedList<Pair<String, Integer> > hosts
  ) {
    LinkedList<ManagedChannel> curChannels = new LinkedList<>();
    for (Pair<String, Integer> host : hosts) {
      curChannels.addLast(ManagedChannelBuilder
          .forAddress(host.getKey(), host.getValue())
          .usePlaintext(true)
          .build());
    }
    return curChannels;
  }

  private Client(LinkedList<Pair<String, Integer> > hosts, boolean tmp) {
    this(getChannels(hosts));
  }

  private Client(LinkedList<ManagedChannel> channels) {
    isComplete = false;
    this.jobs = new HashMap<>();
    this.channels = channels;
    LinkedList<ComputatorGrpc.ComputatorFutureStub> curStubs = new LinkedList<>();
    for (ManagedChannel channel : channels) {
      curStubs.addLast(ComputatorGrpc.newFutureStub(channel));
    }
    futureStubs = curStubs;
  }

  private void shutdown() {
    channels.forEach(channel -> {
      try {
        channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
      } catch (InterruptedException e) {
        logger.warn("Can't shutdown " + channel.toString() + " " + e.getMessage());
      }
    });
  }

  public static void main(String[] args) {
    Long timeBegin = System.currentTimeMillis();

    long start = Long.parseLong(args[0]);
    long end = Long.parseLong(args[1]) + 1;

    logger.debug("" + start + " " + end);

    LinkedList<Pair<String, Integer> > hosts = new LinkedList<>();
    for (int i = 2; i < args.length; i += 2) {
      String hostName = args[i];
      int portNumber = Integer.parseInt(args[i + 1]);
      logger.debug("new host " + hostName + " " + portNumber);
      hosts.addLast(new Pair<>(hostName, portNumber));
    }
    Client client = new Client(hosts, true);
    client.sendJobsToServers(start, end);
    while (!client.isComplete) {
      try {
        sleep(10);
      } catch (InterruptedException e) {
        logger.warn("Sleep interrupted " + e.getMessage());
      }
    }
    client.shutdown();
    logger.debug("resultSum = " + client.fullSum);
    logger.debug("Time: " + (System.currentTimeMillis() - timeBegin) + "");
    System.out.println(client.fullSum);
  }
}
