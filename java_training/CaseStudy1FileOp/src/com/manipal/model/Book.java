package com.manipal.model;

import java.io.Serializable;

import com.manipal.exception.InvalidBookException;

public class Book implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String bookId;
	private String title;
	private String author;
	private String category;
	private double price;

	public Book() {}
	public Book(String bookId, String title, String author, String category, double price) throws InvalidBookException {
		super();
		if (bookId.length()!=4 || !bookId.startsWith("B"))
			throw new InvalidBookException("Invalid Book ID.");
		this.bookId = bookId;
		this.title = title;
		this.author = author;
		if (!(category.equals("Science")||
				category.equals("Fiction")||
				category.equals("Technology")||
				category.equals("Others")))
			throw new InvalidBookException("Invalid Category.");
		this.category = category;
		if (price<=0)
			throw new InvalidBookException("Invalid Price.");
		this.price = price;
	}
	public String getBookId() {
		return bookId;
	}
	public void setBookId(String bookId) throws InvalidBookException {
		if (bookId.length()!=4 || bookId.startsWith("B"))
			throw new InvalidBookException("Invalid Book ID.");
		this.bookId = bookId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) throws InvalidBookException {
		if (!(category.equals("Science")||
				category.equals("Fiction")||
				category.equals("Technology")||
				category.equals("Others")))
			throw new InvalidBookException("Invalid Category.");
		this.category = category;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) throws InvalidBookException {
		if (price<=0)
			throw new InvalidBookException("Invalid Price.");
		this.price = price;
	}
	@Override
	public String toString() {
		return "Book [" + (bookId != null ? "bookId=" + bookId + ", " : "")
				+ (title != null ? "title=" + title + ", " : "") + (author != null ? "author=" + author + ", " : "")
				+ (category != null ? "category=" + category + ", " : "") + "price=" + price + "]";
	}




}
