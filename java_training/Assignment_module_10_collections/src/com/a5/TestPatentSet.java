package com.a5;

import java.util.LinkedHashSet;


public class TestPatentSet {
	public static void main(String[] args) {
		Patient p1 = new Patient(1, "bname", 11);
		Patient p2 = new Patient(1, "bname", 11);
		Patient p3 = new Patient(999, "Aaname", 22);
		Patient p4 = new Patient(999, "Aanameee", 2222);
		LinkedHashSet<Patient> pset = new LinkedHashSet<>();
		pset.add(p1);
		pset.add(p2);
		pset.add(p3);
		pset.add(p4);
		System.out.println("Added to hashSet");
		System.out.println("Size is: "+pset.size());
		System.out.println("Printing patient details");
		for(Patient p: pset)
			System.out.println(p);
		
		
	}

}
