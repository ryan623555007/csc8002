/**
 * BinarySemaphore extends semaphore
 * @author sunxiaoyong
 * versin 1.0
 * create on 2018年5月10日
 *
 */
public class BinarySemaphore extends Semaphore{

		public BinarySemaphore(int initial){
		    value = (initial>0) ? 1 : 0;
		    
		}
/*
 * constructor string and i
 * @Constructor
 */
		public BinarySemaphore(String string, int i) {
		}

		public synchronized void P() throws InterruptedException{
		    while (value==0){
		    	wait();
		    }
	    	value = 0;
	    	notify();
		}

		public synchronized void V(){
		    value = 1;
		    notify();
		}
		
	
}
