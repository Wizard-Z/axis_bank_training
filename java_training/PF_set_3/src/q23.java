import java.util.Scanner;

public class q23 {
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
		System.out.println(second_Largest(arr));
	}
	static int  second_Largest(int[] arr) {
		int max= 0 , s_max = 0;
		for(int n:arr) {
			if(n>max) {
				s_max = max;
				max = n;
			}
			if(n<max && n>s_max)
				s_max = n;
		}
		return s_max;
		
	}
	static void terminate(String e) {
		System.out.println(e);
		System.exit(0);
	}

}
