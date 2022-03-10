package com.DealsApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.DealsApp.entity.Deals;
import com.DealsApp.service.DealsAdminService;

@RestController
public class DealsAdminController {
	
	@Autowired
	DealsAdminService dealsAdminserv;
	
	// Welcome page
	@GetMapping("/")
	public String welcome() {
		return "Welcome to the Deals & Coupons Finder!!!";
	}
	
	// Welcome admin page
	@GetMapping("/admin")
	public String admin() {
		return "Welcome Admin in Deals & Coupons!!";
	}
	
	// Get all deals
	@GetMapping("/admin/deal")
	public List<Deals> getAllDeals() {
		return dealsAdminserv.getAllDeals();
	}
	
	// Get deals by item
	@GetMapping("/admin/deal/{item}")
	public Deals getDealsByItem(@PathVariable String item) {
		return dealsAdminserv.getDealsByItem(item);	
	}
	
	// Save deal
	@PostMapping("/Save")
	public String saveDeal(@ModelAttribute("deal") Deals deal) {
		System.out.println(deal);
		dealsAdminserv.setDeal(deal);
		return "redirect:/";
		
	}
	
	// Edit deal
	@RequestMapping("/edit/{id}")
		public ModelAndView updateDeal(@PathVariable("id") String id) {
			ModelAndView modelAndView = new ModelAndView("update");
			Deals deals = dealsAdminserv.getDealById(id);
			modelAndView.addObject("Deals", deals);
			return modelAndView;
	}
	
	// Update deal
	@RequestMapping("/update")
	public String update(@ModelAttribute("deal") Deals deal) {
		System.out.println(deal);
		deal = dealsAdminserv.updateDeal(deal);
		return "redirect:/";
	}
	
	// delete deal by id
	@RequestMapping("/delete/{id}")
	public String deleteDeal(@PathVariable("id") String id) {
		dealsAdminserv.deleteDeal(id);
		return "redirect:/";
	}

}
