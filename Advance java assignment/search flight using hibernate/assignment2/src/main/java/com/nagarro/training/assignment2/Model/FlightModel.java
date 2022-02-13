package com.nagarro.training.assignment2.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
//@Table(name="flight")
public class FlightModel  {
		@Id @GeneratedValue
		@Column(name = "Id")
		private int id;
		@Column(name = "FLIGHT_NO")
		private String flightNumber;
		@Column(name = "DEP_LOC")
		private String departureLocation;
		@Column(name = "ARR_LOC")
		private String arrivalLocation;
		@Column(name = "VALID_TILL")
		private String validTill;
		@Column(name = "FLIGHT_TIME")
		private String flightTime;
		@Column(name = "FLIGHT_DUR")
		private double flightDuration;
		@Column(name = "FARE")
		private double fare;
		@Column(name = "SEAT_AVAILABILITY")
		private String seatAvailability;
		@Column(name = "FLIGHT_CLASS")
		private String flightClass;
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getFlightNumber() {
			return flightNumber;
		}
		public void setFlightNumber(String flightNumber) {
			this.flightNumber = flightNumber;
		}
		public String getDepartureLocation() {
			return departureLocation;
		}
		public void setDepartureLocation(String departureLocation) {
			this.departureLocation = departureLocation;
		}
		public String getArrivalLocation() {
			return arrivalLocation;
		}
		public void setArrivalLocation(String arrivalLocation) {
			this.arrivalLocation = arrivalLocation;
		}
		public String getValidTill() {
			return validTill;
		}
		public void setValidTill(String validTill) {
			this.validTill = validTill;
		}
		public String getFlightTime() {
			return flightTime;
		}
		public void setFlightTime(String flightTime) {
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
		public String getSeatAvailability() {
			return seatAvailability;
		}
		public void setSeatAvailability(String seatAvailability) {
			this.seatAvailability = seatAvailability;
		}
		public String getFlightClass() {
			return flightClass;
		}
		public void setFlightClass(String flightClass) {
			this.flightClass = flightClass;
		}
					
		
		
	


	

}

	