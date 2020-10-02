
import java.util.HashMap;
import java.util.Scanner;

public class q7 {
	static int[] feedback;
	public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in);
		// Getting inputs
		int size = scnr.nextInt();
		if(size<=0) {
			System.out.println("Invalid array size");
			System.exit(0);
		}
		int temp;
		int[] arr = new int[size*2];
		for(int i=0;i<size*2;i++) {
			temp = scnr.nextInt();
			if(temp<0) {
				System.out.println("Invalid input");
				System.exit(0);
			}
			arr[i] = temp;
		}
		scnr.close();
		// code
		int[] metlife = new int[size];
		int[] hardfort = new int[size];
		for(int i =0;i<size;i++)
			metlife[i] = arr[i];
		for(int i= 0; i<size; i++)
			hardfort[i] = arr[i+(size)];
		highestFeedBack(metlife, hardfort, size);
		for(int i:feedback)
			System.out.println(i);
	}
	
	static void highestFeedBack(int[] metlife,int[]	hardfort,int size) {
		HashMap<Integer,Integer> map = new HashMap<>();
		for(int i=0; i<size;i+=2) 
			map.put(metlife[i],metlife[i+1]);
		boolean flag;
		for(int i=0 ;i < size;i+=2) {
			flag = map.containsKey(hardfort[i]);
			if(flag && map.get(hardfort[i])<hardfort[i+1])
				map.put(hardfort[i],hardfort[i+1]);//update
			if(!flag) //not there
				map.put(hardfort[i],hardfort[i+1]);
		}
		//System.out.println(map);
		feedback = new int[map.size()*2];
		int i = 0;
		for(int id: map.keySet()) {
			feedback[i] = id;
			feedback[i+1] = map.get(id);
			i+=2;
		}
	}
		
}
