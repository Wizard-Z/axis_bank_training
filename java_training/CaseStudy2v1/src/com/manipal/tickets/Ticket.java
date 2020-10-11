package com.manipal.tickets;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map.Entry;
import java.util.TreeMap;

import com.manipal.trains.*;
import com.manipal.psngr.*;

public class Ticket {
	private static int counter=100;
	private String pnr;
	private Date travelDate;
	private Train train;
	private TreeMap<Passenger,Double> pmap;
	
	public Ticket(Date travelDate, Train train) {
		this.travelDate = travelDate;
		this.train = train;
		this.pnr = generatePNR();
		pmap = new TreeMap<>();
		
	}
	
	public String getPnr() {
		return pnr;
	}

	public void setPnr(String pnr) {
		this.pnr = pnr;
	}

	public String generatePNR() {
		
		this.pnr = String.valueOf(this.train.getSource().charAt(0))+
				String.valueOf(this.train.getDestination().charAt(0))+
				"_"+new SimpleDateFormat("yyyyMMdd").format(travelDate)+
				"_"+counter++;
		return this.pnr;
	}
	
	public double calcPassengerFare(Passenger p) {
		double ticketP = (p.getGender()=='F')? 0.75*train.getTicketPrice():train.getTicketPrice();
		if (p.getAge()<=12)
			return ticketP*0.5;
		if(p.getAge()>=60)
			return ticketP*0.4;
		return ticketP;		
	}
	
	public void addPassenger(String name, int age, char gender) {
		Passenger p = new Passenger(name, age, gender);
		this.pmap.put(p , calcPassengerFare(p));
	}
	
	public double calculateTotalTicketPrice() {
		double totalFare=0;
		System.out.println("Calculating total Fare");
		for(Passenger pp:pmap.keySet()) {
			totalFare+= pmap.get(pp);
		}
		System.out.println("Total Fare: "+totalFare);
		return totalFare;
	}
	public StringBuilder generateTicket() {
		StringBuilder str;
		   SimpleDateFormat sdfo = new SimpleDateFormat("dd/MM/yyyy");
		String pticket = "PNR: "+this.pnr+"\n"
				+"Train no: "+this.train.getTrainNo()+"\n"
				+"From: "+this.train.getSource()+"\n"
				+"To: "+this.train.getDestination()+"\n"
				+"Travel Date: "+sdfo.format(travelDate)+"\n\n"
				+"Passengers: \n"
				+"Name\tAge\tGender\tFare\n";
		for(Entry<Passenger, Double> entry: pmap.entrySet()) {
			pticket = pticket.concat(entry.getKey().getName()+"\t"
					+entry.getKey().getAge()+"\t"
					+entry.getKey().getGender()+"\t"
					+entry.getValue()+"\n");
		}
		pticket = pticket.concat("Total Fare: "+Double.toString(calculateTotalTicketPrice()));
		str = new StringBuilder(pticket);
		System.out.println("\n\nTicket\n\n"+str);
		return str;
	}
	public void writeTicket() throws IOException {
		
		BufferedWriter br = new BufferedWriter(new FileWriter(this.pnr+".txt"));
		br.append(generateTicket());
		br.close();
		System.out.println("Ticket Book with PNR: "+this.pnr);
		
	}
	
	

	@Override
	public String toString() {
		return "Ticket [counter=" + counter + ", " + (pnr != null ? "pnr=" + pnr + ", " : "")
				+ (travelDate != null ? "travelDate=" + travelDate + ", " : "")
				+ (train != null ? "train=" + train + ", " : "") + (pmap != null ? "pmap=" + pmap : "") + "]";
	}
	
	

}
