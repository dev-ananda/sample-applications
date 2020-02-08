/**
 * 
 */
package dev.ananda.thread.sample3;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ThreadLocalRandom;


/**
 * Created by Ananda on 18-Dec-2019 
 */

public class Receiver implements Runnable {

	private Broker broker;

	private static Logger log = LoggerFactory.getLogger(Receiver.class);

	/**
	 * @param broker2
	 */
	public Receiver(Broker broker) {
		// TODO Auto-generated constructor stub
		this.broker = broker;
	}

	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		// TODO Auto-generated method stub

		for(String receivedMessage = broker.receive();
				!"End".equals(receivedMessage);
				receivedMessage = broker.receive()) {

			System.out.println(receivedMessage);

			// ...
			try {
				Thread.sleep(ThreadLocalRandom.current().nextInt(1000, 5000));
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt(); 
				log.error("Thread interrupted", e); 
			}
		}

	}

}
