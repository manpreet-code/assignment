package com.nagarro.training.assignment2.FlightSearch;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.util.Collections;
import java.util.List;

import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;

import com.nagarro.training.assignment2.FileHandeling.FetchFiles;
import com.nagarro.training.assignment2.Model.FlightModel;
import com.nagarro.training.assignment2.Output.OutputData;
import com.opencsv.exceptions.CsvValidationException;



public class search implements Runnable {
	List<String> input;

	public search(List<String> input) {
		this.input = input;
	}
	int firstCount=0;

	public void searchFlight() throws Exception{
		List<String> Files = new FetchFiles().fetch();
		firstCount=Files.size();
			searchInDB flightIncsv=new searchInDB(Files);
			flightIncsv.readfile();
			flightIncsv.searchAvailableFlights(input);

	}

	
	public synchronized void checkNewfile() throws Exception {
		int newCount;
		List<String> Files = new FetchFiles().fetch();
		newCount=Files.size();
		if((newCount-firstCount)!=0) {
			firstCount=newCount;
			searchInDB flightIncsv=new searchInDB(Files);
			flightIncsv.readfile();
			flightIncsv.searchAvailableFlights(input);

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
		} catch (Exception e) {
			// TODO Auto-generated catch block
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
