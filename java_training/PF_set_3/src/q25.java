import java.util.Scanner;
//Generate code via getting even digit from numbers
public class q25 {
	public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in);
		int num = scnr.nextInt();
		if(num<0)
			terminate("Number to small");
		if(num>32767)
			terminate("Number too large");
		scnr.close();
		System.out.println(get_code(num));
	}
	static int get_code(int num) {
		int code=0, c=0,d;
		
		while(num>0) {
			d = num%10;
			// if  digit is even. add it to code
			if(d%2==0) {
				code+=d*Math.pow(10,c);// preserve the order
				c++;
			}
			num /=10;
		}
		return code;
	}


static void terminate(String e) {
	System.out.println(e);
	System.exit(0);
}
}
