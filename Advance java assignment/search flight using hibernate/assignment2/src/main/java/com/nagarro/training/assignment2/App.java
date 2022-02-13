package com.nagarro.training.assignment2;


import java.util.Scanner;

import com.nagarro.training.assignment2.FilghtInput.FlightInput;
import com.nagarro.training.assignment2.FlightSearch.search;

public class App {
	public static void main(String[] args) throws Exception {
		boolean flag = true;
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		do {
			FlightInput input = new FlightInput();
			search s = new search(input.getinput());
			s.searchFlight();
			Thread Thread = new Thread(s);
			Thread.start();
			System.out.print("Do you want to Search more Flights");
			String ans = scanner.nextLine().toLowerCase();
			if (ans.equals("no")) {
				flag = false;
			}
		} while (flag);

	}
}
