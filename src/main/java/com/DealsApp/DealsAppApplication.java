package com.DealsApp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.DealsApp.entity.Deals;
import com.DealsApp.repository.DealsRepo;

@SpringBootApplication
public class DealsAppApplication implements CommandLineRunner {
	
	@Autowired
	private DealsRepo dealsRepo;

	public static void main(String[] args) {
		SpringApplication.run(DealsAppApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Deals d1 = new Deals("1A1", "Clothing", "Brands Factory 50% off coupon");
		Deals d2 = new Deals("1B1", "Watch", "Exchange offer on Titan watches save upto 25% on new watch");
		Deals d3 = new Deals("1C1", "Speaker", "Sony Speakers range starts at 1999/- only");
		Deals d4 = new Deals("1D1", "Smartphons", "Pre-order Samsung Galaxy S22 Ultra & get Galaxy watch4 for free!!");
		Deals d5 = new Deals("1E1", "TV", "Get upto 30% off on latest LG SametTV");
		
		dealsRepo.save(d1);
		dealsRepo.save(d2);
		dealsRepo.save(d3);
		dealsRepo.save(d4);
		dealsRepo.save(d5);
		
		List<Deals> deals = dealsRepo.findAll();
		
		for (Deals d : deals) {
			System.out.println(d.toString());
		}
		
	}

}
