package com.eaiesb.mongodb.regions;

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
import com.eaiesb.mongodb.countries.Countries;
import com.eaiesb.mongodb.countries.CountriesRepository;





@RestController
public class RegionsController {
	
	@Autowired
	private RegionsRepository regionsRepository;
	
	@Autowired
	private CountriesRepository countriesRepository;
	
	@Autowired
	private SequenceGeneratorService sequenceGeneratorService ;
	
	@GetMapping("/regions")
	public List <Regions> AllRegions()
	
	{
		return regionsRepository.findAll();
		
	}
	
	@PostMapping("/regions")
    public Regions createRegions(@Valid @RequestBody Regions regions) {
		
		regions.setId(sequenceGeneratorService.generateSequence(Regions.SEQUENCE_NAME));
		
        return regionsRepository.save(regions);
        		
    }
	
	@GetMapping("/regions/{id}")
	public  Optional<Regions> getRegionsbyId(@PathVariable long id)
	
	{
		return regionsRepository.findById(id);
		
	}
	
	@GetMapping("/regions/{id}/countries")
	public  List <Countries> getCountriesbyRegion(@PathVariable long id)
	
	{
		return countriesRepository.findByRegionid(id);
		
		
	}
	
	@DeleteMapping("/regions/{id}")
	public  void deleteRegionsbyId(@PathVariable long id)
	
	{
		regionsRepository.deleteById(id);
		
		
	}
	
	@PutMapping("/regions/{id}")
	public  Regions UpdateRegionsbyId(@PathVariable long id,@Validated @RequestBody Regions regions)
	
	{
		Regions region = regionsRepository.findById(id).get();
		region.setRegionname(regions.getRegionname());
		return regionsRepository.save(region);
		
	}

}
