package four;

public class MyUtil {
	static int throwDice() {
		return (int)Math.random()*6;
	}
	static double findAverage(int[] arr) {
		int s = 0,c = 0;
		for(int n:arr) {
			s+=n;
			c++;
		}
		return s*1.0/c;
	}

}
