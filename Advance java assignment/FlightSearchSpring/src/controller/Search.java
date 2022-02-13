package controller;

import java.text.ParseException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import dto.FlightStructure;
import services.FlightSearchService;
import services.OutputPreferenceService;

/**
 * Controller for Searching Flights
 *
 */
@Controller
public class Search {

	@Autowired
	private FlightSearchService flightSearch;

	@Autowired
	private OutputPreferenceService outputPreferance;

	@RequestMapping("/search")
	public ModelAndView searchFlights(HttpServletRequest request, HttpServletResponse response) throws ParseException {
		ModelAndView mv = new ModelAndView();

		String from = request.getParameter("from").toString();
		String to = request.getParameter("to").toString();
		String date = request.getParameter("date").toString();
		String flightClass = request.getParameter("class").toString();
		int sortBy = Integer.parseInt(request.getParameter("sortBy").toString());

		List<FlightStructure> searchResult = flightSearch.getSearchResult(to, from, date, flightClass);
		outputPreferance.sortFlights(searchResult, sortBy);

		mv.addObject("searchResult", searchResult);
		mv.setViewName("result");
		return mv;
	}

}
