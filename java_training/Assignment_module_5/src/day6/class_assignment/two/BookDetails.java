package day6.class_assignment.two;

import java.util.Scanner;

public class BookDetails {
	public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in);
		System.out.println("Book No:");
		int bookNo = scnr.nextInt();
		scnr.nextLine();
		System.out.println("Title: ");
		String title = scnr.nextLine();
		System.out.println("Author:");
		String author = scnr.nextLine();
		System.out.println("Price: ");
		float price = scnr.nextFloat();
		scnr.close();
		System.out.println("BOOK");
		Book book = new Book(bookNo, title, author, price);
		
		System.out.println(book);
		System.out.println("Engg book");
		String category = "ENG.";
		
		EngineeringBook eng_book = new EngineeringBook(bookNo, title, author, price,category);
		System.out.println(eng_book);
		
		bookNo = 12312;
		EngineeringBook eng_book2 = new EngineeringBook(bookNo, title, author, price,category);
		System.out.println(eng_book2);
	}

}
