package com.eaiesb.mongodb.departments;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Document (collection ="Departments")
public class Departments {
	
	@Transient
    public static final String SEQUENCE_NAME = "Department_sequence";
	@Id
	private Long id;
	private Long departmentid;
	private String departmentname;
	private Long managerid;
	private Long locationid;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getDepartmentid() {
		return departmentid;
	}
	public void setDepartmentid(Long departmentid) {
		this.departmentid = departmentid;
	}
	public String getDepartmentname() {
		return departmentname;
	}
	public void setDepartmentname(String departmentname) {
		this.departmentname = departmentname;
	}
	public Long getManagerid() {
		return managerid;
	}
	public void setManagerid(Long managerid) {
		this.managerid = managerid;
	}
	public Long getLocationid() {
		return locationid;
	}
	public void setLocationid(Long locationid) {
		this.locationid = locationid;
	}
	public Departments(Long id, Long departmentid, String departmentname, Long managerid, Long locationid) {
		super();
		this.id = id;
		this.departmentid = departmentid;
		this.departmentname = departmentname;
		this.managerid = managerid;
		this.locationid = locationid;
	}
	

}
