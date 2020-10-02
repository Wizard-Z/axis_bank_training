import java.util.Scanner;

public class q1 {
	public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in);
		int size = scnr.nextInt();
		if(size<=0) {
			System.out.println("Invalid Input");
			System.exit(0);
		}
		int[] arr = new int[size];
		for(int i=0; i<size; i++) {
			arr[i] = scnr.nextInt();
			if(arr[i]<0) {
				System.out.println("Invalid Input");
				System.exit(0);
			}
		}
		scnr.close();
		System.out.println(divisibleBy3(arr, size));
	}
	static int divisibleBy3(int[] arr, int size) {
		int count = 0;
		for(int n:arr)
			count += (n%3==0)?1:0;
		return count;
	}

}
