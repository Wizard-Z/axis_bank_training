package com.a2;

import java.util.Collections;
import java.util.LinkedList;

public class ScoreAnalyzer {
	private LinkedList<Integer> runsData;
		
	public ScoreAnalyzer() {
		this.runsData = new LinkedList<>();
	}
	public void addRunsToList(int runs) {
		this.runsData.add(runs);
	}
	public double calcRunRate() {
		int s=0;
		for(int run:this.runsData)
			s+=run;
		return s/50.0;
	}
	public int lowestRunsScored() {
		return Collections.min(this.runsData);
	}
	public void displayRuns() {
		int c=1;
		for(int r:this.runsData) 
			System.out.print(c++ +"-"+r+" ");
		System.out.println();
	}
	public LinkedList<Integer> getRunsData() {
		return runsData;
	}


}
