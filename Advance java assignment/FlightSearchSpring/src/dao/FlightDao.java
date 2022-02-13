package dao;

import java.time.LocalDate;
import java.util.List;

import dto.FlightStructure;

/**
 * Deals with Retrieval of Flight related<p>
 * information like
 * list of flights, list of arrival<p>
 * and departure locations.
 *
 */
public interface FlightDao {

	public List<FlightStructure> getFlights(String arrivalLocation, String departLocation, LocalDate flightDate, String flightClass);
	
	@SuppressWarnings("rawtypes")
	public List getArrivalLocations();
	
	@SuppressWarnings("rawtypes")
	public List getDepartureLocations();

	public void addFlight(FlightStructure newFlight);
}
