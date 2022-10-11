package com.example;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

class CallableTask implements Callable<String> {
	private String name;

	public CallableTask(String name) {
		this.name = name;
	}

	@Override
	public String call() throws Exception {
		Thread.sleep(1000);
		return "Hello " + name;
	}

}

public class CallableRunner {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		ExecutorService executorService = Executors.newFixedThreadPool(1);

		// Future is basically a promise that it would return a result
		// It may not be having the value for now but it will definitely have the value in the future
		Future<String> futureResult = executorService.submit(new CallableTask("Nikhil"));
		System.out.println("\nCallable Task executed");
		String futureMessage = futureResult.get();
		System.out.println(futureMessage);

		System.out.println("\nMain completed");
		
		executorService.shutdown();

	}

}
