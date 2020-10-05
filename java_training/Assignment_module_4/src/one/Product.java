package one;

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

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public double getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}

	@Override
	public String toString() {
		return ("Product Code : " + productCode + "\nProduct Name : " + productName + "\nProduct Price : " + productPrice);
	}
	
}

