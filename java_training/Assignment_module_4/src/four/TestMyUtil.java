package four;

public class TestMyUtil {

	public static void main(String[] args) {
		System.out.println(MyUtil.throwDice());
		int[] arr1= {1,2,3,4,5,6,7,99,2314};
		int[] arr2= {3,1,4,1,5,9,2,6,5,3};
		System.out.println("AVG of arr1-:"+MyUtil.findAverage(arr1));
		System.out.println("AVG of arr2-:"+MyUtil.findAverage(arr2));
		System.out.println("MAX between 1.414 and 2.732 is-:"+Math.max(1.414, 2.732));
		double test = 3.1415926;
		System.out.printf("Ceil: %f\nFloor: %f\nRound: %d\n",Math.ceil(test),Math.floor(test),Math.round(test));

	}

}
