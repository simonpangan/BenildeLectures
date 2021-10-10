
public class Book {
	
	private int ISBNnumber;
	private String Booktitle;
	
	private String Edition;
	private String Author;
	private String Publisher;
	
	// constructor
	public Book() {
		
	}
	public Book( int ISBNnumber, String Booktitle, String Edition,
	 String Author,String Publisher) {
		
	 this.ISBNnumber =  ISBNnumber;
	 this.Booktitle= Booktitle;

	 this.Edition =Edition;
	 this.Author = Author;
	 this.Publisher= Publisher;
	}
	
	
	
	public int getISBNnumber() {
		return ISBNnumber;
	}
	public void setISBNnumber(int iSBNnumber) {
		ISBNnumber = iSBNnumber;
	}

	public String getBooktitle() {
		return Booktitle;
	}
	public void setBooktitle(String booktitle) {
		Booktitle = booktitle;
	}
	public String getEdition() {
		return Edition;
	}
	public void setEdition(String edition) {
		Edition = edition;
	}
	public String getAuthor() {
		return Author;
	}
	public void setAuthor(String author) {
		Author = author;
	}
	public String getPublisher() {
		return Publisher;
	}
	public void setPublisher(String publisher) {
		Publisher = publisher;
	}

	
	

}
