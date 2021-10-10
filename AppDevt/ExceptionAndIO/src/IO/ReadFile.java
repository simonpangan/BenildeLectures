package IO;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ReadFile {

	public static void main(String[] args) {
	
		BufferedReader reader = null;
		
		int total = 0;
		
		
		try {
			
			reader = new BufferedReader(new FileReader("C:\\Javabuffered\\Numbers.txt"));
			String line = null;
			
			while((line = reader.readLine())!= null) {
				
				String arr[] = line.split(" ");
				 System.out.print(line + " ");
//				 total += Integer.parseInt(line);
				 total += Integer.parseInt(arr[1]);
			}
			
			System.out.print("\n The sum is " + total);
			
		}catch(FileNotFoundException e) {
			 System.out.println("File Not Found Exception " + e.getMessage());
		}catch(IOException e) {
			 System.out.println("I/O Exception " + e.getMessage());
		}catch(NumberFormatException e) {
			 System.out.println("Invalid Number Format" + e.getMessage());
		}
		
			
	}


}
