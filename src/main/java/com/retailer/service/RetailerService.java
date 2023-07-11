package com.retailer.service;

import java.util.List;

import com.retailer.entity.Retailer;

public interface RetailerService { 
	
	public Retailer addRetailer(Retailer retailer);
	public Retailer getRetailer(Long retailerId);
	public List<Retailer> getAllRetailers();
	public String deleteRetailer(Long retailerId);
	public String updateRetailer(Long retailerId, Retailer retailer);


}
