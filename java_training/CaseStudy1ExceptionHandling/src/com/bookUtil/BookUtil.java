package com.bookUtil;
import java.util.Scanner;


import com.book.*;
public class BookUtil {
	public static void main(String[] args) {
		System.out.println("CASE STUDY1 exception handling");
		Scanner scnr = new Scanner(System.in);
		BookStore bookStore;
		//Book b;
		
		System.out.println("Book Store size is 3");
		int size = 3;
		bookStore = new BookStore(size);
		
		//Getting details for the bookStore
		System.out.println("Enter details in the sequence\n bookId--title--author--category--price");
		String bookId = null, title = null, author = null, category = null;
		
		float price = 0;
		int count = 0;
		
		printOptions();// Menu.
		int ch;
		boolean flag = true;
		while(flag) {
			System.out.println("Enter choice");
			if(scnr.hasNextInt()) {
				ch = scnr.nextInt();
				scnr.nextLine();}
			else {
				System.out.println("Integers only");
				ch = 0;
				scnr.nextLine();
			}
			
		    
		switch(ch) {
		case 1:if(count<3) {
			System.out.println("Adding in Book Store");
			System.out.println("Entering.."+(count+1));
			System.out.println("Book Id:");
			bookId = scnr.nextLine();
			System.out.println("Title:");
			title = scnr.nextLine();
			System.out.println("Author");
			author = scnr.nextLine();
			System.out.println("Category:");
			category = scnr.nextLine();
			System.out.println("Price:");
			price = scnr.nextFloat();
			scnr.nextLine();
			try {
				bookStore.addBook(new Book(bookId, title, author,category, price));
				count++;
			} catch (InvalidInputException e) {
				System.out.println(e.getMessage());
				//e.printStackTrace();
			}}
		else
			System.out.println("NO space left..");
			break;
		case 2:
			System.out.println("==Searching==\nEnter Title");
			title = scnr.nextLine();
			//System.out.println("Searching.."+title);
			bookStore.searchByTitle(title);
			break;
		case 3:
			System.out.println("==Searching===\nEnter Author");
			author = scnr.nextLine();
			//System.out.println("Searching.."+author);
			bookStore.searchByAuthor(author);
			break;
		case 4:
			System.out.println("==Book Details==");
			bookStore.displayAll();
			break;
		case 5:
			System.out.println("==Update Title and Author==\n Enter...");
			bookId = scnr.nextLine();
			//System.out.println("Updating...."+bookId);
			bookStore.updateBook(bookId);
			break;
		case 0:
			printOptions();
			break;
		case 6:
			flag = false;
			System.out.println("Bye..");
			break;
		default:
			System.out.println("Wrong choice!!");
			printOptions();
		}
		}
		scnr.close();
	}
	
	static void printOptions() {
		System.out.println("0: Print Options\n"
				+ "1: Adding book to book store\n"
				+ "2: Search Book by Title \n"
				+ "3: Search Book by Author \n"
				+ "4: Display all the book details\n" 
				+ "5: Update the title and author of particular Book via ID\n"
				+ "6: Quit\n");
	}

}
