/**
 * 
 */
package dev.ananda.multithreading;

import java.util.concurrent.ExecutorService;

/**
 * Created by Ananda on 06-Dec-2019 
 */

public class Executors1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ExecutorService executor = java.util.concurrent.Executors.newSingleThreadExecutor();
		executor.submit(() -> {
		    String threadName = Thread.currentThread().getName();
		    System.out.println("Hello " + threadName);
		});

	}

}
