package com.manipal.trains;

import java.util.HashMap;

public class TrainDAO {
	/*
	 * Since  no DataBase The DAO has hashMap of trains
	 */
	private HashMap<Integer,Train > tmap;
	public TrainDAO() {
		tmap = new HashMap<>();
	}
	
	public void addTrain(Train trn) {
		if(!tmap.containsKey(trn.getTrainNo())) {
			tmap.put(trn.getTrainNo(), trn);
			System.out.println("Train added!");
		}
		else
			System.out.println(trn.getTrainNo()+" Already present!");
	}
	public void displayTrains() {
		System.out.println(this.tmap);
	}
	public Train findTrain(int trainNo) {
		if(tmap.containsKey(trainNo)) {
			return tmap.get(trainNo);
		}
		return null;
	}
	

}
