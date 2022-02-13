package services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.FlightDao;


@Service
public class AirportCodeLoaderService {

	@Autowired
	private FlightDao flightdao;

	/**
	 * Returns list of Departure Locations.
	 * @return List<String>
	 */
	@SuppressWarnings("unchecked")
	public List<String> getFromAirportCodes() {
		List<String> fromAirportCodes;
		fromAirportCodes = flightdao.getDepartureLocations();
		return fromAirportCodes;
	}

	/**
	 * Returns a list of Arrival Locations.
	 * @return List<String>
	 */
	@SuppressWarnings("unchecked")
	public List<String> getToAirportCodes() {
		List<String> toAirportCodes;
		toAirportCodes = flightdao.getArrivalLocations();
		return toAirportCodes;
	}
}
