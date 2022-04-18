package com.mindtree.repository;

import javax.persistence.EntityManager;

import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mindtree.dto.EmployeeDTO;
import com.mindtree.entity.Employee;

@Repository("employeeRepository")

@Transactional
public class EmployeeRepositoryImpl implements EmployeeRepository {

	@PersistenceContext
	private EntityManager entityManager;

	public Integer addEmployee(EmployeeDTO employee) {

		Employee emp = new Employee();
		emp.setName(employee.getName());
		emp.setEmailId(employee.getEmailId());
		emp.setEmployeeId(employee.getEmployeeId());
		emp.setDateOfBirth(employee.getDateOfBirth());
		emp.setManufacturingUnit(employee.getManufacturingUnit());
		entityManager.persist(emp);

		return employee.getEmployeeId();
	}

	public EmployeeDTO getEmployeeDetails(Integer employeeId) {

		EmployeeDTO temp = null;
		Employee data = entityManager.find(Employee.class, employeeId);
		if (data != null) {
			temp = new EmployeeDTO();
			temp.setDateOfBirth(data.getDateOfBirth());
			temp.setEmailId(data.getEmailId());
			temp.setEmployeeId(data.getEmployeeId());
			temp.setManufacturingUnit(data.getManufacturingUnit());
			temp.setName(data.getName());
		}

		return temp;
	}

	public void updateEmployee(Integer employeeId, String email) {

		Employee data = entityManager.find(Employee.class, employeeId);
		if (data != null) {
			data.setEmailId(email);
		}

	}

	public void deleteEmployee(Integer employeeId) {

		Employee data = entityManager.find(Employee.class, employeeId);
		entityManager.remove(data);

	}

}
