/**
 * 
 */
package dev.ananda.thread.sample3;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * Created by Ananda on 18-Dec-2019 
 */

public class Broker {
	
	private static Logger log = LoggerFactory.getLogger(Broker.class);
	
	private String packet;
    
    // True if receiver should wait
    // False if sender should wait
    private boolean transfer = true;
  
    public synchronized void send(String packet) {
        while (!transfer) {
            try { 
            	System.out.println("Send wait()");
                wait();
            } catch (InterruptedException e)  {
                Thread.currentThread().interrupt(); 
                log.error("Thread interrupted", e); 
            }
        }
        transfer = false;
         
        this.packet = packet;
        notifyAll();
    }
  
    public synchronized String receive() {
        while (transfer) {
            try {
            	System.out.println("Receive wait()");
                wait();
            } catch (InterruptedException e)  {
                Thread.currentThread().interrupt(); 
                log.error("Thread interrupted", e); 
            }
        }
        transfer = true;
 
        notifyAll();
        return packet;
    }
}
