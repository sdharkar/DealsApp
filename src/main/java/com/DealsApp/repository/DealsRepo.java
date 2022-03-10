package com.DealsApp.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.DealsApp.entity.Deals;

@Repository
public interface DealsRepo extends MongoRepository<Deals, String>  {

}
