package com.a3;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class ProverbCollection {
	static void storeProverb(String proverb) throws IOException {
		BufferedOutputStream bout = new BufferedOutputStream(new FileOutputStream("TopProverbs.txt"));
		//System.out.println(proverb);
		System.out.println("Adding...");
		bout.write(proverb.getBytes());
		System.out.println("ADDED");	
		bout.close();
	}
	public static void main(String[] args) throws IOException {
		System.out.println("PROVERB STORAGE");
		Scanner scnr = new Scanner(System.in);
		
		String proverb = "";
		String inp = scnr.nextLine();
		while(!(inp.compareTo("STOP")==0)) {
			proverb = proverb.concat(inp+"\n");
			inp = scnr.nextLine();
		}
		System.out.println(":"+proverb);
		storeProverb(proverb);
		scnr.close();		
	}

}
