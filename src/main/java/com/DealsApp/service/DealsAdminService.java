package com.DealsApp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.DealsApp.entity.Deals;
import com.DealsApp.repository.DealsRepo;

@Service
public class DealsAdminService {
	
	@Autowired
	private DealsRepo dealsRepo;
	
	// Get all deals
	public List<Deals> getAllDeals() {
		return dealsRepo.findAll();
	}
	
	// Get deals by item
	public Deals getDealsByItem(String item) {
		return dealsRepo.findById(item).get();
	}
	
	// Save deal
	public void setDeal(Deals deal) {
		System.out.println(deal);
		dealsRepo.save(deal);
	}
	
	//Edit deals
	public Deals getDealById(String id) {
		
		return null;
	}
	
	//Update deals
		public Deals updateDeal(Deals deal) {
			List<Deals> deals = dealsRepo.findAll();
			try {
				for(Deals d : deals) {
					if(d.getId() == deal.getId()) {
						dealsRepo.save(deal);
					}
				}
				return deal;
			} catch(Exception e) {
				System.out.println("Deal not Found!!!");
				return null;
			}
		}
	
	// Delete deals by id
	public void deleteDeal(String id) {
		dealsRepo.deleteById(id);
		
	}
	
}
