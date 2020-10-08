package day6.class_assignment.five;

public class Ointment extends Medicine{

	public Ointment() {
		super(123,"31/8/21");
	}
	@Override
	public void displayLabel() {
		super.getDetails();
		System.out.println("Ointment:\nExternal Use Only.");
		System.out.println();
		
	}
	

}

