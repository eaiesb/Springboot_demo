package com.eaiesb.mongodb.countries;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Document (collection ="Countries")
public class Countries {
	
	@Transient
    public static final String SEQUENCE_NAME = "Countries_sequence";
	@Id
	private Long id;
	private String countryid;
	private String countryname;
	public Countries(Long id, String countryid, String countryname, Long regionid) {
		super();
		this.id = id;
		this.countryid = countryid;
		this.countryname = countryname;
		this.regionid = regionid;
	}
	private Long regionid;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCountryid() {
		return countryid;
	}
	public void setCountryid(String countryid) {
		this.countryid = countryid;
	}
	public String getCountryname() {
		return countryname;
	}
	public void setCountryname(String countryname) {
		this.countryname = countryname;
	}
	public Long getRegionid() {
		return regionid;
	}
	public void setRegionid(Long regionid) {
		this.regionid = regionid;
	}
	

}
