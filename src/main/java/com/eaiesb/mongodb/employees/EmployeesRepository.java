package com.eaiesb.mongodb.employees;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface EmployeesRepository extends MongoRepository <Employees, Long> {

}
