package services;

import java.util.Comparator;

import dto.FlightStructure;

public class FareComparatorService {

	/**
	 * Returns a Comparator instance that<p>
	 * sorts on the basis of Flight Fares.
	 * @return Comparator<FlightStructure>
	 */
	public Comparator<FlightStructure> getFlightComparatorbyFare() {
		return (flight1, flight2) -> {
			return Double.compare(flight1.getFare(), flight2.getFare());
		};
	}

	/**
	 * Returns a Comparator instance that<p>
	 * sorts on the basis of Flight Fare and Flight Duration.
	 * @return Comparator<FlightStructure>
	 */
	public Comparator<FlightStructure> getFlightComparatorbyFareDuration() {
		return (flight1, flight2) -> {
			int s1 = Double.compare(flight1.getFare(), flight2.getFare());
			if (s1 == 0) {
				int s2 = Double.compare(flight1.getFlightDuration(), flight2.getFlightDuration());
				return s2;
			}
			return s1;
		};

	}
}
