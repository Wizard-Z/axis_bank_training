import java.util.Scanner;

public class q9 {
	public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in);
		int n = scnr.nextInt();
		scnr.close();
		if (sumOddDigits(n)==-1) {
			System.out.println("Invalid Input");
			System.exit(0);
		}
		System.out.println(sumOddDigits(n));
	}
	static int sumOddDigits(int n) {
		if (n<0 || n>32767)
			return -1;
		int s=0;
		while(n>0) {
			s += (n%2==0)?0:n%10;
			n /=10;
		}
		return s;
	}

}
