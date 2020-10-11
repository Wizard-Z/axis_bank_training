package com.manipal.util;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.InputMismatchException;
import java.util.Scanner;

import com.manipal.exception.InvalidBookException;
import com.manipal.model.Book;
import com.manipal.store.BookStore;

public class BookUtil {
	public static void main(String[] args) {
		System.out.println("In BookUtil class.. ");
		Scanner scnr = new Scanner(System.in);
		System.out.println("Initialize!!");
		BookStore bs = new BookStore();
		String bid,title,author = null,category = null;
		double price;
		printOptions();
		
		boolean flag = true;
		int ch, count=1;
		
		while(flag) {
			System.out.println("Enter Choice::");
			try {
				ch = scnr.nextInt();
			}catch(InputMismatchException e) {
				System.out.println("Again!");
				ch=0;
			}
			scnr.nextLine();
			switch(ch) {
			case 1:
				if(count<=3) {
					try {
						System.out.println("BOOK-"+count);
						System.out.println("Enter bookId:");
						bid = scnr.nextLine();
						System.out.println("Enter Title: ");
						title = scnr.nextLine();
						System.out.println("Enter Author: ");
						author = scnr.nextLine();
						System.out.println("Enter Category: ");
						category = scnr.nextLine();
						System.out.println("Enter price: ");
						price = scnr.nextDouble();
						scnr.nextLine();
						bs.addBook(new Book(bid, title, author, category, price));
						count++;
					
					}catch (InvalidBookException e) {
						System.out.println(e.getMessage());
					}
					catch(InputMismatchException e) {
						System.out.println("Something is not right!!");
					}
				}
				else
					System.out.println("Store full!!");
				break;
			case 2:
				System.out.println("Enter Book Id");
				try {
					bs.updateBook(scnr.nextLine());
				} catch (InvalidBookException e) {
					System.out.println(e.getMessage());
				}
				break;
			case 3:
				System.out.println("Delete Book via ID");
				bs.deleteBook(scnr.nextLine());
				count--;
				break;
			case 4:
				System.out.println("Enter title to be searched");
				bs.searchByTitle(scnr.nextLine());
				break;
			case 5:
				System.out.println("Enter author whose book to search");
				bs.searchByAuthor(scnr.nextLine());
				break;
			case 6:
				System.out.println("Displaying all Book..");
				bs.displayAll();
				break;
				
			case 7:
				System.out.println("Enter file name");
				String fname = scnr.nextLine();
				try {
					ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fname));
					oos.writeObject(bs);
					oos.close();
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case 8:
				System.out.println("Reading Book Store Object");
				System.out.println("Enter File name");
				String file = scnr.nextLine();
				try {
					ObjectInputStream oin = new ObjectInputStream(new FileInputStream(file));
					BookStore b = (BookStore) oin.readObject();
					System.out.println("Displaying BookStore");
					b.displayAll();
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					System.out.println("File not there!");
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					System.out.println("Somewrong!");
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					System.out.println("Class not there");
					e.printStackTrace();
				}
				
				
			case 0:
				printOptions();
				break;
			case 9:
				flag=false;
				break;
			default:
				System.out.println("wrong choice");
				printOptions();
			}
		}
		scnr.close();
	}


static void printOptions() {
	System.out.println("1: Add book to store:\n"
			+"2: Update Book via ID\n"
			+"3: Delete Book via ID\n"
			+"4: Search By Title\n"
			+"5: Search By Author\n"
			+"6: Display all books\n"
			+"7: Store details to file\n"
			+"8: Read from file\n"
			+"0: Show Options\n"
			+"9: Quit!");
}

}
