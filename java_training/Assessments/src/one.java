import java.util.Scanner;

public class one {

	public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in);
		int A = scnr.nextInt();
		int I = scnr.nextInt(); 
		scnr.close();
		int out=0;
		for(int i=A;i<=I;i++) // implement it when I is double digitted
			out=out*10+i; 
		System.out.println(out);

	}

}
