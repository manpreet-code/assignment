package dto;

import javax.persistence.*;

/**
 * Model class for CSV Files
 *
 */
@Entity
@Table(name = "FlightFiles")
public class FlightFile {

	@Id
	@Column(name = "filename")
	private String fileName;
	@Column(name = "norows")
	private int noRows;

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public int getNoRows() {
		return noRows;
	}

	public void setNoRows(int noRows) {
		this.noRows = noRows;
	}

	@Override
	public boolean equals(Object obj) {
		FlightFile flightFile = (FlightFile) obj;
		return this.getFileName().equals(flightFile.getFileName());
	}
}
