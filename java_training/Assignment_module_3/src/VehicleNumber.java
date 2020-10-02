import java.util.Scanner;

public class VehicleNumber {

	public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in);
		int start = scnr.nextInt();//considering valid inputs
		int end = scnr.nextInt();
		scnr.close();
		
		for(int i=start; i<=end; i++) {
			if(sum9(i))
				System.out.println(i);
		}

	}
	static boolean sum9(int n) {
		// to check if sum of digit is 9
		int s=0;
		while(n>0) {
			s+=n%10;
			n /=10;
		}
		return (s==9)?true:false;
	}

}
