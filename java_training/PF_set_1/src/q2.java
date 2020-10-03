import java.util.Scanner;


public class q2 {
	public static void main(String[] args) {
		Scanner scrn = new Scanner(System.in);
		int size = scrn.nextInt();
		if(size<0)
			terminate();
		int[] arr = new int[size];
		for(int i=0;i<size; i++) {
			arr[i] = scrn.nextInt();
			if(arr[i]<0)
				terminate();
		}
		scrn.close();
		System.out.println(countRepeaters(arr, size));
	}
	// returns repeated counts.
	static int countRepeaters(int[] arr, int size) {
		int repeated_element = 0;// which element is repeated
		int count = 0;//its count. 2 for loop used. O(n).
		for(int i=0; i<size;i++) {
			for(int j=i+1; j<size; j++) {
				if(arr[i]==arr[j])
					repeated_element = arr[i];
			}
		}
		// utmost only one element would be repeated
		for(int n: arr)
			count += (repeated_element == n)?1:0;
		return count;
	}
	static void terminate() {
		System.out.println("Invalid input");
		System.exit(0);
	}
}
