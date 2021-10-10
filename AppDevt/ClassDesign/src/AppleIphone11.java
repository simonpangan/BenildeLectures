
public class AppleIphone11 extends SmartPhone{
	
	
	public AppleIphone11 (){
	
		
	}
	
	public AppleIphone11 (String brand, String model){
		
		super(brand,model);  // call the parant constructor class
	}

	public static void main(String[] args) {
		
		/*
		AppleIphone11 ip = new AppleIphone11();
		ip.ipExecute();
		*/
		
		AppleIphone11 ip = new AppleIphone11("Apple","Iphone 11 Pro Max");
		ip.ipExecute();
		
		
		
		
	}
	
	
	

	public void ipExecute() {
		/*
		setBrand("Apple");
		setModel("Blue");
		
		*/
		
		
		//access  class same method   = super class constructor method
		/* 
		System.out.println(getBrand());  
		System.out.print(getModel());
		
		*/
		
		// to access super class method that has the same method as the current classs
		
		System.out.println(super.getBrand());
		System.out.print(super.getModel());
			
		System.out.println();
		
		sendTextMesage("The quick brown fox");
	//	initiateCall("09474411444");
		initiateCall("09474411444" , true);
		
	}
	
	//overrides superclass same method
	
	@Override
	public String getBrand() {
		return "Samsung";
	}
	@Override
	public String getModel() {
		return "A70";
	}
	@Override
	public void sendTextMesage(String message) {
		System.out.println("Text message sent from child class : " + message);
	}
	
	//overloading
	@Override  //if the parent class is final, removing the override method means a local method
	public void initiateCall(String phoneNumber)
	{
		System.out.print("Initiate outbout call from child class to : " + phoneNumber);
	}
	
	public void initiateCall(String phoneNumber, boolean isVideoCall)
	{
		if(isVideoCall == true) {
			System.out.print("Initiate video  call to : " + phoneNumber);

		}else {
			System.out.print("Initiate standard call to  : " + phoneNumber);
			
		}
		
	}

	@Override
	public void launchDefaultBrowser(String url) {
		System.out.print("Launch Default URL to   : " + url	);
	}
	
	
}
