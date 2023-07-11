package com.retailer.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Retailer {

	@Id
	@GeneratedValue
	private Long retailerId;
	@Column
	private String retailerName;
	@Column
	private String retailerLogo;
	@Column
	private String retailerAPIendpoint;

	public Retailer(Long retailerId, String retailerName, String retailerLogo, String retailerAPIendpoint) {
		super();
		this.retailerId = retailerId;
		this.retailerName = retailerName;
		this.retailerLogo = retailerLogo;
		this.retailerAPIendpoint = retailerAPIendpoint;
	}

	public Retailer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getRetailerId() {
		return retailerId;
	}

	public void setRetailerId(Long retailerId) {
		this.retailerId = retailerId;
	}

	public String getRetailerName() {
		return retailerName;
	}

	public void setRetailerName(String retailerName) {
		this.retailerName = retailerName;
	}

	public String getRetailerLogo() {
		return retailerLogo;
	}

	public void setRetailerLogo(String retailerLogo) {
		this.retailerLogo = retailerLogo;
	}

	public String getRetailerAPIendpoint() {
		return retailerAPIendpoint;
	}

	public void setRetailerAPIendpoint(String retailerAPIendpoint) {
		this.retailerAPIendpoint = retailerAPIendpoint;
	}

}
