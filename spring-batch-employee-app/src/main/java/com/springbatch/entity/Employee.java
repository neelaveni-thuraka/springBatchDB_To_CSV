package com.springbatch.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TABLE_EMPLOYEES_DATA_APP")
public class Employee implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "EMP_ID")
	private int empID;

	@Column(name = "EMP_FIRSTNAME")
	private String empFirstName;

	@Column(name = "EMP_MIDDLENAME")
	private String empMiddleName;

	@Column(name = "EMP_LASTNAME")
	private String empLastName;

	@Column(name = "EMP_EMAILID")
	private String empEmailID;

	@Column(name = "EMP_ORGANIZATION")
	private String empOrganization;

	@Column(name = "EMP_COUNTRY")
	private String empCountry;

	@Column(name = "EMP_STATE")
	private String empState;

	@Column(name = "EMP_ADDRESS")
	private String empAddress;

	public Employee() {

	}

	public Employee(int empID, String empFirstName, String empMiddleName, String empLastName, String empEmailID,
			String empOrganization, String empCountry, String empState, String empAddress) {
		super();
		this.empID = empID;
		this.empFirstName = empFirstName;
		this.empMiddleName = empMiddleName;
		this.empLastName = empLastName;
		this.empEmailID = empEmailID;
		this.empOrganization = empOrganization;
		this.empCountry = empCountry;
		this.empState = empState;
		this.empAddress = empAddress;
	}

	public int getEmpID() {
		return empID;
	}

	public void setEmpID(int empID) {
		this.empID = empID;
	}

	public String getEmpFirstName() {
		return empFirstName;
	}

	public void setEmpFirstName(String empFirstName) {
		this.empFirstName = empFirstName;
	}

	public String getEmpMiddleName() {
		return empMiddleName;
	}

	public void setEmpMiddleName(String empMiddleName) {
		this.empMiddleName = empMiddleName;
	}

	public String getEmpLastName() {
		return empLastName;
	}

	public void setEmpLastName(String empLastName) {
		this.empLastName = empLastName;
	}

	public String getEmpEmailID() {
		return empEmailID;
	}

	public void setEmpEmailID(String empEmailID) {
		this.empEmailID = empEmailID;
	}

	public String getEmpOrganization() {
		return empOrganization;
	}

	public void setEmpOrganization(String empOrganization) {
		this.empOrganization = empOrganization;
	}

	public String getEmpCountry() {
		return empCountry;
	}

	public void setEmpCountry(String empCountry) {
		this.empCountry = empCountry;
	}

	public String getEmpState() {
		return empState;
	}

	public void setEmpState(String empState) {
		this.empState = empState;
	}

	public String getEmpAddress() {
		return empAddress;
	}

	public void setEmpAddress(String empAddress) {
		this.empAddress = empAddress;
	}

	@Override
	public String toString() {
		return "Employee [empID=" + empID + ", empFirstName=" + empFirstName + ", empMiddleName=" + empMiddleName
				+ ", empLastName=" + empLastName + ", empEmailID=" + empEmailID + ", empOrganization=" + empOrganization
				+ ", empCountry=" + empCountry + ", empState=" + empState + ", empAddress=" + empAddress + "]";
	}

}
