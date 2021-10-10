import java.util.ArrayList;
import java.util.Scanner;

public class ChildBook {

	public static void main(String[] args) {
		
		 Scanner reader = new Scanner(System.in);
		 
		 
		 
		 
		 ArrayList<Book> book=new ArrayList<Book>();  
		 
		String input = "";
		do {
			
			
			   System.out.println("a. Add");
			   System.out.println("b. List");
			   System.out.println("c. Delete");
			   System.out.println("x. Exit");
			   
			   System.out.println("");
			   System.out.print(" Enter Your Choice: " );
			   
			   input = reader.nextLine();
			   
			   
			   if(input.equals("x"))
			   {
				   System.out.println("Thank you for using application! :) " );
			   }else {
				   
					   System.out.println("");
					   
					   
					   switch(input) {
					   case "a":
						   
						   int  ISBN;
						   String booktitle;
						   String edition;
						   String author;
						   String publisher;
						   
						   System.out.print(" Enter ISBN: " );
						   ISBN = Integer.parseInt(reader.nextLine()); 
						   
						   
						   System.out.print(" Enter Book Title: " );
						   booktitle = reader.nextLine();
						 
						   System.out.print(" Enter Edition: " );
						   edition = reader.nextLine();
						   System.out.print(" Enter Author: " );
						   author = reader.nextLine();
						   System.out.print(" Enter Publisher: " );
						   publisher = reader.nextLine();
						   
												 
						   book.add(new Book(ISBN,booktitle,edition,author,publisher));
					
					     break;
					   case "b":
						   
							
						   System.out.println();
						   
						   if(book.size() == 0 ) {
							   System.out.println(" You don't have list ");
						   }else {
							   for (var number: book) {
								      System.out.println(number.getISBNnumber() + " " 
								    		 + number.getBooktitle()+ " "
								    		 + number.getEdition() + " "
								    		 + number.getAuthor() + " "
								    		 + number.getPublisher());
								    }

							   System.out.println(" ");
								
						   }
						 
						   reader.nextLine();
						   System.out.flush();
					     break;
					   case "c":
						   System.out.print(" Enter index to delete : " );
						   int temp = reader.nextInt();
						   
						   book.remove(temp);
						     break;
					
					 } 
			   }			
		}while(!input.equals("x"));
				
				

	}

}
