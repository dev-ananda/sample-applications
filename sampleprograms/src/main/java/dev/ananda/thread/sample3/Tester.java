/**
 * 
 */
package dev.ananda.thread.sample3;

/**
 * Created by Ananda on 18-Dec-2019 
 */

public class Tester {
	public static void main(String[] args) {
	    Broker broker = new Broker();
	    Thread sender = new Thread(new Sender(broker));
	    Thread receiver = new Thread(new Receiver(broker));
	    Thread sender1 = new Thread(new Sender(broker));
	     
	    sender.start();
	    sender1.start();
	    receiver.start();
	}
}
