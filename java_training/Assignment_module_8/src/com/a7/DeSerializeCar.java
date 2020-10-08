package com.a7;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class DeSerializeCar {

	public static void main(String[] args)throws IOException, ClassNotFoundException {
			System.out.println("In DeserializeCar");
			ObjectInputStream oin = new ObjectInputStream(new FileInputStream("Cardata.ser"));
			
			Car carObj = (Car)oin.readObject();
			oin.close();
			System.out.println("Reading..... done\nCar data follows:\n"+carObj);
			System.out.println("Engine Details:\n"+carObj.getEngine());
			

	}

}
