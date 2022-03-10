package com.DealsApp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.DealsApp.entity.Deals;
import com.DealsApp.repository.DealsRepo;

@Service
public class DealsUserService {
	
	@Autowired
	private DealsRepo dealsRepo;

	//Get all deals
	public List<Deals> getAllDeals() {
		return dealsRepo.findAll();
	}
	
	// Get deals by item
	public Deals getDealByItem(String item) {
		return dealsRepo.findById(item).get();
	}

}
