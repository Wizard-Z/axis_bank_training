package two;

import java.util.Scanner;

public class TestCustomer {
	public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in);
		Customer cust;
		System.out.println("Enter Details");
		System.out.println("Customer Number:");
		String custNo = scnr.nextLine();
		System.out.println("Customer name:");
		String custName = scnr.nextLine();
		System.out.println("Enter category");
		String category = scnr.nextLine();
		scnr.close();
		
		try {
			cust = new Customer(custNo, custName, category);
			System.out.println(cust);
		}
		catch(InvalidInputException e) {
			System.out.println(e.getMessage());
		}
		
		
	}

}
