
public class AppleIphone12 extends AppleIphone11{ //multilevel
	//extendd SmartPhone =  hierarchihal inheritance 
	
	// the purpose of multilevel inheritance is that there is some instances that the method 
	// is in the class b and  not in the parent  class thus the
	// only way to get it is  through the class B so we need to extendd class B instead Parentclass
	

	public static void main(String[] args) {
		
		AppleIphone12 ip = new AppleIphone12();
		ip.ipExecute();
	}

	public void ipExecute() {
		setBrand("Samsung");
		setModel("Black");
		
		System.out.println(getBrand());
		System.out.print(getModel());
		
		System.out.println();
		
		sendTextMesage("The quick brown fox");
		initiateCall("09474411444");
		
		
		
	}
}
