package com.mindtree.ui;

import java.time.LocalDate;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.core.env.Environment;

import com.mindtree.dto.EmployeeDTO;
import com.mindtree.model.ManufacturingUnit;
import com.mindtree.service.*;
import com.mindtree.config.ORMConfig;

public class UserInterface {
	static Environment environment;
	static AbstractApplicationContext aac;
	static Logger LOGGER = Logger.getLogger(UserInterface.class);
	static EmployeeService employeeService;

	public static void main(String[] args) {
		aac = new AnnotationConfigApplicationContext(ORMConfig.class);
		environment = aac.getEnvironment();
		employeeService = aac.getBean(EmployeeService.class);
		addEmployee();
		getEmployeeDetails();
		updateEmployee();
		deleteEmployee();
	}

	public static void addEmployee() {
		try {

			EmployeeDTO employeeDTO = new EmployeeDTO();
			employeeDTO.setEmployeeId(2007);
			employeeDTO.setName("Wilson");
			employeeDTO.setEmailId("wilson@mail.com");
			employeeDTO.setDateOfBirth(LocalDate.of(1996, 4, 10));
			employeeDTO.setManufacturingUnit(ManufacturingUnit.U001);

			Integer employeeId = employeeService.addEmployee(employeeDTO);

			LOGGER.info("\n" + environment.getProperty("UserInterface.INSERT_SUCCESS") + employeeId);

		} catch (Exception e) {

			LOGGER.info(
					"\n Some Exception Occurs check log file for details" +e.getMessage());

		}
	}

	public static void getEmployeeDetails() {
		try {

			EmployeeDTO employeeDTO = employeeService.getEmployeeDetails(2001);
			LOGGER.info("\n" + employeeDTO);

		} catch (Exception e) {
			LOGGER.info(
					"\n Some Exception Occurs check log file for details"+e);

		}
	}

	public static void updateEmployee() {
		try {

			Integer employeeId = 2005;
			String emailId = "husee01@mail.com";

			employeeService.updateEmployee(employeeId, emailId);

			LOGGER.info("\n" + environment.getProperty("UserInterface.UPDATE_SUCCESS"));

		} catch (Exception e) {
			LOGGER.info(
					"\n Some Exception Occurs check log file for details");

		}
	}

	public static void deleteEmployee() {
		try {

			employeeService.deleteEmployee(2007);

			LOGGER.info("\n" + environment.getProperty("UserInterface.DELETE_SUCCESS"));
		} catch (Exception e) {
			LOGGER.info(
					"\n Some Exception Occurs check log file for details");

		}
	}

}
