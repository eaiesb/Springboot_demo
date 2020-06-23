package com.eaiesb.mongodb.jobs;

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
public class JobsController {
	
	@Autowired
	private JobsRepository jobsRepository ;
	
	@Autowired
	private SequenceGeneratorService sequenceGeneratorService ;

	@GetMapping("/jobs")
	public List <Jobs> AllJobs()
	
	{
		return jobsRepository.findAll();
		
	}
	
	@GetMapping("/jobs/{id}")
	public Optional<Jobs> getJobsByid(@PathVariable long id)
	
	{
		return jobsRepository.findById(id);
		
	}
	
	@DeleteMapping("/jobs/{id}")
	public void deleteJobsByid(@PathVariable long id)
	
	{
		 jobsRepository.deleteById(id);
		
	}
	
	@PutMapping("/jobs/{id}")
	public Jobs updateJobsByid(@PathVariable long id,@Validated @RequestBody Jobs jobs )
	
	{
			Jobs job = jobsRepository.findById(id).get();
			job.setJobid(jobs.getJobid());
			job.setJobtitle(jobs.getJobtitle());
			job.setMinsalary(jobs.getMinsalary());
			job.setMaxsalary(jobs.getMaxsalary());
			
		return jobsRepository.save(job);
		
	}
	@PostMapping("/jobs")
	public Jobs CreateJobs(@Validated @RequestBody Jobs jobs )
	
	{
			
			jobs.setId(sequenceGeneratorService.generateSequence(Jobs.SEQUENCE_NAME));
		return jobsRepository.save(jobs);
		
	}
	
}
