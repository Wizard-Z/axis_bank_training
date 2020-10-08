import java.util.Scanner;

//check for leap years
public class q22 {
	public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in);
		int year = scnr.nextInt();
		scnr.close();
		int flag = checkLeapYear(year);
		if(flag ==1)
			System.out.println("Yes");
		if(flag == -1)
			System.out.println("Invalid Input");
		if(flag == 0)
			System.out.println("No");
	}
	static int checkLeapYear(int year) {
		if(year<0)
			return -1;
		if(year%4==0) {
			if(year%100==0) {
				if(year%400==0)
					return 1; //centurian and leap
				else
					return 0; // not leap but centurian
			}
			return 1;// non centurian but leap
		}
		else
			return 0;//non leap 		
	}


}
