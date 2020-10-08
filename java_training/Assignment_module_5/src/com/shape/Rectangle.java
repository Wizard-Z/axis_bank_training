package com.shape;

public class Rectangle implements Polygon{

	private float length;
	private float breadth;
	public Rectangle() {}
	
	public Rectangle(float length, float breadth) {
		this.length = length;
		this.breadth = breadth;
	}
	

	public float getLength() {
		return length;
	}

	public void setLength(float length) {
		this.length = length;
	}

	public float getBreadth() {
		return breadth;
	}

	public void setBreadth(float breadth) {
		this.breadth = breadth;
	}

	@Override
	public void calcArea() {
		System.out.printf("Rectange: Area: %.2f\n",length*breadth);
		
	}

	@Override
	public void calcPeri() {
		System.out.printf("Rectangle: Perimeter: %.2f\n",2*(length+breadth));
		
	}
	

}
