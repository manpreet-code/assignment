package com.nagarro.training.assignment2.FilghtInput;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FlightInput {
	 static Scanner Scanner = new Scanner(System.in);
	List <String> input = new ArrayList<>();
	public FlightInput() {
		input.add(inputDepartureLocation());
		input.add(inputArrivalLocation());
		input.add(inputFlightDate());
		input.add(inputFlightClass());
		input.add(inputOutputPreference());
	}
	
	public static String inputDepartureLocation() {
		System.out.println("Enter 3 letter departure location code");
		String departureLocation;
		while(true) {
			departureLocation = Scanner.next();
			try {
				if(departureLocation.length() != 3)
					throw new Exception("Error : Enter valid 3 letter departure location code.");
				else break;
			}catch(Exception e){
				System.out.println(e.getMessage()+"\nTry again...");
			}
		}
		return departureLocation.toUpperCase();
	}

	public static String inputArrivalLocation() {
		System.out.println("Enter 3 letter arrival location code");
		String arrivalLocation;
		while(true) {
			arrivalLocation = Scanner.next();
			try {
				if(arrivalLocation.length() != 3  )
					throw new Exception("Error : Enter Valid 3 letter arrival location code.");
				else break;
			}catch(Exception e){
				System.out.println(e.getMessage()+"\nTry again...");
			}
		}
		return arrivalLocation.toUpperCase();
	}

	public static String inputFlightDate() {
		System.out.println("Enter flight date(DD-MM-YYYY)");
		String flightDate;
		while(true) {
			flightDate = Scanner.next();
			try {
				String date[] = flightDate.split("-");
				int dd = Integer.parseInt(date[0]);
				int mm = Integer.parseInt(date[1]);
				int yyyy = Integer.parseInt(date[2]);
				if((flightDate.length() < 10) || (dd < 1 || dd > 31) || (mm < 1 || mm > 12) || (yyyy < 1 || yyyy > 9999))
					throw new Exception("Error : Enter Journey Date in DD-MM-YYYY Format.");
				else break;
			}catch(Exception e){
				System.out.println(e.getMessage()+"\nTry Again...");
			}
		}
		return flightDate;
	}

	public static String inputFlightClass() {
		System.out.println("Enter journey Class(E or B for Economy or Business Class respectively)");
		String flightClass;
		while(true) {
			flightClass = Scanner.next();
			try {
				if(!(flightClass.toUpperCase().equals("E") || flightClass.toUpperCase().equals("B")))
					throw new Exception("Error : Enter E or B as journey class.");
				else break;
			} catch (Exception e) {
				System.out.println(e.getMessage()+"\nTry Again...");
			}
		}
		return flightClass.toUpperCase();
	}

	public static String inputOutputPreference() {
		System.out.println("Enter Output Preference(Output Sorting Order as fare or both(for fare and duration))");
		String outputPreference;
		while(true) {
			outputPreference = Scanner.next();
			try {
				if(!(outputPreference.toLowerCase().equals("fare") || outputPreference.toLowerCase().equals("both")))
					throw new Exception("Error : Enter Sorting Order as fare or both");
				else break;
			} catch (Exception e) {
				System.out.println(e.getMessage()+"\nTry Again...");
			}
		}
		return outputPreference.toUpperCase();
	}
	public List<String> getinput() {
		return input;
	}


}
