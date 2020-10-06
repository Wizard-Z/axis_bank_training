package com.book;

public class BookStore {
	public Book[] book;
	private int count = 0;
	public BookStore(int size) {
		book = new Book[size];
	}
	
	public void addBook(Book b) {
		book[count] = b;
		count++;		
	}
	
	public void searchByTitle(String title) {
		System.out.println("Searching by title.."+title);
		for(Book b: book) {
			if(b.getTitle().equals(title))
				System.out.println(b);
			break;
		}
		
	}
	public void  searchByAuthor(String author) {
		System.out.println("Searching by author.."+author);
		for(Book b: book) {
			if(b.getAuthor().equals(author))
				System.out.println(b);
			break;
		}
		
	}
	public void displayAll() {
		System.out.println(":Displaying all Books");
		for(Book b:book)
			System.out.println(b);
		
	}
	public void updateBook(String bookId) {
		System.out.println("Updating book Id.."+bookId);
		int size = book.length;
		for(int i=0;i<size;i++)
			if(book[i].getTitle().equals(bookId)) {
				book[i].setAuthor("NEW AUTHOR");
				book[i].setTitle("NEW TITLE");
			}
	}

}
