package services;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import dao.FlightDao;
import dto.FlightStructure;

/**
 * Class provides a service layer for<p>
 * searching flights.
 *
 */
public class FlightSearchService {
	@Autowired
	private FlightDao flightdao;

	/**
	 * Returns a list of flights as per<p>
	 * User query.
	 * @param to : String
	 * @param from : String
	 * @param date : String
	 * @param flightClass : String
	 * @return List<FlightStructure>
	 * @throws ParseException
	 */
	public List<FlightStructure> getSearchResult(String to, String from, String date, String flightClass) throws ParseException {
		List<FlightStructure> searchResult;
		
		System.out.println(date);
		LocalDate flightdate = LocalDate.parse(date, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		System.out.println(flightdate.toString());
		searchResult = flightdao.getFlights(to, from, flightdate, flightClass);

		return searchResult;
	}

}
