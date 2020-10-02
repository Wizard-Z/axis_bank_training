import java.util.Scanner;

public class a1 {
	public static void main(String[] args) {
		System.out.println("2+3="+Sum(2,3));
		System.out.println("5! = "+fact(5));
		System.out.println("pattern 1");
		printPtrn1("#",3);
		System.out.println("pattern 2");
		printPtrn1("*",	4);
		System.out.println("first 10 fibo..");
		printFibo(10);
		System.out.println("ODD TERMS <100");
		printFibo2(100);
		System.out.println("Between 100 and 1000[evens]");
		printFibo3(100,1000);
		System.out.println("Print Series");
		printSeries(1, 13, 	3);
		System.out.println();
		printSeries(-20, 5, 5);
		System.out.println();
		for(int i=1;i<20;i++) {
			if(i%2==0)
				System.out.print(-1*i+",");
			else
				System.out.print(i+",");
		}
		System.out.println();
		triangleMul();
		System.out.println("DIGIT SUM: 1234 = "+dSum(1234));
		System.out.println("96f = "+ftoc(96));
		System.out.println("CUBES 1 to 10");
		cubes1_10(1,10);
		System.out.println("ARMSTRONG CHECK: 153 is "+armstrong(153));
		printPattern15("***","###",5);
		Scanner scnr = new Scanner(System.in);
		System.out.println("ENTER 3 NUMBERS");
		int a = scnr.nextInt();
		int b = scnr.nextInt();
		int c = scnr.nextInt();
		scnr.close();
		System.out.println("OUTPUT:"+(a+b+c));
		System.out.println("PRIME CHECK "+args[0]+" is "+checkPrime(Integer.parseInt(args[0])));
		

	}




	static void cubes1_10(int i, int j) {
		for(int k =i;k<=j;k++)
			System.out.print(k*k*k+",");
		System.out.println();

	}
	static int Sum(int a,int b) {
		int sum = a+b;
		return sum;
	}
	static int fact(int n) {
		if (n==1)
			return 1;
		return n*fact(n-1);
	}
	static int fibo(int n) {
		if (n<=1)
			return n;
		return fibo(n-1) + fibo(n-2);
	}
	static void printFibo(int n) {
		for(int i=1; i<=n;i++)
			System.out.print(fibo(i)+",");
		System.out.println();
	}
	static void printFibo2(int n) {
		int i = 1;
		int f = fibo(i);
		while(f<n) {
			f = fibo(i++);
			if(f%2==1)
			System.out.print(f+",");
		}
		System.out.println("DONE");
	}
	static void printFibo3(int start,int end) {
		int i = 1;
		int f = fibo(i);
		while(f<=end) {
			f = fibo(i++);
			if(f>start&&f%2==0)
			System.out.print(f+",");
		}
		System.out.println("DONE");
	}
	static void printPtrn1(String str, int count) {
		for(int i=1;i<=count;i++)
			System.out.println(str.repeat(i));

	}
	static void printSeries(int start, int end, int step) {
		for(int i=start;i<=end;i+=step)
			System.out.print(i+",");
	}
	static void triangleMul() {
		for(int i=0;i<=6;i++) {
			for(int j=0;j<=i;j++)
				System.out.print((i+1)*j+" ");
			System.out.println();
		}
	}
	static int dSum(int n) {
		int s = 0;
		while (n>0) {
			s += n%10;
			n /= 10;
		}
		return s;

	}
	static float ftoc(int f) {
		float c = (float) ((f-32)*(5.0/9.0));
		System.out.println(c);
		return c;
	}
	static boolean armstrong(int num) {
		int temp = num;
		int d=0,s=0;
		while(temp>0) {
			d = temp%10;
			s += d*d*d;
			temp /=10;
		}
		System.out.println(s);
		return (s==num)?true:false;
	}
	static void printPattern15(String str1, String str2,int c) {
		for(int i=1;i<=c;i++) {
			if(i%2==0)
				System.out.println(str2);
			else
				System.out.println(str1);
		}
		
	}
	static boolean checkPrime(int n) {
		boolean x=false;
		if (n<=1)
			return false;
		for (int i=2;i<n;i++)
			x = (n%i==0)?false: true;
		return x;
	}

}
