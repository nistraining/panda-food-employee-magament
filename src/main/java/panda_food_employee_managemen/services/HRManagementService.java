package panda_food_employee_managemen.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import panda_food_employee_managemen.entities.Employee;
import panda_food_employee_managemen.repository.HRManagementRepository;

@Service
public class HRManagementService {
	
	@Autowired
	private HRManagementRepository hrManagementRepo;
	
	public Employee addEmployee(Employee employee) {
		if (hrManagementRepo.findByEmail(employee.getEmail()) != null) {
			throw new IllegalArgumentException("Employee with this email already exists.");
		}
		return hrManagementRepo.save(employee);
	}
	
	public List<Employee> getAllEmployees(){
		return hrManagementRepo.findAll();
	}

}
