package com.two;
class MyThread extends Thread{
	private String message;

	public MyThread(String message) {
		super();
		this.message = message;
	}
	@Override
	public void run() {
		System.out.println(this.message);
	}
}
public class ThreadTalks {
	public static void main(String[] args) {
		MyThread th1 = new MyThread("Hi! I am a thread");
		MyThread th2 = new MyThread("Mee too");
		th1.start();
		th2.start();
	}

}
