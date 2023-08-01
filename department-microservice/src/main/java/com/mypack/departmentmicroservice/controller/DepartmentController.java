package com.mypack.departmentmicroservice.controller;

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

import com.mypack.departmentmicroservice.client.EmployeeClient;
import com.mypack.departmentmicroservice.entity.Department;
import com.mypack.departmentmicroservice.repo.DepartmentRepository;

@RestController
@RequestMapping("/departments")
public class DepartmentController {
	
	
	private static final Logger LOGGER = LoggerFactory.getLogger(DepartmentController.class);
	
	@Autowired
	private DepartmentRepository departmentRepository;
	
	@Autowired
	private EmployeeClient employeeClient;
	
	
	@PostMapping
	public Department add(@RequestBody Department department)
	{
		LOGGER.info("Department add: {}", department);
		return departmentRepository.addDepartment(department);
	}
	
	@GetMapping
	public List<Department> getAllDepartment()
	{
		LOGGER.info("Department find");
		return departmentRepository.findAllDepartment();
	}
	
	@GetMapping("/{id}")
	public Department getDepartmentById(@PathVariable  Long id)
	{
		LOGGER.info("Department find: id={}", id);
		return departmentRepository.findByDepartmentId(id);
	}
	
	@DeleteMapping("/{id}")
	public String deleteDepartment(@PathVariable  Long id)
	{
		LOGGER.info("Department delete: id={}", id);
		return departmentRepository.deleteDepartment(id);
	}
	
	@GetMapping("/with-employees")
	public List<Department> findAllWithEmployees()
	{
		LOGGER.info("Department FindAllWithEmployees");
		
		List<Department> departments = departmentRepository.findAllDepartment();
		 departments.forEach(department -> department.setEmployees(employeeClient.findByDepartment(department.getId())));
		return departments;
	}
	
	
	
	

}
