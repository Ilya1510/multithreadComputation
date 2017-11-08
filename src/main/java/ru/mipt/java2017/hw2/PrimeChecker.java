package ru.mipt.java2017.hw2;

/**
 * Created by ilya on 02.11.17.
 */

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import static java.lang.Math.sqrt;

class PrimeChecker {

  PrimeChecker(int threadCount) {
    executor = Executors.newFixedThreadPool(threadCount);
  }

  private ExecutorService executor;

  private boolean isPrime(long number) {
    if (number == 1) return false;
    if (number == 2) return true;
    if ( (number & 1) == 0 ) return false;
    long upperBound = (long) sqrt(number) + 1;
    //long upperBound = number - 1;
    for (int test = 3; test < upperBound; test += 2) {
      if ( (number % test) == 0 ) {
        return false;
      }
    }
    return true;
  }

  Future<Boolean> isPrimePromise(long number) {
    return executor.submit(() -> isPrime(number));
  }

}

