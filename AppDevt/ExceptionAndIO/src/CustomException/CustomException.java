package CustomException;

import java.util.Scanner;

public class CustomException {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int age;
		
		try {
			System.out.println("Validate you age: " );
			age = sc.nextInt();
			
			if(age  < 18 ) {
				throw new InvalidAgeException("You are not yet allowed.");
			}else {
				System.out.println("COngratulations!");
			}
		}catch(InvalidAgeException e){
			System.out.println("Invalid age: " + e.getMessage());
			
		}
	}

}
