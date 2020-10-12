package com.airline;

import java.util.HashMap;

public class Domestic extends Airlines {
	
	private String zonalCode;
	private double ticketCost;
	private HashMap<String,Integer> zmap;
	//Initialize/
	Domestic() {}
	public Domestic(String airId,String Source, String Destination,String zonalCode) throws InvalidEntryException {
		super(airId,Source,Destination);
		zmap = new HashMap<>();
		zmap.put("Z001", 3500);
		zmap.put("Z002", 4000);
		zmap.put("Z003", 4500);
		if(!zmap.containsKey(zonalCode))
			throw new InvalidEntryException("Wrong Zonal Code!");

		this.zonalCode = zonalCode;
	}
	

	@Override
	public String toString() {
		return "\nDomestic [" + (zonalCode != null ? "zonalCode=" + zonalCode : "") + "]\n";
	}
	@Override
	public void bookTicket(int noOfTickets) {
		// TODO Auto-generated method stub
		System.out.println("\nZonal code is:\t"+this.zonalCode);
		this.ticketCost=noOfTickets*zmap.get(this.zonalCode);
		System.out.println("Total Price:\t"+this.ticketCost);
	}
	public String getZonalCode() {
		return zonalCode;
	}



}
