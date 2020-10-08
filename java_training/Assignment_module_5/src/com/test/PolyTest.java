package com.test;
import com.shape.Rectangle;
import com.shape.Square;
public class PolyTest {
	public static void main(String[] args) {
		System.out.println("In PolyTest");
		Square sq = new Square((float) 12.1);
		Rectangle rec = new Rectangle((float)10.1, (float)12.2);
		System.out.println("AREAS and PERIMETERS\n");
		System.out.println("Square: side: "+sq.getSide());
		sq.calcArea();
		sq.calcPeri();
		System.out.println("Rectange: length: "+rec.getBreadth()+
				" breadth: "+rec.getBreadth());
		rec.calcArea();
		rec.calcPeri();
	}

}
