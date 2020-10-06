package day6.class_assignment.five;

public class TestMedicine {
	public static void main(String[] args) {
		Medicine[] medicine = new Medicine[5];
		int ch;
		int min = 1;
		for(int i=0;i<5;i++) {
			ch = (int)(Math.random() * 3) + min;
			switch (ch) {
			case 1:
				medicine[i] = new Tablet();
				break;
			case 2:
				medicine[i] = new Syrup();
				break;
			case 3:
				medicine[i] = new Ointment();
				break;
			default:
				System.out.println("oops!");
			}
		}
		for(Medicine med:medicine)
			med.displayLabel();
	}

}
