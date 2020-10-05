package five;

public class Product {
	private String productCode;
	private String productName;
	private double productPrice;
	private char categoryCode;
	private static int prodCounter = 100;
	

	public Product(String productName, double productPrice, char categoryCode) {
		this.productName = productName;
		this.productPrice = productPrice;
		this.categoryCode = categoryCode;
		this.productCode = generateProductCode();
	}
	public Product(String productName, double productPrice) {
		this.productName = productName;
		this.productPrice = productPrice;
		this.categoryCode = 'E';
		this.productCode = generateProductCode();
	}
	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}
	public String getProductCode() {
		return this.productCode;
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
	public char getCategoryCode() {
		return categoryCode;
	}
	public void setCategoryCode(char categoryCode) {
		this.categoryCode = categoryCode;
	}
	public static int getProdCounter() {
		return prodCounter;
	}
	public static void setProdCounter(int prodCounter) {
		Product.prodCounter = prodCounter;
	}
	private String generateProductCode() {
		//prodCounter++;
		return Character.toString(this.categoryCode)+prodCounter++;
	}
	public String getProductDetails() {
		return"Product Code: "+this.productCode+",Name - "+this.productName+",Price - "+this.productPrice+",Category - "+this.productCode;
	}
	

}
