import java.util.Scanner;

public class q4 {

	public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in);
		int o1 = scnr.nextInt();
		int o2 = scnr.nextInt();
		int op = scnr.nextInt();
		scnr.close();
		
		int out = performArithmeticOperation(o1, o2, op);
		if(out == -1)
			terminate();
		System.out.println(out);
	}
	
	static int performArithmeticOperation(int o1, int o2, int op) {
		if(o1<0 || o2<0 ||o1>32767 || o2>32767 )
			return -1;
		switch (op) {
		case(1):
			return o1+o2;
		case(2):
			return o1-o2;
		case(3):
			return o1*o2;
		case(4):
			return o1/o2;
		default:
			return -1;
		}
	}
	static void terminate() {
		System.out.println("Invalid input");
		System.exit(0);
	}

}
