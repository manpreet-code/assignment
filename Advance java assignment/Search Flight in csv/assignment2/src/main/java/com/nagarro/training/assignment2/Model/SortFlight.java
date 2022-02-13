package com.nagarro.training.assignment2.Model;

import java.util.Comparator;

public class SortFlight implements Comparator<FlightModel>{

	@Override
	public int compare(FlightModel fd1, FlightModel fd2) {
		if (fd1.getFare() < fd2.getFare())
			return -1;
		else if (fd1.getFare() > fd2.getFare())
			return 1;
		else {
			double duration1 = fd1.getFlightDuration();
			double duration2 = fd2.getFlightDuration();
			if (duration1 > duration2)
				return 1;
			else if (duration1 < duration2)
				return -1;
			return 0;
		}
	}

}
