package com.a1;

import java.io.File;
import java.io.IOException;

public class TestFile {
	public static void main(String[] args)throws IOException {
		
		//File singles, dubbles;
		File myDir =  new File("E:\\Badminton");
		myDir.mkdir();
		new File("E:\\Badminton\\singles.txt").createNewFile();
		new File("E:\\Badminton\\dubbles.txt").createNewFile();
		new File(myDir.getPath()+"\\courts").mkdir();
		File dblss = new File("E:\\Badminton\\dubbles.txt");
		dblss.renameTo(new File(myDir.getPath()+"\\doubles.txt"));
		File sngls = new File("E:\\Badminton\\singles.txt");
		sngls.delete();
		
		
	}

}
