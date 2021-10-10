package interfacesample;

public class Iphone12ProMax extends Apple{

	public static void main(String[] args) {
		
		Iphone12ProMax ip12 = new Iphone12ProMax();
		ip12.executeProcess();

	}
	
	
	public void executeProcess() {
		sendTextMesage("iloveyou");
		initiateCall("ilove you");
	}

}
