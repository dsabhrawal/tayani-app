package com.tayani.app.entities;

import java.time.LocalDate;

/**
 * This entity represents all the vehicles owned by Tayani Minerals for use in
 * their operations
 */
public class OurVehicles {

	private int id;
	private String vehicleNumber;
	private String vehicleModel;
	private LocalDate rtoTaxPaidDate;
	private LocalDate rtoFitnessDoneDate;
	private LocalDate rtoPermitRecievedDate;
	private LocalDate insuredTillDate;
	private LocalDate pucDoneDate;
	private String remarks;

	/**
	 * The no-argument constructor
	 */
	public OurVehicles() {

	}

	public OurVehicles(int id, String vehicleNumber, String vehicleModel, LocalDate rtoTaxPaidDate,
			LocalDate rtoFitnessDoneDate, LocalDate rtoPermitRecievedDate, LocalDate insuredTillDate,
			LocalDate pucDoneDate, String remarks) {
		this.id = id;
		this.vehicleNumber = vehicleNumber;
		this.vehicleModel = vehicleModel;
		this.rtoTaxPaidDate = rtoTaxPaidDate;
		this.rtoFitnessDoneDate = rtoFitnessDoneDate;
		this.rtoPermitRecievedDate = rtoPermitRecievedDate;
		this.insuredTillDate = insuredTillDate;
		this.pucDoneDate = pucDoneDate;
		this.remarks = remarks;
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
	 * @return the vehicleNumber
	 */
	public String getVehicleNumber() {
		return vehicleNumber;
	}

	/**
	 * @param vehicleNumber
	 *            the vehicleNumber to set
	 */
	public void setVehicleNumber(String vehicleNumber) {
		this.vehicleNumber = vehicleNumber;
	}

	/**
	 * @return the vehicleModel
	 */
	public String getVehicleModel() {
		return vehicleModel;
	}

	/**
	 * @param vehicleModel
	 *            the vehicleModel to set
	 */
	public void setVehicleModel(String vehicleModel) {
		this.vehicleModel = vehicleModel;
	}

	/**
	 * @return the rtoTaxPaidDate
	 */
	public LocalDate getRtoTaxPaidDate() {
		return rtoTaxPaidDate;
	}

	/**
	 * @param rtoTaxPaidDate
	 *            the rtoTaxPaidDate to set
	 */
	public void setRtoTaxPaidDate(LocalDate rtoTaxPaidDate) {
		this.rtoTaxPaidDate = rtoTaxPaidDate;
	}

	/**
	 * @return the rtoFitnessDoneDate
	 */
	public LocalDate getRtoFitnessDoneDate() {
		return rtoFitnessDoneDate;
	}

	/**
	 * @param rtoFitnessDoneDate
	 *            the rtoFitnessDoneDate to set
	 */
	public void setRtoFitnessDoneDate(LocalDate rtoFitnessDoneDate) {
		this.rtoFitnessDoneDate = rtoFitnessDoneDate;
	}

	/**
	 * @return the rtoPermitRecievedDate
	 */
	public LocalDate getRtoPermitRecievedDate() {
		return rtoPermitRecievedDate;
	}

	/**
	 * @param rtoPermitRecievedDate
	 *            the rtoPermitRecievedDate to set
	 */
	public void setRtoPermitRecievedDate(LocalDate rtoPermitRecievedDate) {
		this.rtoPermitRecievedDate = rtoPermitRecievedDate;
	}

	/**
	 * @return the insuredTillDate
	 */
	public LocalDate getInsuredTillDate() {
		return insuredTillDate;
	}

	/**
	 * @param insuredTillDate
	 *            the insuredTillDate to set
	 */
	public void setInsuredTillDate(LocalDate insuredTillDate) {
		this.insuredTillDate = insuredTillDate;
	}

	/**
	 * @return the pucDoneDate
	 */
	public LocalDate getPucDoneDate() {
		return pucDoneDate;
	}

	/**
	 * @param pucDoneDate
	 *            the pucDoneDate to set
	 */
	public void setPucDoneDate(LocalDate pucDoneDate) {
		this.pucDoneDate = pucDoneDate;
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder("OurVehicles [id=");
		builder.append(id);
		builder.append(", vehicleNumber=");
		builder.append(vehicleNumber);
		builder.append(", vehicleModel=");
		builder.append(vehicleModel);
		builder.append(", rtoTaxPaidDate=");
		builder.append(rtoTaxPaidDate);
		builder.append(", rtoFitnessDoneDate=");
		builder.append(rtoFitnessDoneDate);
		builder.append(", rtoPermitRecievedDate=");
		builder.append(rtoPermitRecievedDate);
		builder.append(", insuredTillDate=");
		builder.append(insuredTillDate);
		builder.append(", pucDoneDate=");
		builder.append(pucDoneDate);
		builder.append(", remarks=");
		builder.append(remarks);
		builder.append("]");
		return builder.toString();
	}

}
