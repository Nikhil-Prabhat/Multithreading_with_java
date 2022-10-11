package com.example;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MultipleAnyCallableRunner {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		ExecutorService executorService = Executors.newFixedThreadPool(3);
		List<CallableTask> tasks = new ArrayList<>();
		tasks.add(new CallableTask("Nikhil"));
		tasks.add(new CallableTask("Prabhat"));
		tasks.add(new CallableTask("Raushan"));
		
		// Invoke Any will wait for any of the task to be completed
		String result = executorService.invokeAny(tasks);
		System.out.println(result);

		executorService.shutdown();

	}

}
