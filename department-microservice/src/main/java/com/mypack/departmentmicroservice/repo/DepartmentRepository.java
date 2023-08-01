package com.mypack.departmentmicroservice.repo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.mypack.departmentmicroservice.entity.Department;


@Repository
public class DepartmentRepository {
	
	private List<Department> departments = new ArrayList<>();
	
	public Department addDepartment(Department department)
	{
		departments.add(department);
		return department;
	}
	
    public Department findByDepartmentId(Long id)
    {
    	return departments.stream()
    			.filter(a -> a.getId() .equals(id))
    			.findFirst().orElseThrow();
    }
	
	public List<Department> findAllDepartment()
	{
		return departments;
	}
	
	public String deleteDepartment(Long id)
	{
		departments.removeIf(x -> x.getId().equals(id));
		return "Department with id :"+ id +" deleted Successfully";
	}


}
