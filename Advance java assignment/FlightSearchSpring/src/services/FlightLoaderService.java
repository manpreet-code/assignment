package services;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;

import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;

import constant.Constants;
import dao.FlightDao;
import dao.FlightFileDao;
import dto.FlightFile;
import dto.FlightStructure;

/**
 * Implements reading and retrieving data from<p>
 * CSV Files.
 *
 */
public class FlightLoaderService {

	@Autowired
	FlightFileDao flightFileDao;

	@Autowired
	FlightDao flightDao;

	private File folder = new File(Constants.FOLDERPATH);
	private File[] folderFiles;
	private List<FlightFile> dbFiles;
	private FileReader fileReader;
	private CSVParser parser = new CSVParserBuilder().withSeparator('|').build();
	private CSVReader csvReader;

	/**
	 * Loads flight data, scheduled for<p>
	 * repeatitions.
	 * @throws IOException
	 * @throws ParseException
	 */
	@Scheduled(fixedRate = 7000, initialDelay = 5000)
	public void loadFlights() throws IOException, ParseException {

		dbFiles = flightFileDao.getAllFlightFiles();
		folderFiles = folder.listFiles();
		System.out.println("System is checking new flights");
		checkNewFlights();
	}

	/**
	 * Checks for modification of CSV files folder<p>
	 * by comparing the files in database and
	 * files currently in the folder.
	 * @throws IOException
	 * @throws ParseException
	 */
	private void checkNewFlights() throws IOException, ParseException {
		for (File folderFile : folderFiles) {
			FlightFile folderflightFile = new FlightFile();
			folderflightFile.setFileName(folderFile.getName());

			if (!dbFiles.contains(folderflightFile)) {
				readFlightsFromFile(folderflightFile, folderFile);
			} else {
				checkForNewEntriesInFile(folderflightFile, folderFile);
			}
		}
	}

	/**
	 * Reads the data from the CSV File<p>
	 * and add the CSV File to database as well.
	 * @param folderflightFile : FlightFile
	 * @param folderFile : File
	 */
	private void readFlightsFromFile(FlightFile folderflightFile, File folderFile) {
		try {

			fileReader = new FileReader(folderFile);
			csvReader = new CSVReaderBuilder(fileReader).withCSVParser(parser).build();
			List<String[]> allFlightData = csvReader.readAll();
			int noOfEntries = allFlightData.size() - 1;

			for (int rowNumber = 1; rowNumber < allFlightData.size(); rowNumber++) {
				FlightStructure newFlight = createFlightObject(allFlightData.get(rowNumber));
				flightDao.addFlight(newFlight);
			}

			folderflightFile.setNoRows(noOfEntries);
			flightFileDao.addFlightFile(folderflightFile);

		} catch (FileNotFoundException fileNotFoundException) {

		} catch (IOException ioException) {
			
		} catch (Exception exception) {
		
		}
	}

	/**
	 * Checks if any particular Flight Object has been modified.
	 * @param folderflightFile : FlightFile
	 * @param folderFile : File
	 * @throws IOException
	 * @throws ParseException
	 */
	private void checkForNewEntriesInFile(FlightFile folderflightFile, File folderFile) throws IOException, ParseException {
			fileReader = new FileReader(folderFile);
			csvReader = new CSVReaderBuilder(fileReader).withCSVParser(parser).build();
			List<String[]> allFlightData = csvReader.readAll();
			int noOfEntries = allFlightData.size() - 1;

			FlightFile dbFlightFile = (FlightFile) flightFileDao.getFlightFile(folderflightFile.getFileName());
			int noOfEntriesDB = dbFlightFile.getNoRows();

			if (noOfEntriesDB != noOfEntries) {

				for (int rowNumber = 1 + noOfEntriesDB; rowNumber < allFlightData.size(); rowNumber++) {
					FlightStructure newFlight = createFlightObject(allFlightData.get(rowNumber));
					flightDao.addFlight(newFlight);
				}

				folderflightFile.setNoRows(noOfEntries);
				flightFileDao.updateFlightFile(folderflightFile);
			}
	}

	/**
	 * Creates a new Flight Object.
	 * @param flightData : String[]
	 * @return
	 * @throws ParseException
	 */
	private FlightStructure createFlightObject(String[] flightData) throws ParseException {
		FlightStructure flight = new FlightStructure();
		flight.setFlightNumber(flightData[0]);
		flight.setDepartLocation(flightData[1]);
		flight.setArrivalLocation(flightData[2]);
		flight.setFlightDate(flightData[3]);
		flight.setFlightTime(Integer.parseInt(flightData[4]));
		flight.setFlightDuration(Double.parseDouble(flightData[5]));
		flight.setFare(Integer.parseInt(flightData[6]));
		flight.setSeatAvailablility(flightData[7].charAt(0));
		flight.setFlightClass(flightData[8]);
		return flight;
	}
}
