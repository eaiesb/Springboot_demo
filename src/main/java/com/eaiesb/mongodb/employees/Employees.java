package com.eaiesb.mongodb.employees;

import java.sql.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Document  (collection="Employees")
public class Employees {
	
	@Transient
    public static final String SEQUENCE_NAME = "Employees_sequence";
	@Id
	private Long id;
	private Long employeeid;
	private String firstname;
	private String lastname;
	private String email;
	private String phonenumber;
	public Employees(Long id, Long employeeid, String firstname, String lastname, String email, String phonenumber,
			Date hiredate, String jobid, Long salary, Long commisionpct, Long managerid, Long departmentid) {
		super();
		this.id = id;
		this.employeeid = employeeid;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.phonenumber = phonenumber;
		this.hiredate = hiredate;
		this.jobid = jobid;
		this.salary = salary;
		this.commisionpct = commisionpct;
		this.managerid = managerid;
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
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhonenumber() {
		return phonenumber;
	}
	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}
	public Date getHiredate() {
		return hiredate;
	}
	public void setHiredate(Date hiredate) {
		this.hiredate = hiredate;
	}
	public String getJobid() {
		return jobid;
	}
	public void setJobid(String jobid) {
		this.jobid = jobid;
	}
	public Long getSalary() {
		return salary;
	}
	public void setSalary(Long salary) {
		this.salary = salary;
	}
	public Long getCommisionpct() {
		return commisionpct;
	}
	public void setCommisionpct(Long commisionpct) {
		this.commisionpct = commisionpct;
	}
	public Long getManagerid() {
		return managerid;
	}
	public void setManagerid(Long managerid) {
		this.managerid = managerid;
	}
	public Long getDepartmentid() {
		return departmentid;
	}
	public void setDepartmentid(Long departmentid) {
		this.departmentid = departmentid;
	}
	private Date hiredate;
	private String jobid;
	private Long salary;
	private Long commisionpct;
	private Long managerid;
	private Long departmentid;
	
	

}
