package com.mindtree.service;

import com.mindtree.dto.EmployeeDTO;
import com.mindtree.exception.ORMException;

public interface EmployeeService {
	public Integer addEmployee(EmployeeDTO employee) throws ORMException;
	public EmployeeDTO getEmployeeDetails(Integer employeeId) throws ORMException;
	public void updateEmployee(Integer employeeId,String email) throws ORMException;
	public void deleteEmployee(Integer employeeId) throws ORMException;
}
