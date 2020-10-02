import java.util.Scanner;

public class q6 {

	public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in);
		int F = scnr.nextInt();
		scnr.close();
		if(F<0) {
			System.out.println("Invalid Input");
			System.exit(0);
		}
			
		System.out.printf("%.2f",convertToCentigrade(F));
	}
	static float convertToCentigrade(int F) {
		return (float) ((F-32)*(5.0/9.0));
	}

}
