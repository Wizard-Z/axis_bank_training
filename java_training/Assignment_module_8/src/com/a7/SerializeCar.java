package com.a7;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class SerializeCar {

	public static void main(String[] args) throws IOException {
		System.out.println("IN SerializeCar class");
		Engine eng;
		Car car;
		eng = new Engine("V12 Turbo",2369);
		car = new Car("BR12C1577", "Maruti", eng);
		System.out.println("Engine details: "+eng);
		System.out.println("Car details: "+car);
		
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("Cardata.ser"));
		oos.writeObject(car);
		System.out.println("\n--saved to Cardata.ser");
		oos.close();

	}

}
