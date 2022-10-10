package com.example;

//Thread creation is possible by two ways :
// 1. Extending Thread class
// 2. Implements Runnable Interface

//1. Extending Thread Class
class Task1 extends Thread {
	public void run() {
		System.out.println("\nTask1 Started");

		// Task1
		for (int i = 0; i < 100; i++)
			System.out.print(i + " ");
		
		// It's just a request that it wants to stop consuming the CPU, the scheduler can ignore it
		//Thread.yield();
		
		System.out.println("\nTask1 Done");
	}
}

//2. Implementing Runnable Interface
class Task2 implements Runnable {

	@Override
	public void run() {
		System.out.println("\nTask2 Started");

		// Task2
		for (int i = 100; i < 200; i++)
			System.out.print(i + " ");
		System.out.println("\nTask2 Done");
	}
}

public class MultiThreading {

	public static void main(String[] args) throws InterruptedException {
		/*
		 * In general, main thread executes all these loops
		 */

		// Task1
		System.out.println("\nTask1 Kicked Off");

		/*
		 * for (int i = 0; i < 100; i++) System.out.print(i + " ");
		 * System.out.println("\nTask1 Done\n");
		 */

		Task1 task1 = new Task1();
		// task1.run() - It will run like a normal program, executed by main thread only
		// Setting the priority
		task1.setPriority(Thread.MAX_PRIORITY);
		task1.start();

		// Task2
		System.out.println("\nTask2 Kicked Off");

		/*
		 * for (int i = 100; i < 200; i++) System.out.print(i + " ");
		 * System.out.println("\nTask2 Done");
		 */

		Thread task2 = new Thread(new Task2());
		task2.start();

		// Wait for task1 & task2 to complete
		task1.join();
		task2.join();

		// Task3
		System.out.println("\nTask3 Kicked Off");

		for (int i = 200; i < 300; i++)
			System.out.print(i + " ");
		System.out.println("\nTask3 Done");

		System.out.println("\nMain Done");

	}

}
