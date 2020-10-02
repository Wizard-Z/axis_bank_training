import java.util.Scanner;

public class Profit_loss {

	public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in);
		System.out.println("Enter the number of dozens of egg purchased");
		int d = scnr.nextInt();
		System.out.println("Enter the price per dozen");
		int price_d = scnr.nextInt();
		System.out.println("Enter the selling price of 1 egg");
		int sp = scnr.nextInt();
		scnr.close();
		
		double cp = price_d/12.0;
		double sell = sp-cp;
		
		if(sell>0)
			System.out.printf("Harish's profit percentage is %.2f percent",(sell/cp)*100);
		else if(sell<0)
			System.out.printf("Harish's loss percentage is %.2f percent",(-sell/cp)*100);
		else
			System.out.println("NO PROFIT NO LOSS");
	}

}
