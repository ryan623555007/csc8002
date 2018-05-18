/**
 * X thread implements runnable and mainly be used to print x thread 
 * @author sunxiaoyong
 * versin 1.0
 * create on 2018年5月10日
 *
 */
public class XRunnable implements Runnable{

		BinarySemaphore x_binarySemaphore = null;
		BinarySemaphore y_binarySemaphore = null;
		BinarySemaphore z_binarySemaphore = null;
/*
 * x,y,zBinarySemaphore constructor
 * @Construcor 
 */
		public XRunnable(BinarySemaphore x_binarySemaphore,
				BinarySemaphore y_binarySemaphore,
				BinarySemaphore z_binarySemaphore) {
			super();
			this.x_binarySemaphore = x_binarySemaphore;
			this.y_binarySemaphore = y_binarySemaphore;
			this.z_binarySemaphore = z_binarySemaphore;
		}

		@Override
		public void run() { 
			while(true){
				try {
					x_binarySemaphore.P();
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
				try {
					double random = Math.round(Math.random()*1000); 
					long l = new Double(random).longValue();
					Thread.sleep(l);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("X");
				
				z_binarySemaphore.V();
			}
			
		}
	
}
