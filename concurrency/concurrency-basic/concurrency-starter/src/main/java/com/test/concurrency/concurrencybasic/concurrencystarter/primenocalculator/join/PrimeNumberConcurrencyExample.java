package com.test.concurrency.concurrencybasic.concurrencystarter.primenocalculator.join;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PrimeNumberConcurrencyExample {

	public static void main(String[] args) {

		List<Thread> threads = new ArrayList<>();

		Runnable statusReporter = () -> {

			try {

				while (true) {

					Thread.sleep(5000);
					printThreads(threads);
				}
			} catch (InterruptedException e) {

				System.out.println("Interrupted");
			}
		};

		Thread reporterThread = new Thread(statusReporter);
		/*
		 * We need to configure this reporting thread as daemon thread. Because while
		 * condition is always true then if we ends the main thread using 0 this
		 * reporting thread will never end. Then our application will never stop
		 */
		reporterThread.setDaemon(true);
		reporterThread.start();

		while (true) {

			Scanner sc = new Scanner(System.in);
			System.out.println("\n I can tell you the nth prime number. Enter n: ");
			int n = sc.nextInt();

			if (n == 0) {

				try {

					System.out.println("Waiting for all threads to finish...");
					waitForThreads(threads);
					System.out.println("Done! " + threads.size() + " primes calculated");
				} catch (InterruptedException e) {

					System.out.println("\nGot interrupted when waiting for threads. Quitting...");
				}

				break;
			}

			Runnable r = new Runnable() {

				@Override
				public void run() {

					int number = PrimeNumberUtil.calculatePrime(n);

					System.out.println("\n Result: ");
					System.out.println("\n Value of " + n + "th prime: " + number);
				}
			};

			Thread t = new Thread(r);
			threads.add(t);
			t.start();
		}
	}

	private static void printThreads(List<Thread> threads) {

		System.out.println("\n Threads status: ");
		threads.forEach(thread -> System.out.println(thread.getState() + " "));
		System.out.println("");
	}

	private static void waitForThreads(List<Thread> threads) throws InterruptedException {

		for (Thread thread : threads) {

			/*
			 * Other threads (in here main thread) have to wait until this threads finish
			 * the execution.
			 */
			thread.join();
		}
	}
}
