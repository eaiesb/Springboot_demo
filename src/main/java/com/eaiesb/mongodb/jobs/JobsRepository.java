package com.eaiesb.mongodb.jobs;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface JobsRepository extends MongoRepository <Jobs, Long> {

}
