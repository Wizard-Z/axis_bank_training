import java.util.Scanner;

public class ClassRooms {

	public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in);
		int[] labs = new int[3];
		System.out.println("Enter C1 capacity");
		labs[0]=scnr.nextInt();
		System.out.println("Enter C2 capacity");
		labs[1] = scnr.nextInt();
		System.out.println("Enter C3 capacity");
		labs[2] = scnr.nextInt();
		System.out.println("Enter number of students");
		int s = scnr.nextInt();
		scnr.close();
	
		int lb = 0;// lab counts
		for(int lab:labs)
			lb += (lab>=s)?1:0;
		
		if(lb!=0)
			System.out.printf("%d lab(s) can accommodate %d students",lb,s);
		else
			System.out.printf("None of the labs can accommodate %d students",s);
	}

}
