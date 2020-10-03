import java.util.Scanner;

public class q10 {
	static int[] output1;
	public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in);
		int size = scnr.nextInt();
		if (size<0)
			terminate();
		int[] n1 = new int[size];
		int[] n2 = new int[size];
		// n1 array
		for(int i=0;i<size;i++) {
			n1[i] = scnr.nextInt();
			if(n1[i]<0)
				terminate();
		}
		// n2 array
		for(int i=0;i<size;i++) {
			n2[i] = scnr.nextInt();
			if(n2[i]<0)
				terminate();
		}
		scnr.close();
		
		largestArray(n1, n2, size);
		for(int n:output1)
			System.out.println(n);
		
	}
	static void largestArray(int[] n1, int[] n2, int size) {
		output1 = new int[size];
		for(int i=0;i<size;i++) 
			output1[i] = (n1[i]>=n2[i])?n1[i]:n2[i];
			
	}
	static void terminate() {
		System.out.println("Invalid Input");
		System.exit(0);
	}

}
