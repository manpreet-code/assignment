package com.nagarro.training.assignment2.FlightSearch;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.util.Collections;
import java.util.List;

import com.nagarro.training.assignment2.FileHandeling.FetchFiles;
import com.nagarro.training.assignment2.Model.FlightModel;
import com.nagarro.training.assignment2.Model.SortFlight;
import com.nagarro.training.assignment2.Output.OutputData;
import com.opencsv.exceptions.CsvValidationException;



public class search implements Runnable {
	List<String> input;

	public search(List<String> input) {
		this.input = input;
	}
	int firstCount=0;

	public void searchFlight() throws InterruptedException, CsvValidationException, FileNotFoundException, IOException, ParseException {
		List<String> Files = new FetchFiles().fetch();
		firstCount=Files.size();

			searchIncsv flightIncsv=new searchIncsv(Files, input);
			flightIncsv.readfile();
		List<FlightModel> flightList = flightIncsv.getFlightList();
		sortOutput(input, flightList);
		new OutputData().displayOutput(flightList);

	}

	public void sortOutput(List<String> input, List<FlightModel> flightList) {
		if (input.get(4).equals("FARE")) {
			Collections.sort(flightList);
		} else if (input.get(4).equals("BOTH")) {
			Collections.sort(flightList, new SortFlight());
		}
	}
	public synchronized void checkNewfile() throws CsvValidationException, FileNotFoundException, IOException, ParseException {
		int newCount;
		List<String> Files = new FetchFiles().fetch();
		newCount=Files.size();
		if((newCount-firstCount)!=0) {
			firstCount=newCount;
			searchIncsv flightIncsv=new searchIncsv(Files, input);
			flightIncsv.readfile();
		List<FlightModel> flightList = flightIncsv.getFlightList();
		sortOutput(input, flightList);
		new OutputData().displayOutput(flightList);
		}
		
		
	}

	@Override
	public void run() {
		while(true) {
		try {
			checkNewfile();
		} catch (CsvValidationException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		try{
		       Thread.sleep(6*1000); 
		      }
		    catch(InterruptedException e)
		    {
		}
		
	}

}}
