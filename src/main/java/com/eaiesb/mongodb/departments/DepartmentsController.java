package com.eaiesb.mongodb.departments;

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
public class DepartmentsController {
	
	@Autowired
	private DepartmentsRepository departmentsRepository;
	
	@Autowired
	private SequenceGeneratorService sequenceGeneratorService ;
	
	
	@GetMapping("/departments")
	public List <Departments> AllDepartments()
	
	{
		return departmentsRepository.findAll();
		
	}
	
	@GetMapping("/departments/{id}")
	public Optional<Departments> getDepartmentsById(@PathVariable long id)
	
	{
		return departmentsRepository.findById(id);
		
	}
	
	@DeleteMapping("/departments/{id}")
	public void deleteDepartmentsById(@PathVariable long id)
	
	{
		 departmentsRepository.deleteById(id);
		
	}
	
	@PutMapping("/departments/{id}")
	public Departments updateDepartmentsById(@PathVariable long id, @Validated @RequestBody Departments departments)
	
	{
		 Departments department = departmentsRepository.findById(id).get();
		 
		 department.setDepartmentid(departments.getDepartmentid());
		 department.setDepartmentname(departments.getDepartmentname());
		 department.setManagerid(departments.getManagerid());
		 department.setLocationid(departments.getLocationid());
		 
		 return departmentsRepository.save(department);
		 
		
	}
	
	@PostMapping("/departments")
	public Departments CreateDepartments(@Validated @RequestBody Departments departments)
	
	{
		 
		 
		 departments.setId(sequenceGeneratorService.generateSequence(Departments.SEQUENCE_NAME));
		 
		 return departmentsRepository.save(departments);
		 
		
	}

}
