package com.test;

import java.util.ArrayList;
import java.util.Scanner;

import com.airline.Airlines;
import com.airline.Domestic;
import com.airline.International;
import com.airline.InvalidEntryException;

public class TestAirline {

	public static void main(String[] args) {
	
		System.out.println("In -->Main()");
		ArrayList<Airlines> arr = new ArrayList<>();
		
		//Testing data... Manipulate and check.. 
		/*	try {
			Domestic d1 = new Domestic("BOEING1","Delhi","Bangalore","Z001");
			arr.add(d1);}catch (InvalidEntryException e) {
			System.out.println(e.getMessage());
		 * Do this for every entry so that only the invalid entry gets skipped.
		 * Use Loops?
		 */
		
		
		try {
			Domestic d1 = new Domestic("BOEING1","Delhi","Bangalore","Z001");
			arr.add(d1);
			Domestic d2 = new Domestic("BOEING2","Delhi","Bangalore","Z003");
			arr.add(d2);
			International i1 = new International("BOEING1","Delhi","Bangalore","1001");
			arr.add(i1);
			International i2 = new International("BOEING2","Delhi","Bangalore","1002");
			arr.add(i2);
			//Error Check!!
			//Domestic d3 = new Domestic("BOEING2","Delhi","Bangalore","Z0001");
			//arr.add(d3);
			
		} catch (InvalidEntryException e) {
			System.out.println(e.getMessage());
		}
		
		Scanner scnr = new Scanner(System.in);
		// Use simple for to avoid missing the valid entry..
		for(Airlines a: arr) {
			System.out.println(a);
			System.out.println("Enter no of tickets");
			try {
			a.bookTicket(Integer.parseInt(scnr.nextLine()));
			}
			catch(NumberFormatException e) {
				System.out.println("Only Integers allowed");
			}
		}
		System.out.println("--End of application--");
		scnr.close();
		/*
		 * 
		 * 
		 */
		

	}

}
