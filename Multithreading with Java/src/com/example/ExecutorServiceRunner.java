package com.example;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

// Generalised Task Creation

class Task extends Thread {

	private int number;

	public Task(int number) {
		this.number = number;
	}

	public void run() {
		System.out.println("\nTask " + number + " Started");

		for (int i = number; i < number * 100 + 99; i++)
			System.out.print(i + " ");
		System.out.println("\nTask " + number + " Done");
	}
}

/*
 * The Java ExecutorService is the interface which allows us to execute tasks on
 * threads asynchronously. The ExecutorService helps in maintaining a pool of
 * threads and assigns them tasks. It also provides the facility to queue up
 * tasks until there is a free thread available if the number of tasks is more
 * than the threads available.
 */
public class ExecutorServiceRunner {
	public static void main(String[] args) {
		// ExecutorService executorService = Executors.newSingleThreadExecutor();
		
		// The number signifies the total no of threads being active at a particular instance of time.
		// In this case, the number is 2, it means at any point of time, the total active threads will be 2.
		ExecutorService executorService = Executors.newFixedThreadPool(2);

		executorService.execute(new Task(1));
		executorService.execute(new Task(2));
		executorService.execute(new Task(3));
		executorService.execute(new Task(4));

		// Task3
		System.out.println("\nTask3 Kicked Off");

		for (int i = 200; i < 300; i++)
			System.out.print(i + " ");
		System.out.println("\nTask3 Done");

		System.out.println("\nMain Done");

		// To shut down the executor service
		executorService.shutdown();
	}

}
