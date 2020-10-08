package com.a4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class ProverbReader {
	public static void main(String[] args) throws IOException {
		System.out.println("=Proverb Reader=");
		BufferedReader bin = new BufferedReader(new FileReader("TopProverbs.txt"));
		int count = 1;
		String line;
		while((line = bin.readLine())!=null) {
			System.out.println(count++ +":"+line);
		}
		bin.close();
	
	}

}
