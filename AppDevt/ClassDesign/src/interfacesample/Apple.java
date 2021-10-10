package interfacesample;
public class Apple implements smartphoneinte{
	
	
	

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
	
}
