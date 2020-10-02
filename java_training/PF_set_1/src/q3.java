import java.util.Scanner;

public class q3 {
	public static void main(String[] args)throws Exception {
		Scanner scnr = new Scanner(System.in);
		int size=0;
		boolean flag = true;
		int[] arr=new int[20];
		try {
			size = scnr.nextInt();
			if (size<0)
				throw(new Exception("Invalid array size"));
			arr = new int[size];
			int temp;
			for(int i=0;i<size;i++) {
				temp = scnr.nextInt();
				if(temp<0)
					throw(new Exception("Invalid input"));
				arr[i]=temp;
			}
			
		}
		catch(Exception e) {
			flag = false;
			System.out.println(e.getMessage());
		}
		scnr.close();
		if (flag) // no error in inputs
			System.out.println(maximumSum(arr,size));
			
		
	}
	static int maximumSum(int numbers[], int size) {
		int esum = 0,osum = 0;
		for(int number:numbers) {
			if(number%2==0)
				esum+=number;
			else
				osum+=number;
		}
		return (esum>=osum)?esum:osum;
	}

}
