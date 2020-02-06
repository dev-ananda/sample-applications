/**
 * 
 */
package dev.ananda.multithreading;

import java.util.concurrent.TimeUnit;

/**
 * Created by Ananda on 06-Dec-2019 
 */

public class Concurrency2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Runnable runnable = () -> {
		    try {
		        String name = Thread.currentThread().getName();
		        System.out.println("Foo " + name);
		        TimeUnit.SECONDS.sleep(1);
		        System.out.println("Bar " + name);
		    }
		    catch (InterruptedException e) {
		        e.printStackTrace();
		    }
		};

		Thread thread = new Thread(runnable);
		thread.start();
		
		Thread thread2 = new Thread(runnable);
		thread2.start();
	}

}
