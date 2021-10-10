package oop2;

public abstract class classA {
	
	//nonabstract method
	
	public void method1() {
		System.out.println("This is method1() from Class A");
	}
	
	public void method2()
	//implementation detail
	{
		System.out.println("This is method2() from Class A");
	}
	//
	
	
	
	//abstract method is a method that has no implementation detail;
	public abstract String method3(String message);
	
	
}
