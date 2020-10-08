package com.a2;

import java.io.File;

public class FolderInfo {
	static void printDirectory(String path) {
		File f = new File(path);
		for(File ff :f.listFiles())
		if(!ff.exists())
			System.out.println("No folder exists with the given name.");
		else if(ff.isFile()) {
			System.out.println();
			System.out.println("File: "+ff.getName()+
								"\nAbsolute File Path: "+ff.getAbsolutePath()
								+"\nFolder Path: "+ff.getParent());
		}
		else {
			System.out.println();
			System.out.println("\nDirectory: "+ff.getName()
								+"\nPath: "+ff.getParent());
		}
	}
	public static void main(String[] args) {
		System.out.println("Folder Details");
		String path = "E:\\Badminton\\";
		System.out.println(path);
		printDirectory(path);
	}

}
