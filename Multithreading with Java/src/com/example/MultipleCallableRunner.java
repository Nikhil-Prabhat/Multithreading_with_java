package com.example;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

// We need to wait for all the tasks to be completed
public class MultipleCallableRunner {

	public static void main(String[] args) throws InterruptedException {
		ExecutorService executorService = Executors.newFixedThreadPool(3);
		List<CallableTask> tasks = new ArrayList<>();
		tasks.add(new CallableTask("Nikhil"));
		tasks.add(new CallableTask("Prabhat"));
		tasks.add(new CallableTask("Raushan"));

		List<Future<String>> resultList = executorService.invokeAll(tasks);
		resultList.forEach((task) -> {
			try {
				System.out.println(task.get());
			} catch (InterruptedException | ExecutionException e) {
				e.printStackTrace();
			}
		});

		executorService.shutdown();

	}

}
