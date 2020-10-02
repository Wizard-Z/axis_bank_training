import java.util.Scanner;

public class a1_cricket_run_rate {

	public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in);
		System.out.println("Enter number of overs bowled so far");
		int overs = scnr.nextInt();
		System.out.println("Enter the current run rate");
		float rr = scnr.nextFloat();
		System.out.println("Enter target score");
		int tscore = scnr.nextInt();
		scnr.close();
		float req_rr = (tscore-(rr*overs))/(50-overs);
		System.out.printf("Required run rate is %.2f ",req_rr);

	}

}
