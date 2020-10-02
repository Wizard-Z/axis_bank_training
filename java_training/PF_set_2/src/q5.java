
import java.util.HashMap;
import java.util.Scanner;

public class q5 {
	static int[] factorial;
	public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in);
		int num = scnr.nextInt();
		if (num<0)
			terminate("Number too small");
		if(num >32767)
			terminate("Number too large");
		scnr.close();
		
		digitFactorial(num);
		for(int f:factorial)
			System.out.println(f);
	}
	static void digitFactorial(int number) {
		int c=0,rev = 0,temp;
		HashMap<Integer, Integer> map = new HashMap<>(); 
		while(number>0) {
			c++; // number of digits in input
			temp = number%10;
			map.put(temp, cal_fact(temp));// factorial in map
			rev = rev*10 + temp; //reversing alongside;
			number /= 10;
		}
		factorial = new int[c];
		c = 0;
		// storing in the global array
		// reversing help in storing in the required fashion
		while(rev>0) {
			temp = rev %10;
			factorial[c++] = map.get(temp);
			rev /=10;
		}	
	}
	static int cal_fact(int number) {
		if(number <=1)
			return 1;
		return number*cal_fact(number -1);
	}
	static void terminate(String e) {
		System.out.println(e);
		System.exit(0);
	}
	

}
