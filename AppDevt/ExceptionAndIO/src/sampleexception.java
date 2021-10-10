import java.util.Scanner;

public class sampleexception {

	  public static void main(String[] args){
	
		Scanner input = new Scanner (System.in);
		int i = 12;
		int j = 2;
		int k;
		String l = null;
		
		
		try {
			/*
			if(l.equals("Error")) {
				System.out.println("Error");
			}*/
			
			System.out.print("Input value for k variable: ");
			k = Integer.parseInt(input.next());
			
			System.out.println("The value of k is " + k);
			
			int result = i/ (j-2); // divide by 0 = error // Arithmetic Exception
			System.out.println(result);
		}
		/*catch(NumberFormatException  | ArithmeticException e) { 
		
			System.out.println("Error:  " + e.getMessage());
		}
		*/
		catch(NullPointerException e) { 
			
			System.out.println("Null Pointer Exception " + e.getMessage());
		}
		catch(NumberFormatException e) { 
		
			System.out.println("Number Format Error:  " + e.getMessage());
		}catch(ArithmeticException e) { 
		
			System.out.println("Arithmetic Exception Error detected: " + e.getMessage());
		}catch(Exception e) { // general exception // catch all type of exeception
		
			System.out.println("General  Exception Error : " + e.getMessage());
		}
		
		finally {
			
			//codes  clean up
			//connect to database 
			//close the datbase connection
			
			input.close();
			System.out.println("\nProgram terminated.. ");
		}
	
	
	}

}
