package com.four;
class Table{
	public synchronized void printTable(int num) {
		for(int i = 1; i<=10; i++) {
			System.out.println(num*i);
			try {
				Thread.sleep(314);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

class MyThread extends Thread{
	Table table;
	int num;
	public MyThread(Table table, int num) {
		super();
		this.table = table;
		this.num = num;
	}
	@Override
	public void run() {
		table.printTable(num);
	}
}

public class TableThread {
	public static void main(String[] args) {
		Table table = new Table();
		MyThread th1 = new MyThread(table, 5);
		MyThread th2 = new MyThread(table, 100);
		//MyThread th3 = new MyThread(table, 13);
		
		//MyThread th1 = new MyThread(new Table(), 5);
		//MyThread th2 = new MyThread(new Table(), 100);
		//MyThread th3 = new MyThread(new Table(), 13);
		th1.start();
		System.out.println("---");
		th2.start();
		//th3.start();
	}

}
