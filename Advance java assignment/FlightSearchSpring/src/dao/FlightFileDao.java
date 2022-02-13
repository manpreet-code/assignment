package dao;

import java.util.List;

import dto.FlightFile;

/**
 * Deals with reading, modifying and retrieving<p>
 * information from CSV Files.
 *
 */
public interface FlightFileDao {
	public List<FlightFile> getAllFlightFiles();

	public FlightFile getFlightFile(String fileName);

	public void updateFlightFile(FlightFile flightFile);

	public void addFlightFile(FlightFile newFlightFile);

}
