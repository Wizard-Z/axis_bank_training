package com.a8;

import java.util.Scanner;

public class TestFileExplorer {
	public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in);
		System.out.println("Enter Path");
		String path = scnr.nextLine();
		scnr.close();
		System.out.println("Entered path: "+path);
		FileExplorer.listAll(path);
		
	}
}
