package day6.class_assignment.one;

public class Customer {
	private String customerName;
	private Address addr;
	public Customer() {
		
	}
	public Customer(String customerName, Address addr) {
		this.customerName = customerName;
		this.addr = addr;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getAddr() {
		return addr.getAddressDetails();
	}
	public void setAddr(Address addr) {
		this.addr = addr;
		
	}
	public String getCustomerDetails() {
		return "Customer: "+this.customerName+"\n"
				+"Residential Address: "+this.addr.getAddressDetails();
	}
	
	

}
