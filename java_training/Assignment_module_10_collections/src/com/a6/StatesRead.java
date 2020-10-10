package com.a6;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedHashSet;
import java.util.TreeSet;

public class StatesRead {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("states.txt"));
		LinkedHashSet<String> stateSet = new LinkedHashSet<>();
		String line;
		while((line = br.readLine())!=null)
			stateSet.add(line);
		br.close();
		System.out.println("Total Number of states: "+stateSet.size());
		System.out.println(stateSet);
		stateSet.remove("Delhi");
		System.out.println("\nRemoved Delhi\n"+stateSet);
		System.out.println("\nStates starting with K");
		for(String s: stateSet) {
			if(s.startsWith("K"))
				System.out.println(s);
		}
		TreeSet<String> tset = new TreeSet<>();
		tset.addAll(stateSet);
		System.out.println("\n\nIn ordered format..\n"+tset);
		
		
	}

}
