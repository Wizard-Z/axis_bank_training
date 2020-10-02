import java.util.Scanner;

public class q8 {
	public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in);
		int n = scnr.nextInt();
		if(n<=0 || n>32767) {
			System.out.println("Invalid Input");
			System.exit(0);
		}
		scnr.close();
		System.out.printf("%.2f",findAverageBy5s(n));
		
	}
	static float findAverageBy5s(int n) {
		int s=0;
		for(int i=1;i<=n/5;i++)
			s += i*5;
		return (float)(s*1.0/(n/5));
	}

}
