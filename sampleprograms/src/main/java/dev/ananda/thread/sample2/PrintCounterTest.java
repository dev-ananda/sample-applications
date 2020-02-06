/**
 * 
 */
package dev.ananda.thread.sample2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Ananda on 17-Dec-2019 
 */

public class PrintCounterTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		PrintCounter counter = new PrintCounter();
		
		Thread t1 = new Thread(counter);
		Thread t2 = new Thread(counter);
		Thread t3 = new Thread(counter);
		t1.start();
		t2.start();
		t3.start();
		
		ExecutorService service = Executors.newCachedThreadPool();
		service.submit(counter);
		service.submit(counter);
		service.submit(counter);	

	}

}
