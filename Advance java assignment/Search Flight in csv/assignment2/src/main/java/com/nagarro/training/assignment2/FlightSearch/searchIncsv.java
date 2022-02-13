package com.nagarro.training.assignment2.FlightSearch;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;

import com.nagarro.training.assignment2.Model.FlightModel;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;


public class searchIncsv {
	List<String> input;
	List<String> pathofcsv;
	 List<FlightModel> flightList = new ArrayList<>();
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

	public searchIncsv(List<String> pathofcsv, List<String> input) {
		this.pathofcsv = pathofcsv;
		this.input = input;

	}

	
	

	public  void readfile()
			throws FileNotFoundException, IOException, CsvValidationException, ParseException {
		for(String path:pathofcsv) {
		try (CSVReader reader = new CSVReader(new FileReader(path))) {
			String[] str = reader.readNext();
			while ((str = reader.readNext()) != null) {
				String columnarr[] = new String[9];
				int i = 0;
				StringTokenizer column = new StringTokenizer(str[0], "|");
				while (column.hasMoreTokens()) {
					columnarr[i++] = (String) column.nextElement();
				}
				cheackadd(columnarr, input);

			}

		}
	}}

	public void cheackadd(String[] columnarr, List<String> input) throws ParseException {
		Date flightdate1 = new SimpleDateFormat("dd-MM-yyyy").parse(input.get(2));
		Date flightdate2 = new SimpleDateFormat("dd-MM-yyyy").parse(columnarr[3]);
		if (columnarr[1].equals(input.get(0)) && columnarr[2].equals(input.get(1))
				&& columnarr[8].contains(input.get(3)) && columnarr[7].equals("Y")) {
			if (flightdate1.compareTo(flightdate2) <= 0) {
				FlightModel flight = new FlightModel();
				flight.setFlightNumber(columnarr[0]);
				flight.setDepartureLocation(columnarr[1]);
				flight.setArrivalLocation(columnarr[2]);
				flight.setValidTill(columnarr[3]);
				flight.setFlightTime(columnarr[4]);
				flight.setFlightDuration(Double.parseDouble(columnarr[5]));
				flight.setSeatAvailability(columnarr[7]);
				flight.setFlightClass(columnarr[8]);
				int fare = Integer.parseInt(columnarr[6]);
				if (columnarr[8].equals("E"))
					flight.setFare(fare);
				else
					flight.setFare((int) Math.round(fare * 1.4));
				flightList.add(flight);
			}
		}

	}

	public  List<FlightModel> getFlightList() {
		return flightList;
	}

}
