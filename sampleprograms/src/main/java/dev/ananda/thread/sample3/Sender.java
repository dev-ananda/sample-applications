/**
 * 
 */
package dev.ananda.thread.sample3;

import java.util.concurrent.ThreadLocalRandom;

import org.apache.log4j.Logger;

/**
 * Created by Ananda on 18-Dec-2019 
 */

public class Sender implements Runnable {

	private static Logger log = Logger.getLogger(Sender.class);
	private Broker broker;
	/**
	 * @param broker2
	 */
	public Sender(Broker broker) {
		this.broker = broker;
	}
	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		// TODO Auto-generated method stub

		String packets[] = {
				"First packet",
				"Second packet",
				"Third packet",
				"Fourth packet",
				"End"
		};

		for (String packet : packets) {
			broker.send(packet);

			// Thread.sleep() to mimic heavy server-side processing
			try {
				Thread.sleep(ThreadLocalRandom.current().nextInt(1000, 5000));
			} catch (InterruptedException e)  {
				Thread.currentThread().interrupt(); 
				log.error("Thread interrupted", e); 
			}
		}
	}
}
