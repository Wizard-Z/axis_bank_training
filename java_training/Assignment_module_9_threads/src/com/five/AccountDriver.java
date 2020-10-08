package com.five;
class MyThread extends Thread{
	private Account acc;
	private double amount;
	private String name;
	
	public MyThread(Account acc, double amount, String name) {
		super();
		this.acc = acc;
		this.amount = amount;
		this.name = name;
	}
	@Override
	public void run(){
		for(int i=1;i<11;i++) {
		try {
			Thread.sleep(200);
			synchronized (acc){
				acc.withdraw(this.amount);
				System.out.println(this.name+" Trans_"+i);
			}
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		System.out.println("aval_bal:"+acc.getBalance());
	}
}
public class AccountDriver {
	public static void main(String[] args) {
		Account acc = new Account(12345, "Sourabh", 999999);
		double amount = 1000;
		MyThread th1 = new MyThread(acc, amount,"th1");
		MyThread th2 = new MyThread(acc, amount, "th2");
		th1.start();
		th2.start();
		System.out.println("::"+acc.getBalance());
		
		
	}

}
