import java.util.Arrays;
import java.util.Scanner;
// This question is yet to be done. rest all are done.
public class q2 {

	public static void main(String[] args)throws Exception {
		Scanner scnr = new Scanner(System.in);
		int size=0;
		boolean flag = true;
		int[] arr=new int[20];
		try {
			size = scnr.nextInt();
			if (size<0)
				throw(new Exception());
			arr = new int[size];
			int temp;
			for(int i=0;i<size;i++) {
				temp = scnr.nextInt();
				if(temp<0)
					throw(new Exception());
				arr[i]=temp;
			}
			scnr.close();
		}
		catch(Exception e) {
			flag = false;
			System.out.println("Invalid Input");
		}
		if(flag)
			System.out.println(countRepeaters(arr, size));

	}
	static int countRepeaters(int[] arr, int size) {
		int c = 0;
		System.out.println(Arrays.toString(arr)+":"+size);
		for(int i=0;i<size;i++) {
			for(int j=i+1;j<size;j++) {
				c += (arr[i]==arr[j])?1:0;
			}
		}
		return c;
	}
}
