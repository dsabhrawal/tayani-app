package com.tayani.app.model;

import java.time.LocalDate;

/**
 * Purpose of this class is to persist quantity of diesel used in the mine into DB (All units in liters)
 * <p>
 * 1: Logic is as follows
 * <p>
 * totalDieselInflow = openingBalance + quantityReceived
 * <p>
 * closingBalance = totalDieselInflow - quantityIssued
 * <p>
 * 2: The closingBalance of previous day becomes openingBalance of next day
 * <p>
 * 3: Example - If today = 2nd Jan, openingBalance = 100 ltr, quantityReceived = 50 ltr
 * quantityIssued = 75 ltr
 * <p>
 * so for 2nd Jan,
 * totalDieselInflow = 100 + 50 = 150 ltr
 * closingBalance = 150 - 75 = 75 ltr
 * <p>
 * for 3rd Jan, openingBalance = 75 ltr and so on
 * */
public class DailyDieselUsage {
	
	// Here date might itself be serve as id. Please check what to do

	private int id;
	private LocalDate date;
	public int openingBalance;
	public int quantityReceived;
	public int totalDieselInflow;
	public int quantityIssued;
	public int closingBalance;

	/**
	 * The No-Argument Constructor.
	 */
	public DailyDieselUsage() {

	}

	public DailyDieselUsage(int id, LocalDate date, int openingBalance, int quantityReceived, int totalDieselInflow,
			int quantityIssued, int closingBalance) {
		this.id = id;
		this.date = date;
		this.openingBalance = openingBalance;
		this.quantityReceived = quantityReceived;
		this.totalDieselInflow = totalDieselInflow;
		this.quantityIssued = quantityIssued;
		this.closingBalance = closingBalance;
	}
	
	

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
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
	 * @return the openingBalance
	 */
	public int getOpeningBalance() {
		return openingBalance;
	}

	/**
	 * @param openingBalance the openingBalance to set
	 */
	public void setOpeningBalance(int openingBalance) {
		this.openingBalance = openingBalance;
	}

	/**
	 * @return the quantityReceived
	 */
	public int getQuantityReceived() {
		return quantityReceived;
	}

	/**
	 * @param quantityReceived the quantityReceived to set
	 */
	public void setQuantityReceived(int quantityReceived) {
		this.quantityReceived = quantityReceived;
	}

	/**
	 * @return the totalDieselInflow
	 */
	public int getTotalDieselInflow() {
		return totalDieselInflow;
	}

	/**
	 * @param totalDieselInflow the totalDieselInflow to set
	 */
	public void setTotalDieselInflow(int totalDieselInflow) {
		this.totalDieselInflow = totalDieselInflow;
	}

	/**
	 * @return the quantityIssued
	 */
	public int getQuantityIssued() {
		return quantityIssued;
	}

	/**
	 * @param quantityIssued the quantityIssued to set
	 */
	public void setQuantityIssued(int quantityIssued) {
		this.quantityIssued = quantityIssued;
	}

	/**
	 * @return the closingBalance
	 */
	public int getClosingBalance() {
		return closingBalance;
	}

	/**
	 * @param closingBalance the closingBalance to set
	 */
	public void setClosingBalance(int closingBalance) {
		this.closingBalance = closingBalance;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder("DailyDieselUsage [id=");
		builder.append(id);
		builder.append(", date=");
		builder.append(date);
		builder.append(", openingBalance=");
		builder.append(openingBalance);
		builder.append(", quantityReceived=");
		builder.append(quantityReceived);
		builder.append(", totalDieselInflow=");
		builder.append(totalDieselInflow);
		builder.append(", quantityIssued=");
		builder.append(quantityIssued);
		builder.append(", closingBalance=");
		builder.append(closingBalance);
		builder.append("]");
		return builder.toString();
	}

	
	
}
