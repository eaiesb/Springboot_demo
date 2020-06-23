package com.eaiesb.mongodb.jobhistory;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Document (collection ="Jobhistory")
public class Jobhistory {
	
	@Transient
    public static final String SEQUENCE_NAME = "Jobhistory_sequence";
	public Jobhistory(Long id, Long employeeid, Date startdate, Date enddate, String jobid, Long departmentid) {
		super();
		this.id = id;
		this.employeeid = employeeid;
		this.startdate = startdate;
		this.enddate = enddate;
		this.jobid = jobid;
		this.departmentid = departmentid;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getEmployeeid() {
		return employeeid;
	}
	public void setEmployeeid(Long employeeid) {
		this.employeeid = employeeid;
	}
	public Date getStartdate() {
		return startdate;
	}
	public void setStartdate(Date startdate) {
		this.startdate = startdate;
	}
	public Date getEnddate() {
		return enddate;
	}
	public void setEnddate(Date enddate) {
		this.enddate = enddate;
	}
	public String getJobid() {
		return jobid;
	}
	public void setJobid(String jobid) {
		this.jobid = jobid;
	}
	public Long getDepartmentid() {
		return departmentid;
	}
	public void setDepartmentid(Long departmentid) {
		this.departmentid = departmentid;
	}
	@Id
	private Long id;
	private Long employeeid;
	private Date startdate;
	private Date enddate;
	private String jobid;
	private Long departmentid;
	

}
