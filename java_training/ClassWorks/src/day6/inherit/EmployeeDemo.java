package day6.inherit;


class Person{
	String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
class Employee extends Person{
	private double salary;

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}
	
}
class Student extends Person{
	private int std;

	public int getStd() {
		return std;
	}

	public void setStd(int std) {
		this.std = std;
	}
	
}
class Manager extends Employee{

/*
 * Hierarchial inheritance
 */
}
public class EmployeeDemo {
	
	public static void main(String[] args) {
	Employee emp = new Employee();	
	emp.setName("NAME");
	emp.setSalary(999999.99);
	System.out.println("EMP:"+emp.getName()+"\n"+emp.getSalary());
	Student stu = new Student();
	stu.setName("STU NAME");
	stu.setStd(12);
	System.out.println("STU: "+stu.getName()+"\n"+stu.getStd());
	}

}
