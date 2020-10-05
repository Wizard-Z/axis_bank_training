package five;

public class TestProduct {

	public static void main(String[] args) {
		Product prodObj = new Product("Laptop", 41000.00, 'E');
		System.out.println("P1:"+prodObj.getProductDetails());
		
		Product prodObj1 = new Product("LAPTOP", 47999);
		System.out.println("P2:"+prodObj1.getProductDetails());
	}

}
