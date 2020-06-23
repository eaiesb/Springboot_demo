package com.eaiesb.mongodb.employees;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.eaiesb.mongodb.SequenceGeneratorService;



@RestController
public class EmployeesController {
	
	@Autowired
	private EmployeesRepository employeesRepository;
	
	@Autowired
	private SequenceGeneratorService sequenceGeneratorService ;

	@GetMapping("/employees")
	public List <Employees> AllEmployees()
	{
		return employeesRepository.findAll();
	}
	
	@GetMapping("/employees/{id}")
	public Optional<Employees> getEmployeesById(@PathVariable Long id)
	{
		return employeesRepository.findById(id);
	}
	
	@DeleteMapping("/employees/{id}")
	public void deleteEmployeesById(@PathVariable Long id)
	{
		employeesRepository.deleteById(id);
	}
	
	@PutMapping("/employees/{id}")
	public Employees updateEmployeesById(@PathVariable Long id,@Validated @RequestBody Employees employees)
	{
		Employees employee = employeesRepository.findById(id).get();
		employee.setEmployeeid(employees.getEmployeeid());
		employee.setFirstname(employees.getFirstname());
		employee.setLastname(employees.getLastname());
		employee.setEmail(employees.getEmail());
		employee.setPhonenumber(employees.getPhonenumber());
		employee.setHiredate(employees.getHiredate());
		employee.setJobid(employees.getJobid());
		employee.setSalary(employees.getSalary());
		employee.setCommisionpct(employees.getCommisionpct());
		employee.setManagerid(employees.getManagerid());
		employee.setDepartmentid(employees.getDepartmentid());
		
		return employeesRepository.save(employee); 
		
	}
	
	@PostMapping("/employees")
	public Employees CreateEmployees(@Validated @RequestBody Employees employees)
	{
		employees.setId(sequenceGeneratorService.generateSequence(Employees.SEQUENCE_NAME));
		return employeesRepository.save(employees);
	}
}
