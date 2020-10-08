package com.four;
class Table2{
	// not sync,
	public void printTable(int num) {
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

class MyThread2 extends Thread{
	Table table;
	int num;
	public MyThread2(Table table, int num) {
		super();
		this.table = table;
		this.num = num;
	}
	@Override
	public void run() {
		synchronized (table) {
			table.printTable(num);
		}
	}
}

public class TableThread2 {
	public static void main(String[] args) {
		Table table = new Table();
		MyThread th1 = new MyThread(table, 5);
		MyThread th2 = new MyThread(table, 100);
		th1.start();
		System.out.println("---");
		th2.start();
	}

}
