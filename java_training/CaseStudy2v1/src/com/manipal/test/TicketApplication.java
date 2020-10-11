package com.manipal.test;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

import com.manipal.invalidexps.InvalidInputexp;
import com.manipal.tickets.Ticket;
import com.manipal.trains.Train;
import com.manipal.trains.TrainDAO;

public class TicketApplication {

	public static void main(String[] args) {
	
		System.out.println("In main() Testing..");
		System.out.println("ADD trains");
		Scanner scnr = new Scanner(System.in);
		TrainDAO trainDB = new TrainDAO();
		// Initialize
		trainDB.addTrain(new Train(1223, "Rajdhani", "Delhi", "Patna", 3000.0));
		trainDB.addTrain(new Train(1231, "Rajdhani", "Patna", "Delhi", 9900.0));
		trainDB.addTrain(new Train(9999, "ATrain", "Vought", "World", 3290.0));
		trainDB.addTrain(new Train(5232, "Rajdh", "Delhi", "Patna", 13345.0));
		trainDB.addTrain(new Train(1223, "Rajdhani", "Delhi", "Patna", 3000.0));
		System.out.println("Trains added!");
		trainDB.displayTrains();

		SimpleDateFormat sdfo = new SimpleDateFormat("dd/MM/yyyy");
		System.out.println("\nBOOKING\n\n");
		String name;
		int age;
		char gender;
		Date date;
		int passengerC,trainNo;
		Ticket ticket;
		Train train;
		boolean quit = false;
		String ch;
		while(!quit) {
			System.out.println("0: Quit!\n1: Book ticket");
			ch = scnr.nextLine();
			switch (ch) {
			case "1":
				try {
					System.out.println("Enter Train no");
					trainNo = Integer.parseInt(scnr.nextLine());
					train = trainDB.findTrain(trainNo);
					if(train== null)
						throw new InvalidInputexp("Train Not Present!!");
					System.out.println("Enter Travel Date-- DD/MM/YYYY");
					date = sdfo.parse(scnr.nextLine());
					if(new Date().compareTo(date)<0)
						ticket = new Ticket(date, train);//Move it down otherwise pnr is wasted
					else
						throw new InvalidInputexp("Travel in past!!");		
					System.out.println("Enter No of Passengers");
					passengerC = Integer.parseInt(scnr.nextLine());
					for(int i=1;i<=passengerC;i++) {
						System.out.println("Passenger =="+i);
						System.out.println("Enter name:");
						name = scnr.nextLine();
						System.out.println("Enter Age:");
						age = Integer.parseInt(scnr.nextLine());
						if(age <=0)
							throw new InvalidInputexp("Travel before born");
						System.out.println("Enter gender:");
						gender = scnr.nextLine().charAt(0);
						if(gender=='F'||gender=='M')
							ticket.addPassenger(name, age, gender);
						else
							throw new InvalidInputexp("Gender can be (M/F)");
					}
					System.out.println();
					ticket.generateTicket();
					System.out.println("\n Saving to file..");
					ticket.writeTicket();
				}
				catch(InvalidInputexp e) {
					System.out.println("Err.."+e.getMessage());
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					System.out.println("Invalid Date");
					e.printStackTrace();
					System.out.println();
				}
				catch(NumberFormatException e) {
					System.out.println("Err..."+e.getMessage());
				}
				catch(InputMismatchException e) {
					System.out.println("Some error in inputs..");
					e.printStackTrace();
					System.out.println();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					System.out.println("Error in saving file.."+e.getMessage());
					e.printStackTrace();
					System.out.println();
				}
				break;
			case "0":
				System.out.println("Bye!!");
				quit = true;
				break;
			default:
				System.out.println("Wrong\n ");
			}
		}
		scnr.close();
	}

}
