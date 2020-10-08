package com.a9;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class TestImageCopy {

	public static void main(String[] args) throws IOException {
		
		Scanner scnr = new Scanner(System.in);
		System.out.println("Enter path to the image file!");
		String path = scnr.nextLine();
		scnr.close();
		File file = new File(path);
		if(!file.exists()) {
			System.out.println("File not Found");
			return;
		}
		if(!file.getName().split("\\.")[1].equals("jpg")) {
			System.out.println("File format not supported");
			return;
		}
		if(ImageCopy.copyImage(file))
			System.out.println("Copy Done!");
			
		
		
		

	}

}
