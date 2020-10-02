import java.util.Scanner;

public class q7 {
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
		scnr.close();
		
		System.out.println(passCount(arr, size));
	}
	static int passCount(int[] arr, int size) {
		int c=0;
		for (int i=1; i<size; i+=2)
			c+= (arr[i]>=70)?1:0;
		return c;
	}
	static void terminate(String e) {
		System.out.println(e);
		System.exit(0);
	}

}
