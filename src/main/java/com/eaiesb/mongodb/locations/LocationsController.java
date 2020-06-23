package com.eaiesb.mongodb.locations;

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
public class LocationsController {
	
	@Autowired
	private LocationsRepository locationsRepository;
	
	@Autowired
	private SequenceGeneratorService sequenceGeneratorService ;
	
	
	@GetMapping("/locations")
	public List <Locations> AllLocations()
	
	{
		return locationsRepository.findAll();
		
	}
	@GetMapping("/locations/{id}")
	public Optional<Locations> getLocationsByid(@PathVariable long id)
	
	{
		return locationsRepository.findById(id);
		
	}
	
	@DeleteMapping("/locations/{id}")
	public void deleteLocationsByid(@PathVariable long id)
	
	{
		 locationsRepository.deleteById(id);
		
	}
	
	@PutMapping("/locations/{id}")
	public Locations UpdateLocationsByid(@PathVariable long id, @Validated @RequestBody Locations locations)
	
	{
		Locations location = locationsRepository.findById(id).get();
		
		location.setCity(locations.getCity());
		location.setStreetaddress(locations.getStreetaddress());
		location.setPostalcode(locations.getPostalcode());
		location.setCity(locations.getCity());
		location.setStateprovince(locations.getStateprovince());
		location.setCountryid(locations.getCountryid());
		
		return locationsRepository.save(location);
	
		
	}
	
	@PostMapping("/locations")
    public Locations createLocations(@Valid @RequestBody Locations locations) {
		
		locations.setId(sequenceGeneratorService.generateSequence(Locations.SEQUENCE_NAME));
		
        return locationsRepository.save(locations);
        		
    }
	
	

}
