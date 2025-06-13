package panda_food_employee_managemen.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import panda_food_employee_managemen.entities.Employee;

@Repository
public interface HRManagementRepository extends JpaRepository<Employee, Integer> {

	
	

}
