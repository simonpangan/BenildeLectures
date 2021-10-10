
public class ExceptionMethodsCallStack {

	public static void main(String[] args) {
	
		ExceptionMethodsCallStack em = new ExceptionMethodsCallStack();
		
		
		em.methodA();

	}
	
	public void methodA() {
		
		try {
			System.out.println("From method A");
			methodB();
		}catch(ArithmeticException e) {
			System.out.println("Exception fired: Method A" + e.getMessage());
			
		}
	}
	
	public void methodB() {
		System.out.println("From method B");
		methodC();
	}
	
	public void methodC() {
		System.out.println("From method C");
		methodD();
		/*
		 try {
			System.out.println("From method C");
			methodD();
		}catch(ArithmeticException e) {
			System.out.println("Exception fired: Method B" + e.getMessage());
			
		}
		 */
	}
	
	public void methodD() {  //method d will check if there is a try catch in its own method 
		// if not it will check method c
		// method c on the other hand will check if there is a try catch in its own method
		// if not will check method b
		System.out.println("From method D");
		
		int result = 10/0;
		System.out.println(result);
		
		
	}

}
