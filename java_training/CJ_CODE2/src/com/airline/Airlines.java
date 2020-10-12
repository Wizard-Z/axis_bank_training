package com.airline;

public abstract class Airlines {
	private String airId;
	private String source;
	private String destination;
	public Airlines() {}
	public Airlines(String airId, String source, String destination)throws InvalidEntryException {
		if(!airId.startsWith("BOEING"))
			throw new InvalidEntryException("Invalid ID");
		if(source.equalsIgnoreCase(destination))
			throw new InvalidEntryException("Source and Destination are same!");
		this.airId = airId;
		this.source = source;
		this.destination = destination;
	}
	public String getAirId() {
		return airId;
	}
	public void setAirId(String airId) {
		this.airId = airId;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source)throws InvalidEntryException {
		if(source.equalsIgnoreCase(this.getDestination()))
			throw new InvalidEntryException("Source is same as destination");
		this.source = source;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) throws InvalidEntryException {
		if(destination.equalsIgnoreCase(this.getSource()))
			throw new InvalidEntryException("Source is same as destination");
		this.destination = destination;
	}
	
	public abstract void bookTicket(int noOfTickets);
	
	@Override
	public String toString() {
		return "Airlines [" + (airId != null ? "airId=" + airId + ", " : "")
				+ (source != null ? "source=" + source + ", " : "")
				+ (destination != null ? "destination=" + destination : "") + "]";
	}
	
	
	

}
