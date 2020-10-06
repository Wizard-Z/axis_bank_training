package day6.inherit;
class A{
	private int i;
	// if parameterized then must provide a no args constructor
	public A() {
		System.out.println("A constructor");
	}
	A(int i){
		this.i = i;
		System.out.println("PARAMETERIZED CONSTRUCTOR..."+i);
	}
	
}
class B extends A{
	public B() {
		//super(100);
		System.out.println("B constructor");
	}
	B(int i){
		super(i);
		System.out.println("B PARAMETERIZED");
	}
	
}


public class InConstructorDemo {
	public static void main(String[] args) {
		A a = new A();
		B b = new B(41);
		/*
		 * OUTPUT
		A constructor
		PARAMETERIZED CONSTRUCTOR...41
		B PARAMETERIZED
		 */
		
	}


}
