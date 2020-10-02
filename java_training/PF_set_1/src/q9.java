import java.util.Scanner;

public class q9 {
	public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in);
		int size = scnr.nextInt();
		if(size<=0) {
			System.out.println("Invalid array size");
			System.exit(0);
		}
		int[] arr = new int[size];
		for(int i=0; i<size; i++) {
			arr[i] = scnr.nextInt();
			if (arr[i]<0) {
				System.out.println("Invalid input");
				System.exit(0);
			}
		}
		int num = scnr.nextInt();
		if(num<0) {
			System.out.println("Invalid input");
			System.exit(0);
		}
		scnr.close();
		
		System.out.println(findElementCount(arr, size, num));
		
	}
	static int findElementCount(int[] arr, int size, int num) {
		int count=0;
		for(int n:arr) 
			count += (num==n)?1:0;
		return count;
	}

}
