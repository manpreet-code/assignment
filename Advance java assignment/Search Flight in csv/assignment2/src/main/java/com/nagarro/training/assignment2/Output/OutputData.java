package com.nagarro.training.assignment2.Output;

import java.util.List;

import com.nagarro.training.assignment2.Model.FlightModel;



public class OutputData {
	public void displayOutput(List<FlightModel> flightList) {
		if(flightList.isEmpty())
		{
			System.out.println("No Flights Found...");
			return;
		}
		System.out.println("\t----------Available Flights----------");
		System.out.println("FLIGHT_NO|DEP_lOC|ARR_LOC|VALID_TILL|FLIGHT_TIME|FLIGHT_DUR|FARE");
		for(FlightModel flight : flightList) {
			System.out.print(flight.getFlightNumber()+"\t|");
			System.out.print(flight.getDepartureLocation()+"\t|");
			System.out.print(flight.getArrivalLocation()+"\t|");
			System.out.print(flight.getValidTill()+"\t|");
			System.out.print(flight.getFlightTime()+"\t|");
			System.out.print(flight.getFlightDuration()+"\t|");
			System.out.println(flight.getFare());
		}
	}
}
