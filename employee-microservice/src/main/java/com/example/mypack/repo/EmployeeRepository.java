package com.example.mypack.repo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.mypack.entity.Employee;


@Repository
public class EmployeeRepository 
{
private List<Employee> employees = new ArrayList<>();
	
	public Employee addEmployee(Employee Employee)
	{
		employees.add(Employee);
		return Employee;
	}
	
    public Employee findByEmployeeId(Long id)
    {
    	return employees.stream()
    			.filter(a -> a.id(). equals(id))
    			.findFirst().orElseThrow();
    }
	
	public List<Employee> findAllEmployee()
	{
		return employees;
	}
	
	public String deleteEmployee(Long id)
	{
		employees.removeIf(x -> x.id().equals(id));
	
		return "Employee with id:"+ id +"deleted Successfully";
	}
	
	public List<Employee> findByDepartment(long departmentId)
	{
		return employees.stream().filter(e -> e.depId().equals(departmentId)).toList();
	}



}
