package com.a6;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class DocumentFormatter {
	public static void main(String[] args) throws IOException {
		Scanner scnr = new Scanner(System.in);
		System.out.println("Enter OUTPUT FILE name:/");
		String out = scnr.nextLine();
		scnr.close();
		BufferedReader br = new BufferedReader (new FileReader("SoManySpaces.txt"));
		PrintWriter pf = new PrintWriter(new FileWriter(out));
		String line;
		
		while((line = br.readLine())!=null) {
			//System.out.println(line);
			//System.out.println(removeExtraSpaces(line));
			pf.println(removeExtraSpaces(line));	
		}
		br.close();
		pf.close();
		System.out.println("written to file\n displaying new file");
		br = new BufferedReader (new FileReader(out));
		while((line = br.readLine())!=null)
			System.out.println(line);
	}
	static String removeExtraSpaces(String line) {
		String trimLined="";
		char[] ln = line.toCharArray();
		for(int i=0; i<ln.length;i++) {
			if((ln[i]==' ' && ln[i+1]!=' ' )||
					(ln[i]!=' '&& ln[i]==' ')||
					(ln[i]!=' ' && ln[i]!=' '))
				trimLined += ln[i];
		}
		return trimLined;
	}

}
