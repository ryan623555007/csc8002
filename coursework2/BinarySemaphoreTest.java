/**
 * the main method using BinarySemaphore print xyz thread
 * @author sunxiaoyong
 * versin 1.0
 * create on 2018年5月10日
 *
 */
public class BinarySemaphoreTest {
	static volatile int count = 0;
	
	public static void main(String[] args) throws InterruptedException {
		BinarySemaphore x_binarySemaphore = new BinarySemaphore(0);
		BinarySemaphore y_binarySemaphore = new BinarySemaphore(0);
		BinarySemaphore z_binarySemaphore = new BinarySemaphore(1);
		
		Thread x_thread = new Thread(new XRunnable(x_binarySemaphore, y_binarySemaphore, z_binarySemaphore));
		Thread y_thread = new Thread(new YRunnable(x_binarySemaphore, y_binarySemaphore, z_binarySemaphore));
		Thread z_thread = new Thread(new ZRunnable(x_binarySemaphore, y_binarySemaphore, z_binarySemaphore, count));
		
		x_thread.start();
		y_thread.start();
		z_thread.start();
		
		Thread.sleep(10000);
		
		System.exit(0);
		
	}
	


}
