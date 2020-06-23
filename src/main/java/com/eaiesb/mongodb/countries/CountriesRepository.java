package com.eaiesb.mongodb.countries;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface CountriesRepository extends MongoRepository <Countries, Long>{
	
	List <Countries> findByRegionid(Long regionid);

}
