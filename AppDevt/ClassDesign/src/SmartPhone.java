
 public abstract class SmartPhone { //final public class 
							// a final class cannot be extended
							// preventing the class to being subclass to alter base behavior
	private String brand;
	private String model;
	
	public SmartPhone (){
		this.brand = "Samsung";
		this.brand = "Note 40 ProMax";
		
	}
	
	public SmartPhone (String brand, String model){
		this.brand = brand;
		this.model = model;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public void sendTextMesage(String message) {
		System.out.print("Text message sent: " + message);
	}
	public void initiateCall(String phoneNumber)
	{
		System.out.print("Initiate outbout call to : " + phoneNumber);
	}
	public abstract void launchDefaultBrowser(String name);
}
