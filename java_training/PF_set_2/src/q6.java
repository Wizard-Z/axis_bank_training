import java.util.Scanner;

public class q6 {
	static int[] found= new int[0];
	public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in);
		int size = scnr.nextInt();
		if (size<0)
			terminate("Invalid array size");
		int[] arr = new int[10];
		for(int i=0; i<size;i++) {
			arr[i] = scnr.nextInt();
			if (arr[i]<0)
				terminate("Invalid Input");
		}
		int value = scnr.nextInt();
		scnr.close();
		
		searchKeys(arr, value);
		if(found.length==0)
			terminate("Key not found");
		for(int key:found)
			System.out.println(key);
		
		
	}
	static void searchKeys(int[] arr,int value) {
		// no collectiions used
		// two times for loop. first time knowing the number of
		// times the value appeared.
		// to store it in global array
		int c = 0;
		for(int i=1 ;i<arr.length; i+=2)
			c +=(arr[i]== value)?1:0;
		found = new int[c];
		c=0;
		for(int i=1; i<arr.length; i+=2) {
			if (arr[i]== value)
				found[c++] = arr[i-1];
		}
	}
	
	static void terminate(String e) {
		System.out.println(e);
		System.exit(0);
	}
}

