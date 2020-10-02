import java.util.Scanner;

public class q5 {
	static int[] cricketer;
	public static void main(String[] args)throws Exception {
		Scanner scnr = new Scanner(System.in);
		int size=0,score=0;
		boolean flag = true; // to make sure that program terminates in invalid case
		int[] arr = new int[20];
		try {
			size = scnr.nextInt();
			if(size<=0)
				throw(new Exception("Invalid array size"));
			arr = new int[size];
			int temp;
			for(int i=0; i<size;i++) {
				temp = scnr.nextInt();
				if(temp<0)
					throw(new Exception("Invalid input"));
				arr[i] = temp;
			}
			score = scnr.nextInt();
			if(score<0)
				throw(new Exception("Invalid Score"));			
		}
		catch(Exception e) {
			System.out.println(e.getMessage());// as not thrown but print
			flag = false;// flag variable
		}
		scnr.close();
		if(flag) { //if true means no invalid case encountered
		findCricketerId(arr, size, score);
		// print the results
		for(int cric:cricketer)
			System.out.println(cric);}
	}
	static void findCricketerId(int array[], int size, int score) {
		int c=0;
		// get counts 
		for(int i=1;i<size;i+=2)
			c+=(array[i]>score)?1:0;
		cricketer = new int[c];
		c=0;
		// store ids in respective global array
		for(int i=1;i<size;i+=2) {
			if(array[i]>score) {
			cricketer[c]=array[i-1];
			c++;}
		}
	}

}
