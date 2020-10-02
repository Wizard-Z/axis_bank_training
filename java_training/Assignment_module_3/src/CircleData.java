import java.util.Scanner;

public class CircleData {
	public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in);
		System.out.println("Enter the Radius");
		float radius = scnr.nextFloat();
		scnr.nextLine();
		System.out.println("Enter the Output required");
		String out = scnr.nextLine();
		scnr.close();
		
		String temp = "of circle is";
		switch(out) {
		case("DIA"):
			System.out.printf("Diameter %s %.2f",temp,radius*2);
			break;
		case("AR"):
			System.out.printf("Area %s %.2f",temp,3.1415*radius*radius);
			break;
		case("PER"):
			System.out.printf("Perimeter %s %.2f",temp,2*3.1415*radius);
			break;
		case("ARSEM"):
			System.out.printf("Area of Semi Circle is %.2f",3.1415*radius);
			break;
		default:
			System.out.println("INVALID CHOICE");
		}
	}

}
