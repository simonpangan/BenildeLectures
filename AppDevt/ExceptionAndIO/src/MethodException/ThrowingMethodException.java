package MethodException;

public class ThrowingMethodException {

	public static void main(String[] args) {
		ThrowingMethodException tme = new ThrowingMethodException();
		tme.methodA();
		

	}

	public void methodA() {
		
		try
		{
			methodB();
		}catch(InvalidAgeException e)
		{
			System.out.println(e.getMessage());
		}
	}
	
	public void methodB() throws InvalidAgeException
	{
		int age = 17;
		if (age < 17) {
			throw new InvalidAgeException("Invalid Age");
		}else {
			System.out.println("Congratulations!");
		}
	}

}
