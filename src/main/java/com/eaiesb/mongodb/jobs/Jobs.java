package com.eaiesb.mongodb.jobs;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Document (collection ="Jobs")
public class Jobs {
	
	@Transient
    public static final String SEQUENCE_NAME = "Jobs_sequence";
	@Id
	private Long id;
	private String jobid;
	public Long getId() {
		return id;
	}
	public Jobs(Long id, String jobid, String jobtitle, Long minsalary, Long maxsalary) {
		super();
		this.id = id;
		this.jobid = jobid;
		this.jobtitle = jobtitle;
		this.minsalary = minsalary;
		this.maxsalary = maxsalary;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getJobid() {
		return jobid;
	}
	public void setJobid(String jobid) {
		this.jobid = jobid;
	}
	public String getJobtitle() {
		return jobtitle;
	}
	public void setJobtitle(String jobtitle) {
		this.jobtitle = jobtitle;
	}
	public Long getMinsalary() {
		return minsalary;
	}
	public void setMinsalary(Long minsalary) {
		this.minsalary = minsalary;
	}
	public Long getMaxsalary() {
		return maxsalary;
	}
	public void setMaxsalary(Long maxsalary) {
		this.maxsalary = maxsalary;
	}
	private String jobtitle;
	private Long minsalary;
	private Long maxsalary;

}

