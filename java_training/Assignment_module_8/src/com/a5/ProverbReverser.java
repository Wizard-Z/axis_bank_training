package com.a5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ProverbReverser {
	static String reverseWord(String word) {
		String revString="";
	    for (char c: word.toCharArray())  
	        revString = c+revString; 
		return revString; 
		
	}
	public static void main(String[] args) throws IOException {
		BufferedReader bin = new BufferedReader(new FileReader("TopProverbs.txt"));
		BufferedWriter bout = new BufferedWriter(new FileWriter("ReverseProverbs.txt"));
		
		String line;
		while((line = bin.readLine())!=null) {
			//System.out.println(":"+line);
			bout.write(reverseWord(line));
			bout.write("\n");
			}
		bout.close();
		bin.close();
		
		System.err.println("Reversed Proverb file read");
		bin = new BufferedReader(new FileReader("ReverseProverbs.txt"));
		while((line = bin.readLine())!=null)
			System.out.println(":"+line);
		bin.close();
	}

}
