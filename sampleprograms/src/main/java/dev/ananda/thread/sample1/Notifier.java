/**
 * 
 */
package dev.ananda.thread.sample1;

/**
 * Created by Ananda on 17-Dec-2019 
 */

public class Notifier implements Runnable {
	private Message msg;

	public Notifier(Message msg) {
		this.msg = msg;
	}

	@Override
	public void run() {
		String name = Thread.currentThread().getName();
		System.out.println(name+" started");
		try {
			Thread.sleep(1000);
			synchronized (msg) {
				msg.setMsg(name+" Notifier work done");
				msg.notify();
				// msg.notifyAll();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}
}
