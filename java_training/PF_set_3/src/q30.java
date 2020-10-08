import java.util.Scanner;

/*
 * Find Mileage	
 */
public class q30 {
	public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in);
		int cc = scnr.nextInt();
		scnr.close();
		if (cc>220)
			terminate("Number too large");
		if (cc<100)
			terminate("Number too small");

		if(cc>200)
			terminate("35");
		if(cc>150)
			terminate("50");
		if(cc>135)
			terminate("60");
		if(cc>125)
			terminate("70");
		if(cc>99)
			terminate("75");

	}
	static void terminate(String e) {
		System.out.println(e);
		System.exit(0);
	}
}


