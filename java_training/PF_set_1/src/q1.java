import java.util.Scanner;

public class q1 {
	public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in);
		int salary = scnr.nextInt();
		int shifts = scnr.nextInt();
		scnr.close();
		
		boolean flag = false;
		if (salary<=0) {
			System.out.println("Salary too small");
			flag = true;}
		if (salary>8000) {
			System.out.println("Salary too large");
			flag = true;}
		if (shifts <0) {
			System.out.println("Shifts too small");
			flag = true;}
		
		if (!flag)
		System.out.println(calculateSal(salary, shifts)); 
		
	}
	static int calculateSal(int salary, int shifts) {
		return (int) (salary*0.5+ 0.02*shifts*salary); 
	}

}
