package com.tayani.app.model;

import java.time.LocalDate;

import com.tayani.app.entities.DieselBuyer;

public class DieselSold {

	private int id;
	private LocalDate date;
	private DieselBuyer dieselBuyer;
	private int quantity;
	private int ratePerLtr;

	/**
	 * The no-argument constructor
	 */
	@SuppressWarnings("unused")
	private DieselSold() {

	}

	public DieselSold(int id, DieselBuyer dieselBuyer, LocalDate date, int quantity) {
		this.id = id;
		this.dieselBuyer = dieselBuyer;
		this.date = date;
		this.quantity = quantity;
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
	 * @return the dieselBuyer
	 */
	public DieselBuyer getDieselBuyer() {
		return dieselBuyer;
	}

	/**
	 * @param dieselBuyer the dieselBuyer to set
	 */
	public void setDieselBuyer(DieselBuyer dieselBuyer) {
		this.dieselBuyer = dieselBuyer;
	}

	/**
	 * @return the ratePerLtr
	 */
	public int getRatePerLtr() {
		return ratePerLtr;
	}

	/**
	 * @param ratePerLtr the ratePerLtr to set
	 */
	public void setRatePerLtr(int ratePerLtr) {
		this.ratePerLtr = ratePerLtr;
	}

	/**
	 * @return the date
	 */
	public LocalDate getDate() {
		return date;
	}

	/**
	 * @param date
	 *            the date to set
	 */
	public void setDate(LocalDate date) {
		this.date = date;
	}

	/**
	 * @return the quantity
	 */
	public int getDieselSold() {
		return quantity;
	}

	/**
	 * @param quantity
	 *            the quantity to set
	 */
	public void setDieselSold(int quantity) {
		this.quantity = quantity;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder("DieselSold [id=");
		builder.append(id);
		builder.append(", date=");
		builder.append(date);
		builder.append(", dieselBuyer=");
		builder.append(dieselBuyer);
		builder.append(", quantity=");
		builder.append(quantity);
		builder.append(", ratePerLtr=");
		builder.append(ratePerLtr);
		builder.append("]");
		return builder.toString();
	}



}
