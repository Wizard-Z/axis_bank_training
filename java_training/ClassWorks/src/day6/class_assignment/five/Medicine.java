package day6.class_assignment.five;

public abstract class Medicine {
	public int price;
	public String expDate;
	public Medicine(int price, String expDate) {
		this.price=price;
		this.expDate=expDate;
	}
	public void getDetails() {
		System.out.println("Price: "+this.price);
		System.out.println("Expiry: "+this.expDate);
	}
	public abstract void displayLabel();

}
