package com.dev.boot.san;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;

import com.dev.boot.dao.ProcessDAO;
import com.dev.boot.entity.ProcessFeds;

public class Startup {

	public static void main(String[] args) {
		Callable<Integer> task = () -> {
		    
			ProcessDAO dao=new ProcessDAO();
			List<ProcessFeds> items=dao.getAllEmployees();
			
			for(ProcessFeds item : items){
				System.out.println(item.getA_file());
				System.out.println(item.getB_file());
				
			}
			return null;
		    
		    
		};
		
		for(int i=0;i<=10;i++)
		{
		ExecutorService executor = Executors.newFixedThreadPool(5);
		Future<Integer> future = executor.submit(task);

		System.out.println("future done? " + future.isDone());

		Integer result = 0;
		try {
			result = future.get();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("future done? " + future.isDone());
		System.out.print("result: " + result);

	}
	}

}
