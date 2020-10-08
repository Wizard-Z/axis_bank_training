package day6.class_assignment.four;

public class TestCustomer {

	public static void main(String[] args) {

		Address residentialAddress = new Address("lst Main HSR Layout","Bangalore");
		Address officialAddress = new Address("lst Main Electronics City","Bangalore");
		
		Customer cust = new Customer("John", residentialAddress, officialAddress);
		System.out.println(cust.getCustomerDetails());
		
		

	}

}
