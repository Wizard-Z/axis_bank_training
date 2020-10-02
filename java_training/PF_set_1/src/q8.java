import java.util.Arrays;
import java.util.Scanner;

public class q8 {

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
		scnr.close();
		System.out.println(primeIndexSum(arr, size));
		
	}
	static int primeIndexSum(int[] arr, int size) {
		int s=0,k=0;
		for(int i=0;i<size;i++) {
			if(checkPrime(i+1)){
				s+=arr[i];
				//System.out.println(arr[i]);
				k++;
			}
		}
		return s/k;
	}
	static boolean checkPrime(int n) {
		// naive prime check
		boolean x=true;
		if (n<=1)
			return false;
		if (n==2 || n==3)
			return true;
		for (int i=2;i<n;i++) {
			if(n%i==0)
				x = false;
		}
		return x;
	}

}
