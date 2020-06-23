package com.eaiesb.mongodb.locations;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Document (collection ="Locations")
public class Locations {
	
	
	@Transient
    public static final String SEQUENCE_NAME = "Locations_sequence";
	public Locations(Long id, Long locationid, String streetaddress, String postalcode, String city,
			String stateprovince, String countryid) {
		super();
		this.id = id;
		this.locationid = locationid;
		this.streetaddress = streetaddress;
		this.postalcode = postalcode;
		this.city = city;
		this.stateprovince = stateprovince;
		this.countryid = countryid;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getLocationid() {
		return locationid;
	}
	public void setLocationid(Long locationid) {
		this.locationid = locationid;
	}
	public String getStreetaddress() {
		return streetaddress;
	}
	public void setStreetaddress(String streetaddress) {
		this.streetaddress = streetaddress;
	}
	public String getPostalcode() {
		return postalcode;
	}
	public void setPostalcode(String postalcode) {
		this.postalcode = postalcode;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getStateprovince() {
		return stateprovince;
	}
	public void setStateprovince(String stateprovince) {
		this.stateprovince = stateprovince;
	}
	public String getCountryid() {
		return countryid;
	}
	public void setCountryid(String countryid) {
		this.countryid = countryid;
	}
	@Id
	private Long id;
	private Long locationid;
	private String streetaddress;
	private String postalcode;
	private String city;
	private String stateprovince;
	private String countryid;
	
	

}
