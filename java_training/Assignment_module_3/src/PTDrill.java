import java.util.Arrays;
import java.util.Scanner;

public class PTDrill {

	public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in);
		System.out.println("Enter number of students");
		int n = scnr.nextInt();
		scnr.nextLine();
		System.out.println("Enter Names");
		String[] students = scnr.nextLine().split(" ");
		scnr.close();
		
		Arrays.sort(students);//sort the string array
		int r = (int) Math.sqrt(n);
		String[][] stand = new String[r][r];
		int k=0;//counter variable
		for(int i=0;i<r; i++) {
			for(int j=0;j<r;j++)
				stand[i][j] = students[k++];
		}
		String midrow="",midcol="";
		for(int i=0;i<r;i++)
			midrow+=" "+stand[r/2][i];
		
		for(int i=0;i<r;i++)
			midcol+=" "+stand[i][r/2];
		
		System.out.println("Middle row: "+midrow);
		System.out.println("Middle column: "+midcol);
		
		

	}

}
