package one;

public class ExceptionTest {

	public static void main(String[] args) {
		int n1,n2,result = 0;
		try {
			if(args.length==0) {
				throw new Exception("No input received");}
			n1 = Integer.parseInt(args[0]);
			n2 = Integer.parseInt(args[1]);			
			result = n1/n2;
			System.out.println("Result is: "+result);
		}		
		catch(NumberFormatException e) {
			System.out.println("Only integers are allowed.");
		}
		catch(ArithmeticException e) {
			System.out.println("Division with zero is not possible.");
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		

	}

}
