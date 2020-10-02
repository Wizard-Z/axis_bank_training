import java.util.Scanner;

public class Marks {
	public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in);
		System.out.println("Enter Number of Students");
		int n = scnr.nextInt();
		scnr.nextLine();
		System.out.println("Enter marks scored");
		String[] marks = scnr.nextLine().split(" ");
		
		int[] mrks = new int[n];
		for(int i = 0; i<n;i++) 
			mrks[i] = Integer.parseInt(marks[i]);
		scnr.close();
		
		int Min,Max;
		double s=0.0;
		Min=Max=mrks[0];
		for(int mrk:mrks) {
			Min = (Min>=mrk)?mrk:Min;
			Max = (Max<=mrk)?mrk:Max;
			s +=mrk;
		}
		System.out.printf("Minimum marks %d\n",Min);
		System.out.printf("Maximum marks %d\n",Max);
		System.out.printf("Average marks %.2f\n",s/n);
		
	}

}
