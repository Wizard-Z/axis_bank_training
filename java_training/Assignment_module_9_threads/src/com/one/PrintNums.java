package com.one;

class MyThread extends Thread{
	private String name;
	public MyThread() {}
	public MyThread(String name) {
		this.name = name;
	}

	public void run() {
		for(int i = 1; i<=10; i++) {
			System.out.println(i);
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}


public class PrintNums {
	public static void main(String[] args) {
		MyThread th = new MyThread("Thread1"); 
		th.start();	
	}
}
