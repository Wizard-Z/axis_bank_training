package com.three;

class MyThread extends Thread{
	private String thWord;

	public MyThread(String thWord) {
		super();
		this.thWord = thWord;
	}
	@Override
	public void run() {
		System.out.println(new WrapBrackets().wrapWord(this.thWord));
	}
	
}
class WrapBrackets{
	String wrapWord(String word) {
		return "["+word+"]";
	}
}

public class ThreadsBrackets {
	public static void main(String[] args) {
		MyThread th1 = new MyThread("I am Thread One");
		MyThread th2 = new MyThread("I am Thread Two");
		MyThread th3 = new MyThread("I am Thread Three");
		
		th1.start();
		th2.start();
		th3.start();
		
		
	}
}
