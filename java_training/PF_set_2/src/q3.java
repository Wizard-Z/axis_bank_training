import java.util.Scanner;

public class q3 {
	public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in);
		int num = scnr.nextInt();
		scnr.close();
		
		int d_eq = convertToDecimal(num);
		if (d_eq<0) // -1 returned
			terminate();
		System.out.println(d_eq);
		
	}
	static int convertToDecimal(int num) {
		if (num<0 || num > 11111 )
			return -1;
		int d=0,d_eq = 0, digit;
		while(num>0) {
			digit = num%10;
			if (digit>1)
				return -1;
			d_eq +=Math.pow(2, d)*digit;
			d++;
			num /= 10;
		}
		return d_eq;
	}
	// TO handle invalid input and exit program
	static void terminate() {
		System.out.println("Invalid Input");
		System.exit(0);
	}

}
