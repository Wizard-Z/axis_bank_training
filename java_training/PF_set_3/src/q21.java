import java.util.Scanner;
// Given an array return the sum of prime numbers present in it
public class q21 {
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
		System.out.println(sumPrime(arr, size));
}
	static int sumPrime(int[] arr, int size) {
		int s=0;
		for(int n:arr)
			s+=(checkPrime(n))?n:0;
		return s;
	}
	static boolean checkPrime(int n) {
		if (n==2||n==3)
			return true;
		for(int i=2;i<=Math.sqrt(n);i++) {
			if(n%i==0)
				return false;
		}
		return true;
	}
	static void terminate(String e) {
		System.out.println(e);
		System.exit(0);
	}
}
