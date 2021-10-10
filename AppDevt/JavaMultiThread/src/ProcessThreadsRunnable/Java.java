package ProcessThreadsRunnable;

class NewYear implements Runnable
{

	@Override
	public void run() {
		
		countDown();
	}
	
	public void countDown() {
		for(int i = 10; i > 0 ; i--) {
			System.out.println(i);
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		System.out.println("Happy New Year!");
	}
	
}
class TAE implements Runnable
{

	@Override
	public void run() {
		
		countDown();
	}
	
	public void countDown() {
		for(int i = 10; i > 0 ; i--) {
			System.out.println(i);
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		System.out.println("Happy New Year!");
	}
	
}
public class Java {
	
	public static void main(String[] args) {
	
		NewYear ny  = new NewYear();
		TAE ty = new TAE();
		Thread t = new Thread(ny);
		Thread t2 = new Thread(ty);
	
		t.start();
		t2.start();
		
	
		
	}

}
