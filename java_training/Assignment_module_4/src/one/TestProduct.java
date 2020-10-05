package one;

public class TestProduct {

	public static void main(String[] args) {
		Product prodObj = new Product();
		System.out.println(prodObj);// with default constructor
		Product prodObj2 = new Product("P101","Laptop",45000.00);
		System.out.println("Initialized\n"+prodObj2);
		

	}

}
