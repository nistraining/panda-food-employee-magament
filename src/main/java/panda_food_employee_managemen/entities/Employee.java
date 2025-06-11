package panda_food_employee_managemen.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "pandafoods_employee")
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int employeeId;
	private String empFirstName;
	private String empLastName;
	private String empDesignation;
	private String doj;
	private String location;
	
	
	public Employee() {
		
	}


	public Employee(int employeeId, String empFirstName, String empLastName, String empDesignation, String doj,
			String location) {
		super();
		this.employeeId = employeeId;
		this.empFirstName = empFirstName;
		this.empLastName = empLastName;
		this.empDesignation = empDesignation;
		this.doj = doj;
		this.location = location;
	}


	public int getEmployeeId() {
		return employeeId;
	}


	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}


	public String getEmpFirstName() {
		return empFirstName;
	}


	public void setEmpFirstName(String empFirstName) {
		this.empFirstName = empFirstName;
	}


	public String getEmpLastName() {
		return empLastName;
	}


	public void setEmpLastName(String empLastName) {
		this.empLastName = empLastName;
	}


	public String getEmpDesignation() {
		return empDesignation;
	}


	public void setEmpDesignation(String empDesignation) {
		this.empDesignation = empDesignation;
	}


	public String getDoj() {
		return doj;
	}


	public void setDoj(String doj) {
		this.doj = doj;
	}


	public String getLocation() {
		return location;
	}


	public void setLocation(String location) {
		this.location = location;
	}


	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", empFirstName=" + empFirstName + ", empLastName=" + empLastName
				+ ", empDesignation=" + empDesignation + ", doj=" + doj + ", location=" + location + "]";
	}
	
	
	
	

}
