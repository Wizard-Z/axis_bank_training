import java.util.Scanner;
import java.util.Arrays;

/*
 * Input a array and . delete a number and sort the array
 */
public class q28 {
	static int[] output1;
	public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in);
		int size = scnr.nextInt();
		if (size<0)
			terminate("Invalid array size");
		int[] arr = new int[size];
		for(int i=0; i<size; i++) {
			arr[i] = scnr.nextInt();
			if (arr[i]<0)
				terminate("Invalid Input");
		}
		int n = scnr.nextInt();
		if(n<0)
			terminate("Invalid Input");
		scnr.close();
		sort_delete(arr, n);
		//System.out.println("---");
		for(int i: output1)
			System.out.println(i);
		
		
	}
	static void sort_delete(int[] arr, int n) {
		/*
		 * GET SIZE OF ARRAY WITHOUT THE element to be deleted
		 * add it to global array
		 * sort it
		 */
		int c=0;
		for(int i:arr) {
			if(i!=n)
				c++;
		}
		output1 = new int[c];
		c=0;
		for(int i:arr) {
			if(i!=n) {
				output1[c] = i;// add to global array
				c++;}
		}
		//System.out.println(Arrays.toString(output1)+":::"+c);
		Arrays.sort(output1);
	}
	static void terminate(String e) {
		System.out.println(e);
		System.exit(0);
	}

}
