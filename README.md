Multithreading is a Java feature that allows concurrent execution of two or more parts of a program for maximum utilization of CPU. Each part of such program is called a thread. So, threads are light-weight processes within a process.
In general, there is only main thread that executes, but multi-threading enables us to utilise maximum CPU resources.

Threads can be created by using two mechanisms : 

Extending the Thread class 
Implementing the Runnable Interface

// Java code for thread creation by extending
// the Thread class
class MultithreadingDemo extends Thread {
	public void run()
	{
		try {
			// Displaying the thread that is running
			System.out.println(
				"Thread " + Thread.currentThread().getId()
				+ " is running");
		}
		catch (Exception e) {
			// Throwing an exception
			System.out.println("Exception is caught");
		}
	}
}

// Main Class
public class Multithread {
	public static void main(String[] args)
	{
		int n = 8; // Number of threads
		for (int i = 0; i < n; i++) {
			MultithreadingDemo object
				= new MultithreadingDemo();
			object.start();
		}
	}
}

// Java code for thread creation by implementing
// the Runnable Interface
class MultithreadingDemo implements Runnable {
	public void run()
	{
		try {
			// Displaying the thread that is running
			System.out.println(
				"Thread " + Thread.currentThread().getId()
				+ " is running");
		}
		catch (Exception e) {
			// Throwing an exception
			System.out.println("Exception is caught");
		}
	}
}

// Main Class
class Multithread {
	public static void main(String[] args)
	{
		int n = 8; // Number of threads
		for (int i = 0; i < n; i++) {
			Thread object
				= new Thread(new MultithreadingDemo());
			object.start();
		}
	}
}

// Thread States :

* New 				- 	A thread is said to be in new state , when the thread is created but not executed yet.
* Runnable 			- 	When the thread is ready to run, but at that moment of time, other thread is being executed.
* Running 			- 	When the thread is already executing, it is called to be in running state.
* Waiting/Blocked 	- 	When the thread is dependent on some other thread for its execution, then it is said to be in waiting state.
* Terminated/Dead 	- 	When a thread is done executing, it is said to be in Terminated or Dead state.

Thread Priority :

MIN_PRIORITY 	: 1
NORM_PRIORITY 	: 5
MAX_PRIORITY 	: 10

Assigning a priority is just a request. This request can be honored or rejected.

Thread.sleep(1000) -> 1000 ms -> Thread will sleep/go in waiting state for 1 s.

* Synchronisation : Multi-threaded programs may often come to a situation where multiple threads try to access the same resources and finally produce erroneous and unforeseen results. So it needs to be made sure by some synchronization method that only one thread can access the resource at a given point in time. Java provides a way of creating threads and synchronizing their tasks using synchronized blocks. Synchronized blocks in Java are marked with the synchronized keyword. A synchronized block in Java is synchronized on some object. 

Why Synchronisation :

When we start two or more threads within a program, there may be situation when multiple threads try to access the same resource. Hence, the issue arises when there is any shared resources.

// A Java program to demonstrate working of 
// synchronized. 

import java.io.*; 
import java.util.*; 

// A Class used to send a message 
class Sender 
{ 
	public void send(String msg) 
	{ 
		System.out.println("Sending\t" + msg ); 
		try
		{ 
			Thread.sleep(1000); 
		} 
		catch (Exception e) 
		{ 
			System.out.println("Thread interrupted."); 
		} 
		System.out.println("\n" + msg + "Sent"); 
	} 
} 

// Class for send a message using Threads 
class ThreadedSend extends Thread 
{ 
	private String msg; 
	Sender sender; 

	// Receives a message object and a string 
	// message to be sent 
	ThreadedSend(String m, Sender obj) 
	{ 
		msg = m; 
		sender = obj; 
	} 

	public void run() 
	{ 
		// Only one thread can send a message 
		// at a time. 
		synchronized(sender) 
		{ 
			// synchronizing the send object 
			sender.send(msg); 
		} 
	} 
} 

// Driver class 
class SyncDemo 
{ 
	public static void main(String args[]) 
	{ 
		Sender send = new Sender(); 
		ThreadedSend S1 = 
			new ThreadedSend( " Hi " , send ); 
		ThreadedSend S2 = 
			new ThreadedSend( " Bye " , send ); 

		// Start two threads of ThreadedSend type 
		S1.start(); 
		S2.start(); 

		// wait for threads to end 
		try
		{ 
			S1.join(); 
			S2.join(); 
		} 
		catch(Exception e) 
		{ 
			System.out.println("Interrupted"); 
		} 
	} 
}
