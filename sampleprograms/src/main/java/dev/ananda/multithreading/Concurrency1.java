/**
 * 
 */
package dev.ananda.multithreading;

/**
 * Created by Ananda on 06-Dec-2019 
 */

public class Concurrency1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Runnable task = () -> {
		    String threadName = Thread.currentThread().getName();
		    System.out.println("Hello " + threadName);
		};

		task.run();

		Thread thread = new Thread(task);
		thread.start();

		System.out.println("Done!");

	}

}
