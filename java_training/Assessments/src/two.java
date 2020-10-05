import java.util.Scanner;

public class two {

	public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in);
		int N = scnr.nextInt();
		int[] acTemp = new int[N];
		for(int i =0; i<N;i++)
			acTemp[i] = scnr.nextInt();
		int thr = scnr.nextInt();
		int stu = scnr.nextInt();
		scnr.close();
		
		int s=0; // sum of temp.
		for(int t:acTemp)
			s+=t;
		int avg = s/N;
		//System.out.println(avg);
		int count=0; // counter variable
		for(int i=avg+2;i<thr;i+=2)
			count++;
		//System.out.println(count+":"+stu);
		System.out.println((avg%2==0)?count*stu:(count*stu)+stu-1);// did mistake here.
															// I explictly added 5 instead of this.
			
		
		

	}

}
