package com.DealsApp.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.DealsApp.entity.Deals;

public interface DealsRepo extends MongoRepository<Deals, String>  {

}
