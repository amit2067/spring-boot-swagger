package uk.springboot.swagger.demo.beans;

import io.swagger.annotations.ApiModelProperty;

public class Employee {

	@ApiModelProperty(notes="Employee Id")
	private Long empId;
	
	@ApiModelProperty(notes="Employee Name")
	private String name;
	
	@ApiModelProperty(notes="Employee Email Address")
	private String emailAddress;
	
	@ApiModelProperty(notes="Employee Designation")
	private String designation;

	public Employee() {
	}

	public Employee(Long empId, String name, String emailAddress, String designation) {
		this.empId = empId;
		this.name = name;
		this.emailAddress = emailAddress;
		this.designation = designation;
	}

	public Long getEmpId() {
		return empId;
	}

	public void setEmpId(Long empId) {
		this.empId = empId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

}
