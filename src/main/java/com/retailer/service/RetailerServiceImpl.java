package com.retailer.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.retailer.entity.Retailer;
import com.retailer.repository.RetailerRepository;

@Service
public class RetailerServiceImpl implements RetailerService{ 
	
	@Autowired
	private RetailerRepository retailerRepo;

	@Override
	public Retailer addRetailer(Retailer retailer) {
		// TODO Auto-generated method stub
		return retailerRepo.save(retailer);
	}

	@Override
	public Retailer getRetailer(Long retailerId) {
		// TODO Auto-generated method stub
		return retailerRepo.findById(retailerId).get();
	}

	@Override
	public List<Retailer> getAllRetailers() {
		// TODO Auto-generated method stub
		return retailerRepo.findAll();
	}

	@Override
	public String deleteRetailer(Long retailerId) {
		// TODO Auto-generated method stub
		retailerRepo.deleteById(retailerId);
		return "Retailer Successfully Deleted";
	}

	@Override
	public String updateRetailer(Long retailerId, Retailer retailer) {
		// TODO Auto-generated method stub
		Retailer retailerFromDb = retailerRepo.findById(retailerId).get();
        System.out.println(retailerFromDb.toString());
        retailerFromDb.setRetailerName(retailer.getRetailerName());
        retailerFromDb.setRetailerLogo(retailer.getRetailerLogo());
        retailerFromDb.setRetailerAPIendpoint(retailer.getRetailerAPIendpoint());
        retailerRepo.save(retailerFromDb);
		return "Retailer Successfully Updated";
	} 

}
