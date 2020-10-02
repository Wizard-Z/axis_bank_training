import java.util.Scanner;

public class q4 {
	public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in);
		int num = scnr.nextInt();
		scnr.close();
		int prod = productDigits(num);
		System.out.println((prod ==-1)?"Invalid Input":prod);
	}
	static int productDigits(int num) {
		if (num<0)
			return -1;
		int p=1;
		while(num>0) {
			p*=num%10;
			num /= 10;
		}
		return (p>32767)?-1:p;
	}

}
