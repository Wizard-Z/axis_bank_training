package three;

public class Product {
	private String productCode;
	private String productName;
	private double productPrice;
	
	public Product() {
	}

	public Product(String productCode, String productName, double productPrice) {
		super();
		this.productCode = productCode;
		this.productName = productName;
		this.productPrice = productPrice;
	}
	public void displayProductDetails() {
		System.out.printf("Product Code : %s \nProduct Name : %s \nProduct Price : %.2f",this.productCode,this.productName,this.productPrice);
	}

}
