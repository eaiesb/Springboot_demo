package com.eaiesb.mongodb.countries;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

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
public class CountriesController {
	
	@Autowired
	private CountriesRepository countriesRepository;
	
	@Autowired
	private SequenceGeneratorService sequenceGeneratorService ;
	
	@GetMapping("/countries")
	public List <Countries> AllCountries()
	
	{
		return countriesRepository.findAll();
		
	}
	
	@PostMapping("/countries")
    public Countries createCountries(@Valid @RequestBody Countries countries) {
		
		countries.setId(sequenceGeneratorService.generateSequence(Countries.SEQUENCE_NAME));
		
        return countriesRepository.save(countries);
        		
    }
	
	@GetMapping("/countries/{id}")
	public  Optional<Countries> getCountriesbyId(@PathVariable long id)
	
	{
		return countriesRepository.findById(id);
		
	}
	
	@DeleteMapping("/countries/{id}")
	public  void deleteCountriesbyId(@PathVariable long id)
	
	{
		countriesRepository.deleteById(id);
		
		
	}
	
	@PutMapping("/countries/{id}")
	public  Countries UpdateCountriesbyId(@PathVariable long id,@Validated @RequestBody Countries countries)
	
	{
		Countries countrie = countriesRepository.findById(id).get();
		countrie.setCountryname(countries.getCountryname());
		
		return countriesRepository.save(countrie);
		
	}

}
