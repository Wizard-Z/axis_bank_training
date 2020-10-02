import java.util.Scanner;

public class KaprekarNumber {

	public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in);
		int num = scnr.nextInt();
		scnr.close();
		
		int temp = num,d=0;
		// Number of digits
		while(temp>0) {
			d++;
			temp/=10;
		}
		int right=0,left=0;
		temp=num*num;
		int i=0;
		// RHS digits
		while(d>0) {
			right += (temp%10)*Math.pow(10, i);
			temp /=10;
			i++;d--;
		}
		i=0;
		// LHS digits
		while(temp>0) {
			left += (temp%10)*Math.pow(10, i);
			temp /=10;
			i++;
		}
		String out = (left+right== num)?"Kaprekar Number":"Not A Kaprekar Number";
		System.out.println(out);

	}

}
