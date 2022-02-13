package dto;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.persistence.*;

import java.text.ParseException;

/**
 * Model class for Flight Details
 *
 *
 */
@Entity
@Table(name = "flights")
public class FlightStructure {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int flightId;
	
	@Column(name = "flightnumber")
	private String flightNumber;
	
	@Column(name = "departlocation")
	private String departLocation;
	
	@Column(name = "arrivallocation")
	private String arrivalLocation;
	
	@Column(name = "flightdate")
	private LocalDate flightDate;
	
	@Column(name = "flighttime")
	private int flightTime;
	
	@Column(name = "flightduration")
	private double flightDuration;
	
	@Column(name = "fare")
	private double fare;
	
	@Column(name = "seatavailablility")
	private char seatAvailablility;
	
	@Column(name = "flightclass")
	private String flightClass;

	public String getFlightNumber() {
		return flightNumber;
	}

	public void setFlightNumber(String flightNumber) {
		this.flightNumber = flightNumber;
	}

	public String getDepartLocation() {
		return departLocation;
	}

	public void setDepartLocation(String departLocation) {
		this.departLocation = departLocation;
	}

	public String getArrivalLocation() {
		return arrivalLocation;
	}

	public void setArrivalLocation(String arrivalLocation) {
		this.arrivalLocation = arrivalLocation;
	}

	public String getFlightDate() {
		return flightDate.toString();
	}

	public void setFlightDate(String flightDate) throws ParseException {
		this.flightDate = LocalDate.parse(flightDate, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
	}

	public int getFlightTime() {
		return flightTime;
	}

	public void setFlightTime(int flightTime) {
		this.flightTime = flightTime;
	}

	public double getFlightDuration() {
		return flightDuration;
	}

	public void setFlightDuration(double flightDuration) {
		this.flightDuration = flightDuration;
	}

	public double getFare() {
		return fare;
	}

	public void setFare(double fare) {
		this.fare = fare;
	}

	public char getSeatAvailablility() {
		return seatAvailablility;
	}

	public void setSeatAvailablility(char seatAvailablility) {
		this.seatAvailablility = seatAvailablility;
	}

	public String getFlightClass() {
		return flightClass;
	}

	public void setFlightClass(String flightClass) {
		this.flightClass = flightClass;
	}

	public int getFlightId() {
		return flightId;
	}

	public void setFlightId(int flightId) {
		flightId = this.flightId;
	}

}
