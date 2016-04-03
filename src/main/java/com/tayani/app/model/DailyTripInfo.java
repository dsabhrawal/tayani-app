package com.tayani.app.model;

import java.time.LocalDate;

import com.tayani.app.entities.OurVehicles;

/**
 * This will be input daily for every vehicle working inside the mine.
 * <p>
 * Some fields will be input manually. Some fields will be calculated internally
 */
public class DailyTripInfo {

	private int id;
	private LocalDate date;
	private OurVehicles ourVehicle;
	private int openingReading;
	private int closingReading;
	private int distanceTravelled;
	private int dieselConsumed;
	private int trips;
	private int dieselConsumedPerTrip;
	private int dieselConsumedPerKM;
	private String remarks;
	private String driver;

	public DailyTripInfo(int id, LocalDate date, OurVehicles ourVehicle, int openingReading, int closingReading, int dieselConsumed,
			int trips, String remarks, String driver) {

		this.id = id;
		this.date = date;
		this.ourVehicle = ourVehicle;
		this.openingReading = openingReading;
		this.closingReading = closingReading;
		this.dieselConsumed = dieselConsumed;
		this.trips = trips;
		this.remarks = remarks;
		this.driver = driver;

		/*
		 * Sometimes odometers don't work on vehicles and hence we can get a
		 * situation in which openeingReading = ClosingReading = 0
		 * 
		 * We need to make sure that following calculations do not produce an
		 * error in such cases
		 */
		this.distanceTravelled = closingReading - openingReading;
		this.dieselConsumedPerTrip =  trips / dieselConsumed;
		this.dieselConsumedPerKM = distanceTravelled / dieselConsumed;

	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	
	

	/**
	 * @return the date
	 */
	public LocalDate getDate() {
		return date;
	}

	/**
	 * @param date the date to set
	 */
	public void setDate(LocalDate date) {
		this.date = date;
	}

	/**
	 * @return the ourVehicle
	 */
	public OurVehicles getOurVehicle() {
		return ourVehicle;
	}

	/**
	 * @param ourVehicle
	 *            the ourVehicle to set
	 */
	public void setOurVehicle(OurVehicles ourVehicle) {
		this.ourVehicle = ourVehicle;
	}

	/**
	 * @return the openingReading
	 */
	public int getOpeningReading() {
		return openingReading;
	}

	/**
	 * @param openingReading
	 *            the openingReading to set
	 */
	public void setOpeningReading(int openingReading) {
		this.openingReading = openingReading;
	}

	/**
	 * @return the closingReading
	 */
	public int getClosingReading() {
		return closingReading;
	}

	/**
	 * @param closingReading
	 *            the closingReading to set
	 */
	public void setClosingReading(int closingReading) {
		this.closingReading = closingReading;
	}

	/**
	 * @return the dieselConsumed
	 */
	public int getDieselConsumed() {
		return dieselConsumed;
	}

	/**
	 * @param dieselConsumed
	 *            the dieselConsumed to set
	 */
	public void setDieselConsumed(int dieselConsumed) {
		this.dieselConsumed = dieselConsumed;
	}

	/**
	 * @return the trips
	 */
	public int getTrips() {
		return trips;
	}

	/**
	 * @param trips
	 *            the trips to set
	 */
	public void setTrips(int trips) {
		this.trips = trips;
	}

	/**
	 * @return the remarks
	 */
	public String getRemarks() {
		return remarks;
	}

	/**
	 * @param remarks
	 *            the remarks to set
	 */
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	/**
	 * @return the driver
	 */
	public String getDriver() {
		return driver;
	}

	/**
	 * @param driver
	 *            the driver to set
	 */
	public void setDriver(String driver) {
		this.driver = driver;
	}

	/**
	 * @return the distanceTravelled
	 */
	public int getDistanceTravelled() {
		return distanceTravelled;
	}

	/**
	 * @return the dieselConsumedPerTrip
	 */
	public int getDieselConsumedPerTrip() {
		return dieselConsumedPerTrip;
	}

	/**
	 * @return the dieselConsumedPerKM
	 */
	public int getDieselConsumedPerKM() {
		return dieselConsumedPerKM;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder("DailyTripInfo [id=");
		builder.append(id);
		builder.append(", date=");
		builder.append(date);
		builder.append(", ourVehicle=");
		builder.append(ourVehicle);
		builder.append(", openingReading=");
		builder.append(openingReading);
		builder.append(", closingReading=");
		builder.append(closingReading);
		builder.append(", distanceTravelled=");
		builder.append(distanceTravelled);
		builder.append(", dieselConsumed=");
		builder.append(dieselConsumed);
		builder.append(", trips=");
		builder.append(trips);
		builder.append(", dieselConsumedPerTrip=");
		builder.append(dieselConsumedPerTrip);
		builder.append(", dieselConsumedPerKM=");
		builder.append(dieselConsumedPerKM);
		builder.append(", remarks=");
		builder.append(remarks);
		builder.append(", driver=");
		builder.append(driver);
		builder.append("]");
		return builder.toString();
	}

	

}
