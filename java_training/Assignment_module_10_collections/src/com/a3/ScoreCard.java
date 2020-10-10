package com.a3;

import java.util.HashMap;
import java.util.Scanner;

public class ScoreCard {
	public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in);
		System.out.println("Enter Runs Scored..");
		HashMap<String,Integer> report= new HashMap<>();
		String temp;
		
		while(scnr.hasNext()) {
			temp = scnr.next();
			if(temp.equals("."))
				break;
			report.put(temp.split("-")[0],
					Integer.parseInt(temp.split("-")[1]));
		}
		scnr.close();
		System.out.println(report);
		System.out.println("\nPlayers who batted");
		for(String players: report.keySet())
			System.out.println(players);
		
		
		System.out.println("\nScores by Players");
		int total_score=0, curr_score=0,Max = -1;
		String tp="";
		for(String players: report.keySet()) {
			curr_score = report.get(players);
			System.out.println(players+": "+curr_score);
			total_score+= curr_score;
			if(Max<=curr_score) {
				Max = curr_score;
				tp = players;
			}
		}
		
		System.out.println("Total Score: "+total_score);
		System.out.println("Name of Highest Scorer: "+tp);
		if(report.containsKey("Dhoni"))
			System.out.println("Runs scored by Dhoni: "+report.get("Dhoni"));
	}

}
