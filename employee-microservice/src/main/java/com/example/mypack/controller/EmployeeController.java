package com.example.mypack.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.mypack.entity.Employee;
import com.example.mypack.repo.EmployeeRepository;



@RestController
@RequestMapping("employees")
public class EmployeeController {

private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeController.class);
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	
	@PostMapping
	public Employee add(@RequestBody Employee employee)
	{
		LOGGER.info("Employee add: {}", employee);
		return employeeRepository.addEmployee(employee);
	}
	
	@GetMapping
	public List<Employee> getAllEmployee()
	{
		LOGGER.info("Employee find");
		return employeeRepository.findAllEmployee();
	}
	
	@GetMapping("/{id}")
	public Employee getEmployeeById(@PathVariable  Long id)
	{
		LOGGER.info("Employee find: id={}", id);
		return employeeRepository.findByEmployeeId(id);
	}
	
	@GetMapping("/department/{departmentId}")
	public  List <Employee> findByDepartment(@PathVariable ("departmentId") Long departmentId)
	{
		LOGGER.info("Employee find: departmentId={}", departmentId);
		return employeeRepository.findByDepartment(departmentId); 
	}

	@DeleteMapping("/{id}")
	public String deleteEmployee(@PathVariable  Long id)
	{
		LOGGER.info("Employee delete: id={}", id);
		return employeeRepository.deleteEmployee(id);
	}
	
	
	
}
