import java.util.Scanner;

public class ElectricBill {

	public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in);
		System.out.println("Enter the previous reading");
		int prev_r= scnr.nextInt();
		System.out.println("Enter the current reading");
		int cur_r = scnr.nextInt();
		scnr.close();
		
		int reading = cur_r-prev_r;
		float bill_t;
		
		if (reading>100) 
			bill_t = (float) (69+245+(reading-100)*4.6);			
		else {
			reading-=30;
			bill_t = (float) ((reading>0)?69+reading*3.5:(reading+30)*2.3);
		}
		System.out.printf("Bill Amount is %.2f",bill_t);
	}

}
