package com.a4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;


public class TestPatientList {
	public static void main(String[] args) {
		ArrayList<Patient> arr = new ArrayList<>(3);
		Patient p1 = new Patient(1, "bname", 11);
		Patient p2 = new Patient(22,"aname", 99);
		Patient p3 = new Patient(999, "Aaname", 22);
		Patient p4 = new Patient(999, "Aanameee", 2222);
		
		
		arr.add(p1);
		arr.add(p2);
		arr.add(p3);
		arr.add(p4);
		
		Collections.sort(arr, 
				new Comparator<Patient>() {
			@Override
			public int compare(Patient o1, Patient o2) {
				return Integer.compare(o1.getPatientId(), o2.getPatientId());
			}});
		
		System.out.println("\n Sorted based on Pid:");
		for(Patient p:arr)
			System.out.println(p);
		
		Collections.sort(arr,
				new Comparator<Patient>() {
			@Override
			public int compare(Patient o1, Patient o2) {
				return Integer.compare(o1.getAge(), o2.getAge());
			}});
		System.out.println("\n Sorted based on Age:");
		Iterator<Patient> iter = arr.iterator();
		while(iter.hasNext())
			System.out.println(iter.next());
		
		Set<Patient> patientSet = new TreeSet<>(new Comparator<Patient>() {
			@Override
			public int compare(Patient o1, Patient o2) {
				return Integer.compare(o1.getPatientId(), o2.getPatientId());
			}});
		patientSet.add(p1);
		patientSet.add(p2);
		patientSet.add(p3);
		patientSet.add(p4);
		System.out.println("Added to set\n Displaying....");
		for(Patient p: patientSet)
			System.out.println(p);
		System.out.println("Enter name of patient");
		Scanner scnr = new Scanner (System.in);
		String name = scnr.nextLine();
		scnr.close();
		int age=getPatientAge(name,patientSet);
		if(age!=-1)
			System.out.println("Age of "+name+": "+age);
		else
			System.out.println("No record found...");
	}
	static int getPatientAge(String name, Set<Patient> patientSet) {
		for (Patient p:patientSet) {
			if(p.getName().compareTo(name)==0)
				return p.getAge();
		}
		return -1;
	}
}
