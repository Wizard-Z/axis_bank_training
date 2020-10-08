package com.a8;

import java.io.File;

public class FileExplorer {
	static void listAll(String path) {
		// print all files and subfolders--> files in sub folder too.
		File dir = new File(path);
		if(!dir.exists())
			System.out.println("No folder exists with the given name.");
		else {
			for(File f: dir.listFiles()){
				if(f.isFile())
					System.out.println("type:file "+f.getName());
				else if(f.isDirectory()) {
					System.out.println("type:dir :"+f.getName());
					System.out.println("\\"+f.getName());
					for(File ff: f.listFiles()) {
						if(ff.isFile())
							System.out.println("type:file "+ff.getName());
					}
				}
			}
		}

	}
}
