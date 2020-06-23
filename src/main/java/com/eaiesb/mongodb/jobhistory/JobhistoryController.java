package com.eaiesb.mongodb.jobhistory;

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
public class JobhistoryController {
	
	@Autowired
	private JobhistoryRepository jobhistoryRepository;
	
	@Autowired
	private SequenceGeneratorService sequenceGeneratorService ;

	@GetMapping("/jobhistory")
	public List <Jobhistory> AllJobhistory()
	
	{
		return jobhistoryRepository.findAll();
		
	}
	
	@GetMapping("/jobhistory/{id}")
	public Optional<Jobhistory> getJobhistoryByid(@PathVariable Long id)
	
	{
		return jobhistoryRepository.findById(id);
		
	}
	
	@DeleteMapping("/jobhistory/{id}")
	public void deleteJobhistoryByid(@PathVariable Long id)
	
	{
		 jobhistoryRepository.deleteById(id);
		
	}
	@PutMapping("/jobhistory/{id}")
	public Jobhistory updateJobhistoryByid(@PathVariable Long id,@Validated @RequestBody Jobhistory jobhistory)
	
	{
		Jobhistory jobhistory1 = jobhistoryRepository.findById(id).get();
		
		jobhistory1.setEmployeeid(jobhistory.getEmployeeid());
		jobhistory1.setStartdate(jobhistory.getStartdate());
		jobhistory1.setEnddate(jobhistory.getEnddate());
		jobhistory1.setJobid(jobhistory.getJobid());
		jobhistory1.setDepartmentid(jobhistory.getDepartmentid());
		
		return jobhistoryRepository.save(jobhistory1);
	}
	
	@PostMapping("/jobhistory")
	public Jobhistory CreateJobhistory(@Validated @RequestBody Jobhistory jobhistory)
	
	{
		jobhistory.setId(sequenceGeneratorService.generateSequence(Jobhistory.SEQUENCE_NAME));
		return jobhistoryRepository.save(jobhistory);
		
	}

}
