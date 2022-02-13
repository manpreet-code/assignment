package com.nagarro.training.assignment2;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.util.Scanner;

import com.nagarro.training.assignment2.FilghtInput.FlightInput;
import com.nagarro.training.assignment2.FlightSearch.search;
import com.opencsv.exceptions.CsvValidationException;



public class App 
{
	public static void main(String[] args) throws InterruptedException, CsvValidationException, FileNotFoundException, IOException, ParseException {
		boolean flag=true;
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		do {
		search s = new search(new FlightInput().getinput());
		s.searchFlight();
		Thread Thread= new Thread(s);
		Thread.start();
		System.out.print("Do you want to Search more Flights");
		String ans = scanner.nextLine().toLowerCase();
		if (ans.equals("no")) {
			flag = false;
		}
		}while(flag);

	}
}
