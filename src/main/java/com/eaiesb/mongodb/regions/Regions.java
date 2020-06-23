package com.eaiesb.mongodb.regions;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Document (collection ="Regions")
public class Regions {
	
	@Transient
    public static final String SEQUENCE_NAME = "Regions_sequence";
	
	@Id
	private long id;
	private long regionid;
	private String regionname;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getRegionid() {
		return regionid;
	}
	public Regions(long id, long regionid, String regionname) {
		super();
		this.id = id;
		this.regionid = regionid;
		this.regionname = regionname;
	}
	public void setRegionid(long regionid) {
		this.regionid = regionid;
	}
	public String getRegionname() {
		return regionname;
	}
	public void setRegionname(String regionname) {
		this.regionname = regionname;
	}
	
	
	

}
