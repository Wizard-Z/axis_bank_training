package day6.class_assignment.five;

public class Tablet extends Medicine{

	public Tablet() {
		super(13,"25/12/20");
	}
	@Override
	public void displayLabel() {
		super.getDetails();
		System.out.println("TABLET:\nConsume only recommended dose.");
		System.out.println();
	}
	

}
