package com.mypack.departmentmicroservice.client;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;

import com.mypack.departmentmicroservice.entity.Employee;


@HttpExchange
public interface EmployeeClient {
	
	@GetExchange("/employees/department/{departmentId}")
	public  List <Employee> findByDepartment(@PathVariable ("departmentId") Long departmentId);
	

}
