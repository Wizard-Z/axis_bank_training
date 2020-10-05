package six;

public class TestAverage {
	public static void main(String[] args) {
		
	int n1=1,n2=99,n3=123;
	double N1=34.6,N2=45.7;
	System.out.println("INT INT:"+Avenger.avg(n1, n2));
	System.out.println("INT INT INT:"+Avenger.avg(n1, n2, n3));
	System.out.println("DOUBLE DOUBLE:"+Avenger.avg(N1, N2));
	
	}

}
