import java.util.Scanner;

public class SpecialSequence {

	public static void main(String[] args) {
		int n1=2,n2=1,n3=3;
		Scanner scnr = new Scanner(System.in);
		System.out.println("Enter Limit");
		int lt = scnr.nextInt();
		scnr.close();
		if (lt>=6) {
		int next = n1+n2+n3;
		System.out.print(n1+" "+n2+" "+n3);
		while(next<lt) {
			n1=n2;
			n2=n3;
			n3=next;
			System.out.print(" "+next);
			next = n1+n2+n3;
		}
		if(next==lt)// last term equal to limit
			System.out.print(" "+next); // makes sure no trailing space
	}
	else
		System.out.println("GIVE MORE THAN 6");

}
}
