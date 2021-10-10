package oop2;

public class ProgrammingLanguage implements Language{ //can implement multiple interface  language,language2
					//can only extend one abstract

	
	
	
	
	@Override
	public void setLanguage(String name) {
		
		System.out.println("Programming languege " + name);
		
	}

	@Override
	public void setClientScript(String name) {

		System.out.println("Client Side Script " + name);	
	}
}
