/**
 * 
 */
package dev.ananda.thread.sample2;

import java.util.concurrent.TimeUnit;

/**
 * Created by Ananda on 17-Dec-2019 
 */

public class PrintCounter implements Runnable {

	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	
	private static Integer counter = 1;
	
	private Object lock = new Object();
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		synchronized(lock){
			try {
				//lock.wait();
				TimeUnit.SECONDS.sleep(2);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName() + " "+counter);
			counter = (counter+1)%4;
			//lock.notifyAll();
		}

	}

}
