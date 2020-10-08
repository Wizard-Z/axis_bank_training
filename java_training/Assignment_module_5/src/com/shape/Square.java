package com.shape;

public class Square implements Polygon {

	private float side;
	public Square() {}
	
	public Square(float side) {
		this.side = side;
	}
	
	

	public float getSide() {
		return side;
	}

	public void setSide(float side) {
		this.side = side;
	}

	@Override
	public void calcArea() {
		System.out.printf("Square: Area: %.2f\n",(this.side*this.side));
	}

	@Override
	public void calcPeri() {
		System.out.printf("Square: Perimeter: %.2f\n",this.side*4);
		
	}
	

}
