package com.mindtree.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindtree.dto.EmployeeDTO;
import com.mindtree.exception.ORMException;
import com.mindtree.repository.EmployeeRepository;
import com.mindtree.validator.Validator;
@Service("employeeService")
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	EmployeeRepository employeeRepository;

	public Integer addEmployee(EmployeeDTO employee) throws ORMException {
			new Validator().validate(employee);
			if(employeeRepository.getEmployeeDetails(employee.getEmployeeId())!=null)
			{
				throw new ORMException("Service.EMPLOYEE_ALREADY_PRESENT");
			}
			Integer id=employeeRepository.addEmployee(employee);
		return id;
	}

	public EmployeeDTO getEmployeeDetails(Integer employeeId) throws ORMException {
		EmployeeDTO data=employeeRepository.getEmployeeDetails(employeeId);
		if(data==null)
		{
			throw new ORMException("Service.EMPLOYEE_NOT_FOUND");
		}
	return data;
	}

	public void updateEmployee(Integer employeeId, String email) throws ORMException {
		if(employeeRepository.getEmployeeDetails(employeeId)==null)
		{
			throw new ORMException("Service.EMPLOYEE_NOT_FOUND");
		}
		employeeRepository.updateEmployee(employeeId,email);
	}

	public void deleteEmployee(Integer employeeId) throws ORMException {
		if(employeeRepository.getEmployeeDetails(employeeId)==null)
		{
			throw new ORMException("Service.EMPLOYEE_NOT_FOUND");
		}
		employeeRepository.deleteEmployee(employeeId);
	}
	

}
