package two;
/*
 * Usage of setter and getter in java
 */
public class TestProduct {

	public static void main(String[] args) {
		Product prodObj = new Product();
		prodObj.setProductCode("P101");
		prodObj.setProductName("Laptop");
		prodObj.setProductPrice(45000.00);
		System.out.printf("Product Code  : %s\nProduct Name  : %s"
				+ "\nProduct Price  : %.2f",prodObj.getProductCode()
				,prodObj.getProductPrice(),prodObj.getProductPrice());
	}

}
