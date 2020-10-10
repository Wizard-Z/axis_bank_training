package com.a1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Scanner;

public class StudentMarks {
	public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in);
		System.out.println("Enter number of Student");
		int size = scnr.nextInt();
		ArrayList<Double> marks = new ArrayList<>(size);
		System.out.println("Enter Marks");
		// Getting  marks
		for(int i=0;i<size;i++)
			marks.add(scnr.nextDouble());
		scnr.close();
		System.out.println("Highest Marks: "+Collections.max(marks));
		
		double Sum = 0.0;
		for(double mark: marks)
			Sum+= mark;
		System.out.println("Average Marks: "+Sum/size);
		printList(marks, "Marks");
		System.out.println("3rd Student marks: "+marks.get(2));
		// Sort
		Collections.sort(marks);
		printList(marks, "Sorted");
	}
	static void printList(ArrayList<Double> lst, String msg) {
		
		Iterator<Double> iter= lst.iterator();
		int c=1;
		System.out.print(msg+": ");
		while(iter.hasNext())
			System.out.print(c++ +"-"+iter.next()+" ");
		System.out.println();
		
	}

}
