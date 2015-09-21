package edu.qu.entities;

public class POS {
	
	private String posType; 
	private String posText; 
	private double positive;
	private double negative;
	private double neurtral; 
	
	public double getNeurtral() {
		return neurtral;
	}
	public void setNeurtral(double neurtral) {
		this.neurtral = neurtral;
	}
	public double getPositive() {
		return positive;
	}
	public void setPositive(double positive) {
		this.positive = positive;
	}
	public double getNegative() {
		return negative;
	}
	public void setNegative(double negative) {
		this.negative = negative;
	}
	public String getPosText() {
		return posText;
	}
	public void setPosText(String posText) {
		this.posText = posText;
	}
	public String getPosType() {
		return posType;
	}
	public void setPosType(String posType) {
		this.posType = posType;
	}

	
	

}
