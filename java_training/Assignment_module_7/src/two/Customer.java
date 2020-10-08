package two;

public class Customer {
	private String custNo;
	private String custName;
	private String category;
	
	public String getCustNo() {
		return custNo;
	}

	public void setCustNo(String custNo) {
		this.custNo = custNo;
	}

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Customer(String custNo, String custName, String category)throws InvalidInputException {
		if((custNo.charAt(0)=='c' ||custNo.charAt(0)=='C') &&(custName.length()>=4))
			this.custNo = custNo;
		else
			throw new InvalidInputException("Incorret ID");
		if(custName.length()>=4)
			this.custName = custName;
		else
			throw new InvalidInputException("Incorrect Name");
		if(category.equals("Gold") ||category.equals("Platinum") || category.equals("Silver"))
			this.category = category;
		else
			throw new InvalidInputException("Incorrect Category");
	}

	@Override
	public String toString() {
		return "Customer [custNo=" + custNo + ", custName=" + custName + ", category=" + category + "]";
	}
	

}
