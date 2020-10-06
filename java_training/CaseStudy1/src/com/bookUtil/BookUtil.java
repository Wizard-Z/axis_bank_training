package com.bookUtil;
import java.util.Scanner;

import com.book.*;
public class BookUtil {
	public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in);
		BookStore bookStore;
		//Book b;
		System.out.println("Enter 3 Books");
		int size = 3;
		bookStore = new BookStore(size);
		System.out.println("Enter details in the format\n bookId, title, author, category, price");
		String bookId = null, title = null, author = null, category = null;
		float price = 0;
		for(int i=0;i<size;i++) {
			System.out.println("Entering.."+(i+1));
			bookId = scnr.nextLine();
			title = scnr.nextLine();
			author = scnr.nextLine();
			category = scnr.nextLine();
			price = scnr.nextFloat();
			scnr.nextLine();
			bookStore.addBook(new Book(bookId, title, author,category, price));
		}
		printOptions();
		int ch;
		boolean flag = true;
		while(flag) {
			System.out.println("Enter choice");
		    ch = scnr.nextInt();
		    scnr.nextLine();
		switch(ch) {
		case 1:
			System.out.println("==Searching==\nEnter Title");
			title = scnr.nextLine();
			//System.out.println("Searching.."+title);
			bookStore.searchByTitle(title);
			break;
		case 2:
			System.out.println("==Searching===\nEnter Author");
			author = scnr.nextLine();
			//System.out.println("Searching.."+author);
			bookStore.searchByAuthor(author);
			break;
		case 3:
			System.out.println("==Book Details==");
			bookStore.displayAll();
			break;
		case 4:
			System.out.println("==Update Title and Author==\n Enter...");
			bookId = scnr.nextLine();
			//System.out.println("Updating...."+bookId);
			bookStore.updateBook(bookId);
			break;
			
		case 5:
			bookStore.displayAll();
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
				+ "1: Search Book by Title \n"
				+ "2: Search Book by Author \n"
				+ "3: Display all the book details\n" 
				+ "4: Update the title and author of particular Book via ID\n"
				+ "5: Display details of Updated book\n"
				+ "6: Quit");
	}

}
