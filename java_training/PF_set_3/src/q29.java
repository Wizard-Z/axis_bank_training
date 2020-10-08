import java.util.Scanner;

public class q29 {
	public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in);
		int n = scnr.nextInt();
		if(n<0)
			terminate("Number too small");
		if(n>32767)
			terminate("Number too large");
		scnr.close();
		
		System.out.println(newNumber(n));
	}
	
	static int newNumber(int n) {
		int c=0;// counter
		int newN=0;
		while(n>0) {
			newN += (n%10+2)*Math.pow(10, c);
			c++;
			n /= 10;
		}
		return newN;
		
	}
	static void terminate(String e) {
		System.out.println(e);
		System.exit(0);
	}

}
