import java.util.Scanner;

public class q2 {

	public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in);
		int size = scnr.nextInt();
		if(size<=0)
			terminate();
		int[] arr = new int[size];
		for (int i=0; i<size;i++) {
			arr[i]= scnr.nextInt();
			if(arr[i]<0)
				terminate();
		}
		scnr.close();
		System.out.println(avgOddEvenSum(arr, size));

	}
	static float avgOddEvenSum(int[] arr, int size) {
		int odd=0,s=0;
		for(int n: arr) {
			odd += (n%2!=0)?n:0;//odd sum
			s +=n; // total sum
		}
		s -= odd; // even sum;
		return (float) ((odd+s)/2.0);		
	}
	static void terminate() {
		System.out.println("Invalid Input");
		System.exit(0);
	}

}
