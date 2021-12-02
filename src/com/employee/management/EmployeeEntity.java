package com.employee.management;

public class EmployeeEntity {
	private int eId;
	private String efirstName;
	private String elastName;
	private String eEmail;
	private String eSalary;
	private String eDesignation;
	private String ereportTo;
	private String ejoiningDate;

	public int geteId() {
		return eId;
	}

	public void seteId(int eId) {
		this.eId = eId;
	}

	public String getefirstName() {
		return efirstName;
	}

	public void setefirstName(String efirstName) {
		this.efirstName = efirstName;
	}

	public String getelastName() {
		return elastName;
	}

	public void setelastName(String elastName) {
		this.elastName = elastName;
	}

	public String geteEmail() {
		return eEmail;
	}

	public void seteEmail(String eEmail) {
		this.eEmail = eEmail;
	}

	public String geteSalary() {
		return eSalary;
	}

	public void seteSalary(String eSalary) {
		this.eSalary = eSalary;
	}

	public String geteDesignation() {
		return eDesignation;
	}

	public void seteDesignation(String eDesignation) {
		this.eDesignation = eDesignation;
	}

	public String getereportTo() {
		return ereportTo;
	}

	public void setereportTo(String ereportTo) {
		this.ereportTo = ereportTo;
	}

	public String getejoiningDate() {
		return ejoiningDate;
	}

	public void setejoiningDate(String ejoiningDate) {
		this.ejoiningDate = ejoiningDate;
	}
	
	public EmployeeEntity(String efirstName, String elastName, String eEmail, String eSalary, String eDesignation,
			String ereportTo, String ejoiningDate) {
		super();
		this.efirstName = efirstName;
		this.elastName = elastName;
		this.eEmail = eEmail;
		this.eSalary = eSalary;
		this.eDesignation = eDesignation;
		this.ereportTo = ereportTo;
		this.ejoiningDate = ejoiningDate;
	}

	@Override
	public String toString() {
		return "Employee [eId=" + eId + ", efirstName=" + efirstName + ", elastName=" + elastName + ", eEmail=" + eEmail
				+ ", eSalary=" + eSalary + ", eDesignation=" + eDesignation + ", ereportTo=" + ereportTo
				+ ", ejoiningDate=" + ejoiningDate + "]";
	}
	
}
