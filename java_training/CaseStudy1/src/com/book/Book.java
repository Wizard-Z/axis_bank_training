package com.book;

public class Book {
	private String bookId;
	private String title;
	private String author;
	private String category;
	private float price;
	// Parameterized Constructor
	
	public Book(String bookId, String title, String author, String category, float price) {
		// check
		if (bookId.length()==4 && bookId.charAt(0) == 'B')
			this.bookId = bookId;
		else
			System.out.println(":Invalid Book Id:");
		this.title = title;
		this.author = author;
		// check
		if(category.equals("Science") || category.equals("Fiction") || category.equals("Technology") || category.equals("Others"))
			this.category = category;
		else 
			System.out.println(":Invalid Category:");
		
		if(!(price<0))
			this.price = price;
		else {
			System.out.println(":Price cannot be Negative:");
			this.price = 0;
		}
		
	}

	public String getTitle() {
		return this.title;
	}
	public String getAuthor() {
		return this.author;
	}

	public String getBookId() {
		return bookId;
	}

	public void setBookId(String bookId) {
		if (bookId.length()==4 && bookId.charAt(0) == 'B')
			this.bookId = bookId;
		else
			System.out.println(":Invalid Book Id:");
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		if(category.equals("Science") || category.equals("Fiction") || category.equals("Technology") || category.equals("Others"))
			this.category = category;
		else 
			System.out.println(":Invalid Category:");
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setAuthor(String author) {
		this.author = author;
	}
	@Override
	public String toString() {
		return "Book [bookId=" + bookId + ", title=" + title + ", author=" + author + ", category=" + category
				+ ", price=" + price + "]";
	}	

}
