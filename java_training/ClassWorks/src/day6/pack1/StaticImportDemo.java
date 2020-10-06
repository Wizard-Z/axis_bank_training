package day6.pack1;
//import static java.lang.Math.*;
import day6.pack2.Sample;
public class StaticImportDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(Math.sqrt(16));
		day6.pack1.Sample smp = new day6.pack1.Sample();
		smp.setStr("hello");
		smp.showMsg();
		Sample samp = new Sample();
		samp.setStr("HELLO!");
		samp.showMsg();

	}

}
