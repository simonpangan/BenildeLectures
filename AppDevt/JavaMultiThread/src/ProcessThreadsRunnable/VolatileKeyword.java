package ProcessThreadsRunnable;

import java.util.Scanner;

class Counter extends Thread{
	
	private volatile boolean counting = true;
	private int counter = 1;
	
	public void run() {
		
		while(counting) {
			System.out.println(counter);
			counter++;
			
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}
	
	public void stopCounting() {
		counting = false;
	}
}
public class VolatileKeyword {

	public static void main(String[] args) {
		
		
		Counter c = new Counter();
		
		c.start();
		
		Scanner stopCount = new Scanner(System.in);
		
		stopCount.nextLine();
		
		c.stopCounting();
		
	}
	
	
}
