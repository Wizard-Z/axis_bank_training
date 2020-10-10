package com.a2;

import java.util.Scanner;

public class TestScoreAnalyzer {
	public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in);
		ScoreAnalyzer sa = new ScoreAnalyzer();
		System.out.println("Enter Runs");
		int count = scnr.nextInt();
		for(int i=0; i<count;i++)
			sa.addRunsToList(scnr.nextInt());
		scnr.close();
		
		System.out.println("Added to list");
		sa.displayRuns();
		System.out.println("Runrate: "+sa.calcRunRate());
		System.out.println("Lowest Runs: "+sa.lowestRunsScored());
		System.out.println("Count of player who batted: "+sa.getRunsData().size());
		
		
		
		
	}

}
