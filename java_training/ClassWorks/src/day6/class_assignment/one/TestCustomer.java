package day6.class_assignment.one;

public class TestCustomer {

	public static void main(String[] args) {
		Customer cust = new Customer();
		Address addr = new Address("lst Main HSR Layout","Bangalore");
		
		cust.setCustomerName("John");
		cust.setAddr(addr);
		System.out.println("FROM GETTERS");
		System.out.println("NAME: "+cust.getCustomerName());
		System.out.println("ADDRESS: "+cust.getAddr());
		
		Customer cust2 = new Customer("John",addr);
		System.out.println(cust2.getCustomerDetails());
		
		

	}

}
