package com.mindtree.repository;

import com.mindtree.dto.EmployeeDTO;

public interface EmployeeRepository {
	public Integer addEmployee(EmployeeDTO employee);
	public EmployeeDTO getEmployeeDetails(Integer employeeId);
	public void updateEmployee(Integer employeeId,String email);
	public void deleteEmployee(Integer employeeId);
}
