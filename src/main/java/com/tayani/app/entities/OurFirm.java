package com.tayani.app.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.spring.annotation.UIScope;

/**
 * 
 * This entity will represent the name of our firm which sells the stone
 * aggregates
 * <p>
 * 
 * @author Aditya Rajurkar
 *
 */

@SpringComponent
@UIScope
@Entity
@Table(name = "our_firm")
public class OurFirm {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "our_firm_name")
	private String ourFirmName;

	@Column(name = "owner")
	private String owner;

	@Column(name = "date_of_incorporation")
	private LocalDate dateOfIncorporation;

	/**
	 * The no argument constructor
	 */
	public OurFirm() {

	}

	public OurFirm(String ourFirmName, String owner, LocalDate dateOfIncorporation) {
		this.ourFirmName = ourFirmName;
		this.owner = owner;
		this.dateOfIncorporation = dateOfIncorporation;
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
	 * @return the ourFirmName
	 */
	public String getOurFirmName() {
		return ourFirmName;
	}

	/**
	 * @param ourFirmName
	 *            the ourFirmName to set
	 */
	public void setOurFirmName(String ourFirmName) {
		this.ourFirmName = ourFirmName;
	}

	/**
	 * @return the owner
	 */
	public String getOwner() {
		return owner;
	}

	/**
	 * @param owner
	 *            the owner to set
	 */
	public void setOwner(String owner) {
		this.owner = owner;
	}

	/**
	 * @return the dateOfIncorporation
	 */
	public LocalDate getDateOfIncorporation() {
		return dateOfIncorporation;
	}

	/**
	 * @param dateOfIncorporation
	 *            the dateOfIncorporation to set
	 */
	public void setDateOfIncorporation(LocalDate dateOfIncorporation) {
		this.dateOfIncorporation = dateOfIncorporation;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder("OurFirm [ id=");
		builder.append(id);
		builder.append(", ourFirmName=");
		builder.append(ourFirmName);
		builder.append(", owner=");
		builder.append(owner);
		builder.append(", dateOfIncorporation=");
		builder.append(dateOfIncorporation);
		builder.append(" ]");
		return builder.toString();
	}

}
