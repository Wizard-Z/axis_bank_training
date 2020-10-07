package four;

import java.util.Scanner;

public class TestAgeCalculator2 {
	public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in);
		
		System.out.println("Enter DOB");
		String dob = scnr.nextLine();
		int res = 0;
		try {
			res = AgeCalculator2.calculateAge(dob);
			System.out.println(res);
		}
		catch(InvalidDOBException e) {
			System.out.println(e.getMessage());
		}
		catch (Exception e) {
			System.out.println("Date of birth should be in dd/mm/yyyy format.");
		}
		
	}

}
