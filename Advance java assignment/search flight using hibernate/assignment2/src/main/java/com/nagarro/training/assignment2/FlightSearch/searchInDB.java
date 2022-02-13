package com.nagarro.training.assignment2.FlightSearch;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.StringTokenizer;

import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import javax.transaction.Transaction;

import org.hibernate.*;

import java.text.ParseException;

import com.nagarro.training.assignment2.HibernateSession.CreateSession;
import com.nagarro.training.assignment2.Model.FlightModel;
import com.nagarro.training.assignment2.Output.OutputData;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

public class searchInDB {
	List<String> pathofcsv;
	Session session =  CreateSession.getSession().openSession();

	public searchInDB(List<String> pathofcsv) {
		this.pathofcsv = pathofcsv;

	}

	public void readfile() throws Exception {
		for (String path : pathofcsv) {
			try (CSVReader reader = new CSVReader(new FileReader(path))) {
				String[] str = reader.readNext();
				while ((str = reader.readNext()) != null) {
					String columnarr[] = new String[9];
					int i = 0;
					StringTokenizer column = new StringTokenizer(str[0], "|");
					while (column.hasMoreTokens()) {
						columnarr[i++] = (String) column.nextElement();
					}
					add(columnarr);

				}

			}
		}
	}

	public void add(String[] columnarr) throws Exception {

		FlightModel flight = new FlightModel();
		flight.setFlightNumber(columnarr[0]);
		flight.setDepartureLocation(columnarr[1]);
		flight.setArrivalLocation(columnarr[2]);
		flight.setValidTill(columnarr[3]);
		flight.setFlightTime(columnarr[4]);
		flight.setFlightDuration(Double.parseDouble(columnarr[5]));
		flight.setFare(Integer.parseInt(columnarr[6]));
		flight.setSeatAvailability(columnarr[7]);
		flight.setFlightClass(columnarr[8]);
		org.hibernate.Transaction tx =   session.beginTransaction();
		session.save(flight);
		
		tx.commit();

	}
	public void searchAvailableFlights(List<String> input) throws Exception {
		try {
			String queryString = "From FlightModel where DEP_LOC = :depLoc and ARR_LOC = :arrLoc and VALID_TILL >= :flightDate " + 
					"and SEAT_AVAILABILITY = :Seat and FLIGHT_CLASS like :Class order By FARE ASC ";
			if(input.get(4).equals("BOTH"))
				queryString = queryString + ", FLIGHT_DUR ASC ";
			Query query = session.createQuery(queryString);
			query.setParameter("depLoc", input.get(0));
			query.setParameter("arrLoc", input.get(1));
			query.setParameter("flightDate", input.get(2));
			query.setParameter("Seat", "Y");
			query.setParameter("Class", "%"+input.get(3)+"%");
			List flights = query.list();
			new OutputData().displayOutput(flights,input);
			session.close();
			
		}catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

}
