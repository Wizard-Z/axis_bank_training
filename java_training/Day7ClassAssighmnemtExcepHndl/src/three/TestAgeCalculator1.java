package three;

import java.text.ParseException;
//import java.text.ParseException;
import java.util.Scanner;

public class TestAgeCalculator1 {
	public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in);
		
		System.out.println("Enter DOB");
		String dob = scnr.nextLine();
		int res = 0;
		try {
			res = AgeCalculator1.calculateAge(dob);
			System.out.println(res);
		}
		catch (ParseException e) {
			System.out.println("Date of birth should be in dd/mm/yyyy format.");
		}
		
	}

}
