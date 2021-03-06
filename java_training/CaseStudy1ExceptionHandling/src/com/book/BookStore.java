package com.book;

import java.util.Scanner;

public class BookStore {
	Scanner scnr = new Scanner(System.in);
	public Book[] book;
	// Size of book array
	private int count = 0,size;
	// constructor --> book array init.
	public BookStore(int size) {
		this.size = size;
		book = new Book[size];
	}
	// adding book to Book array
	public void addBook(Book b) {
		if(count<this.size)
			book[count++] = b;
		else
			System.out.println("No space left.");
	}
	
	public void searchByTitle(String title) {
		System.out.println("Searching by title.."+title);
		boolean found = false;// flag variable
		for(int i=0;i<count;i++) {
			if(book[i].getTitle().equals(title)) {
				found = true;
				System.out.println(book[i]);
				
			}
		}
		if(!found)
			System.out.println("Book with title: "+title+" not present.");
		
	}
	public void  searchByAuthor(String author) {
		System.out.println("Searching by author.."+author);
		boolean found = false;
		for(int i=0;i<count;i++) {
			if(book[i].getAuthor().equals(author)) {
				found = true;
				System.out.println(book[i]);
				
			}
		}
		if(!found)
			System.out.println("Book with author "+author+" not present.");
		
	}
	public void displayAll() {
		System.out.println(":Displaying all Books");
		for(int i=0;i<count;i++)
			System.out.println(book[i]);
		
	}
	public void displayBook(String bookId) {
		boolean found = false;
		for(int i=0;i<count;i++) {
			if(book[i].getBookId().equals(bookId)) {
				System.out.println(book[i]);
				found = true;
			}
		}
			if(!found)
				System.out.println("Book with ID: "+bookId+" not present.");
		}

	public void updateBook(String bookId) {
		System.out.println("Updating book Id.."+bookId);
		// For demonstration purpose

		for(int i=0;i<count;i++)
			if(book[i].getBookId().equals(bookId)) {
				System.out.println("Enter new Author");
				String author = scnr.nextLine();
				System.out.println("Enter new title");
				String title = scnr.nextLine();
				book[i].setAuthor(author);
				book[i].setTitle(title);
				System.out.println("Updated entry to --->");
				System.out.println(book[i]);

			}
	}

}
