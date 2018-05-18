/**
 * Z thread implements runnable and mainly be used to print Z thread 
 * @author sunxiaoyong
 * versin 1.0
 * create on 2018年5月10日
 *
 */
class ZRunnable implements Runnable{
		BinarySemaphore x_binarySemaphore = null;
		BinarySemaphore y_binarySemaphore = null;
		BinarySemaphore z_binarySemaphore = null;
		
		int count = 0;
		/*
		 * x,y,zBinarySemaphore constructor
		 * @Constructor
		 */
		public ZRunnable(BinarySemaphore x_binarySemaphore,
				BinarySemaphore y_binarySemaphore,
				BinarySemaphore z_binarySemaphore, int count) {
			this.x_binarySemaphore = x_binarySemaphore;
			this.y_binarySemaphore = y_binarySemaphore;
			this.z_binarySemaphore = z_binarySemaphore;
			this.count = count;
		}

		@Override
		public void run() {
			while(true){
				try {
					z_binarySemaphore.P();
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
				
				System.out.println("Z");
				
				if(count % 3 == 0){
					x_binarySemaphore.V();
				}else if(count % 3 == 1){
					y_binarySemaphore.V();
				}else{
					z_binarySemaphore.V();
				}
				
				count++;
			}
			
		}
		
	}
	