package panda_food_employee_managemen.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.awspring.cloud.sqs.operations.SqsTemplate;
import panda_food_employee_managemen.entities.Employee;
import panda_food_employee_managemen.services.HRManagementService;

@RestController
@RequestMapping("/employees")
public class HRmanagementController {
	
	@Value("${cloud.aws.sqs.endpoint}")
	private String sqsEndpoint;
	
	@Autowired
	private SqsTemplate sqsTemplate;
	
	@Autowired
	private HRManagementService hrManagementService;
	
	@GetMapping("/test")
	public ResponseEntity<String> getHome(){
		return new ResponseEntity<String>("Hello",HttpStatus.ACCEPTED);
	}
	
	@PostMapping("/addEmployee")
	public ResponseEntity<Employee> addNewEmployees(@RequestBody Employee employee){
		
		employee = hrManagementService.addEmployee(employee);
		//sending the payload to the AWS SQS
		sqsTemplate.send(sqsEndpoint,MessageBuilder.withPayload(employee).build());
		return new ResponseEntity<Employee>(employee,HttpStatus.CREATED);
	}
	
	
	@GetMapping("/findAllemployees")
	public ResponseEntity<List<Employee>> getAllEmployee(){
		List<Employee> employees = hrManagementService.getAllEmployees();
		return new ResponseEntity<>(employees,HttpStatus.ACCEPTED);
	}
	
	
	
	
	

}
