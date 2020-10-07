package com.book;

public class Book {
	private String bookId;
	private String title;
	private String author;
	private String category;
	private float price;
	// Parameterized Constructor
	
	public Book(String bookId, String title, String author, String category, float price) throws InvalidInputException{
		// check
		if((bookId.length()==4 &&
			bookId.charAt(0)=='B')) {
			this.bookId = bookId;
		}
		else 
			throw new InvalidInputException("Wrong Book id.");
		
		if(category.equals("Science") || category.equals("Fiction") ||
				category.equals("Technology") || category.equals("Others")){
			this.category = category;
		}
		else
			throw new InvalidInputException("Wrong book Category");
		if(price>=0) {
			this.price = price;
		}
		else
			throw new InvalidInputException("Wrong book price");
		this.title = title;
		this.author = author;
		System.out.println("Book created");		
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

	public void setBookId(String bookId) throws InvalidInputException {
		if (bookId.length()==4 && bookId.charAt(0) == 'B')
			this.bookId = bookId;
		else
			throw new InvalidInputException(":Invalid Book Id:");
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category)throws InvalidInputException {
		if(category.equals("Science") || category.equals("Fiction") || category.equals("Technology") || category.equals("Others"))
			this.category = category;
		else 
			throw new InvalidInputException(":Invalid Category:");
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
