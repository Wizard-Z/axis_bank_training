package day6.class_assignment.five;

public class Syrup extends Medicine {

	public Syrup() {
		super(999,"12/6/22");
	}
	@Override
	public void displayLabel() {
		super.getDetails();
		System.out.println("SYRUP:\nStore in cool and dry place.");
		System.out.println();
	}
	

}
