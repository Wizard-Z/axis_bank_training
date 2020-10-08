package com.a7;

import java.io.Serializable;

public class Engine implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private transient String engineNo;
	private int cubicCapicity;
	public Engine() {}
	
	public Engine(String engineNo, int cubicCapicity) {
		this.engineNo = engineNo;
		this.cubicCapicity = cubicCapicity;
	}

	public String getEngineNo() {
		return engineNo;
	}
	@Override
	public String toString() {
		return "Engine [engineNo=" + engineNo + ", cubicCapicity=" + cubicCapicity + "]";
	}

	public void setEngineNo(String engineNo) {
		this.engineNo = engineNo;
	}
	public int getCubicCapicity() {
		return cubicCapicity;
	}
	public void setCubicCapicity(int cubicCapicity) {
		this.cubicCapicity = cubicCapicity;
	}
	
}
