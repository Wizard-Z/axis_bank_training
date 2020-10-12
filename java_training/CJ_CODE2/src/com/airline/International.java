package com.airline;

import java.util.HashMap;

public class International extends Airlines {
	@Override
	public String toString() {
		return "\nInternational [" + (countryCode != null ? "countryCode=" + countryCode : "") + "]\n";
	}
	private String countryCode;
	private double ticketCost;
	private HashMap<String,Integer> imap;
	//Initialize/
	International() {}
	public International(String airId,String Source, String Destination,String countryCode) throws InvalidEntryException {
		super(airId,Source,Destination);
		imap = new HashMap<>();
		imap.put("1001", 25000);
		imap.put("1002", 36000);
		imap.put("1003", 38000);
		if(!imap.containsKey(countryCode))
			throw new InvalidEntryException("Wrong Country Code!");

		this.countryCode = countryCode;
		
	}
	

	@Override
	public void bookTicket(int noOfTickets) {
		// TODO Auto-generated method stub
		System.out.println("\nCountry code is:  "+this.countryCode);
		this.ticketCost=noOfTickets*imap.get(this.countryCode);
		System.out.println("Total Price:\t"+this.ticketCost);
	}
	public double getTicketCost(int noOfTickets) {
		bookTicket(noOfTickets);
		return this.ticketCost;
	}



}
