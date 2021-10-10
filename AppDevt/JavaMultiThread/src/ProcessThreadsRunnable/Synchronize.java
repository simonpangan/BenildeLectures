package ProcessThreadsRunnable;

public class Synchronize {
	
	private int balance =0;
	
	
	
	public static void main(String[] args) {
		 
		Synchronize s = new Synchronize();
		s.goingThroughLife();
	}
	
	
	public void goingThroughLife(){
		
		Thread t1 = new Thread(new Runnable(){

			@Override
			public void run() {
				
				for(int i =0; i < 1000; i++) {
					add();
				}
				
				
			}
			
			
		}); 
		
		Thread t2  = new Thread(new Runnable(){

			@Override
			public void run() {
				
				
				for(int i =0; i < 1000; i++) {
					substract();
				}
				
				
			}
			
			
		}); 
		
		t1.start();
		t2.start();
		
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		System.out.print(balance);
		
		
	}
	
	public synchronized void add() {
		balance++;
	}
	public synchronized void substract() {
		balance--;
	}
}
