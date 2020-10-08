/*
 * find minimum of 3 integer inputs
 */
public class q27 {

	static int findSmallest(int n1, int n2, int n3) {
		if(n1<=n2)
			if(n1<=n3)
				return n1;
		if(n3<=n2)
			return n3;
		return n2;
	}
}
