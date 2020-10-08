import java.util.Scanner;

// find product of max and third max number in an array
public class q24 {
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
		System.out.println(pro_first_third(arr));
		
	}

	static int pro_first_third(int[] arr) {
		// get max and third max
		int max = 0, s_max = 0, t_max = 0;
		for(int n:arr) {
			if(n>max) {
				s_max = max;
				max = n;
			}
			if(n<max && n>s_max) {
				t_max = s_max;
				s_max = n;
			}	
			if(n<s_max && n>t_max)
				t_max = n;
		}
		//System.out.printf("max: %d 2: %d 3: %d",max,s_max, t_max);
		return max*t_max;
	}

	static void terminate(String e) {
		System.out.println(e);
		System.exit(0);
	}
}
