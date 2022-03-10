package com.DealsApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.DealsApp.entity.Deals;
import com.DealsApp.service.DealsUserService;

@RestController
public class DealsUserController {
	
	@Autowired
	DealsUserService dealsUserserv;
	
	@Autowired
	Deals deals;
	
	//Weelcome user
	@GetMapping("/user")
	public String user() {
		return "Welcome User in Deals & Coupons!!";
	}
	
	//Get all deals
	@GetMapping("/user/deal")
	public List<Deals> getAllDeals() {
		return dealsUserserv.getAllDeals();
	}
	
	// Get deals by item
	@GetMapping("/user/deal/{item}")
	public Deals getDealByItem(@PathVariable String item) {
		return dealsUserserv.getDealByItem(item);
	}
}
