package com.manipal.store;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import com.manipal.exception.InvalidBookException;
import com.manipal.model.*;
public class BookStore implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<Book> arr;
	public BookStore() {
		arr = new ArrayList<>();
		System.out.println("BooKStore Initialized...");
	}
	public void addBook(Book b) {
		arr.add(b);
		System.out.printf("Book %s -added-\n",b.getBookId());
	}
	public void updateBook(String bookId) throws InvalidBookException {
		System.out.printf("Searching...%s\n",bookId);
		boolean found = false;
		for(Book bb:arr) {
			if(bb.getBookId().compareTo(bookId)==0) {
				found = true;
				System.out.println("Details: "+bb);
				System.out.println("What to update!!\n"
						+"1: Title\n"
						+"2: Author\n"
						+"3: Category\n"
						+"4: Price\n");
				Scanner scnr2 = new Scanner(System.in);
				int ch = scnr2.nextInt();
				scnr2.nextLine();
				switch(ch) {
				case 1: 
					System.out.println("New Title");
					bb.setTitle(scnr2.nextLine());
					break;
				case 2:
					System.out.println("New Author");
					bb.setAuthor(scnr2.nextLine());
					break;
				case 3:
					System.out.println("New Category");
					bb.setCategory(scnr2.nextLine());
					break;
				case 4:
					System.out.println("New Price");
					bb.setPrice(scnr2.nextInt());
					break;
				default:
					System.out.println("wrong choice.. no update!");
				}
				//scnr2.close();
				System.out.println("Updated Detail: "+bb);
			}
		}
		if(!found)
			System.out.println("Book not there :(");
	}

	public void deleteBook(String bookId) {
		boolean found = false;
		Iterator<Book> iter = arr.iterator();
		System.out.println("Deleting... "+bookId);
		Book b;
		while(iter.hasNext()) {
			b = iter.next();
			if(b.getBookId().compareTo(bookId)==0) {
				System.out.println("Book to remove: "+b);
				iter.remove();
				found = true;
			}
		}
		if(!found)
			System.out.println("Book not there :(");
	}

	public void searchByTitle(String title) {
		boolean found = false;
		for(Book bb:arr) {
			if(bb.getTitle().compareTo(title)==0) {
				found = true;
				System.out.println("Book Found: "+bb);
			}
		}
		if(!found)
			System.out.println("Book not present!");
	}

	public void searchByAuthor(String author) {
		boolean found = false;
		for(Book bb:arr) {
			if(bb.getAuthor().compareTo(author)==0) {
				found = true;
				System.out.println("Book Found: "+bb);
			}
		}
		if(!found)
			System.out.println("Book not present!");
	}

	public void displayAll() {
		System.out.println("Displaying Books!");
		for(Book b:arr)
			System.out.println(b);
		System.out.println("-End of Store-");
	}


}
