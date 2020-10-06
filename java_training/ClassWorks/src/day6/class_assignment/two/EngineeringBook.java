package day6.class_assignment.two;

public class EngineeringBook extends Book {
	private String category;
	public EngineeringBook() {}
	

	public EngineeringBook(int bookNo, String title, String author, float price,String category) {
		super(bookNo, title, author, price);
		this.category = category;
	}


	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "NAME: "+super.getTitle()+
				"\nBOOK NO: "+super.getBookNo()+
				"\nAuthor: "+super.getAuthor()+
				"\nPrice: "+super.getPrice()+
				"\nCategory: "+this.category;
	}
	

}
