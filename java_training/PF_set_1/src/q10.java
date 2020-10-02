import java.util.Scanner;

public class q10 {

	public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in);
		int n = scnr.nextInt();
		if(n<0) {
			System.out.println("Number too small");
			System.exit(0);
		}
		if(n>32767) {
			System.out.println("Number too large");
			System.exit(0);
		}
		scnr.close();
		int x = powerOfTwo(n);
		if(x==1)
			System.out.println("Yes");
		else
			System.out.println("No");

	}
	static int powerOfTwo(int n) {
		int count = 0;
		while (n>0) {
			count +=n&1;
			n = n>>1;
		}
		return count;
	}

}
