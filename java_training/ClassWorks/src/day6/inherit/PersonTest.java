package day6.inherit;
/*
 * to string and equals overiding concept
 * 
 */

public class PersonTest {
	public static void main(String[] args) {
		Persoon p1 = new Persoon("AMIT",28);
		Persoon p2 = new Persoon("AMIT",28);
		System.out.println("P1"+p1);
		System.out.println("P2"+p2);
	}

}
class Persoon{
	private String name;
	private int age;
	public Persoon() {
		
		
	}
	public Persoon(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}
	
}
