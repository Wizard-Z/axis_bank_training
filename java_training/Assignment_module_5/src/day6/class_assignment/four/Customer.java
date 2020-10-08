package day6.class_assignment.four;

public class Customer {
	private String customerName;
	private Address residentialAddress;
	private Address officialAddress;
	
	public Address getOfficialAddress() {
		return officialAddress;
	}
	public void setOfficialAddress(Address officialAddress) {
		this.officialAddress = officialAddress;
	}
	public Customer() {
		
	}
	public Customer(String customerName, Address residentialAddress, Address officialAddress) {
		this.customerName = customerName;
		this.residentialAddress = residentialAddress;
		this.officialAddress = officialAddress;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getAddr() {
		return residentialAddress.getAddressDetails();
	}
	public void setAddr(Address addr) {
		this.residentialAddress = addr;
		
	}
	public String getCustomerDetails() {
		return "Customer: "+this.customerName+"\n"
				+"Residential Address: "+this.residentialAddress.getAddressDetails()
				+"\nOfficial Address: "+this.officialAddress.getAddressDetails();
	}
	
	

}
