package com.a9;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ImageCopy {
	static boolean copyImage(File file) throws IOException {
		BufferedInputStream bin = new BufferedInputStream(new FileInputStream(file));
		String outfile = file.getAbsolutePath().split("\\.")[0]+"_copy.jpeg";
		BufferedOutputStream bout = new BufferedOutputStream(new FileOutputStream(outfile));
		System.out.println("Saving in:"+outfile);
		int i;
		boolean flag = true;
		try {
			while((i=bin.read())!=-1) {
				bout.write(i);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Encountered Error while copy!!");
			flag = false;
		}
		bin.close();
		bout.close();
		return flag;
	}

}

