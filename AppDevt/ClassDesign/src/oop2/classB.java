package oop2;

public class classB extends classA{

	public static void main(String[] args){

		classB b = new classB();
		b.executeProcess();
	
		
	}
	
	public void executeProcess() {
		method1();
		method2();
		
		System.out.println(method3("i love you"));
	}
	@Override
	public String method3(String message) {
		return "method3() from class B " + message;
	}
}
