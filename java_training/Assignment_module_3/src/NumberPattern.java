import java.util.Scanner;

public class NumberPattern {

	public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in);
		int n = scnr.nextInt();
		scnr.close();
		for(int i=1;i<=n;i++) {
			if(i%3!=0) {
				for(int j=0;j<i;j++)
					System.out.print(i+" ");
				System.out.println();

			}

		}
	}
}

