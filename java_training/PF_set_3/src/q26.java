import java.util.Scanner;

/* Calculate bonus
 * 
 */
public class q26 {

	public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in);
		int sal = scnr.nextInt();
		if(sal>32767)
			terminate("Number too large");
		if(sal<0)
			terminate("Number too small");
		scnr.close();
		System.out.printf("%.2f",get_bonus(sal));

	}
	static float get_bonus(int sal) {
		return (float) ((sal>20000)?0.17*sal+1500:(sal>15000)?0.15*sal+1200:
				(sal>10000)?0.12*sal+1000:0.08*sal+500);
	}
	static void terminate(String e) {
		System.out.println(e);
		System.exit(0);
	}

}
