package services;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import dto.FlightStructure;

/**
 * Class that sorts the output
 * <p>
 * result as per the User's choice.
 *
 */
public class OutputPreferenceService {
	@Autowired
	private FareComparatorService flightComparator;

	public void sortFlights(List<FlightStructure> searchResult, int sortBy) {

		Comparator<FlightStructure> comparator;

		if (sortBy == 1) {
			comparator = flightComparator.getFlightComparatorbyFare();
			Collections.sort(searchResult, comparator);
		} else {
			comparator = flightComparator.getFlightComparatorbyFareDuration();
			Collections.sort(searchResult, comparator);
		}
	}
}
