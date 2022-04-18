package com.mindtree.validator;

import com.mindtree.dto.EmployeeDTO;
import com.mindtree.exception.ORMException;

public class Validator {

	public void validate(EmployeeDTO employee) throws ORMException
	{
		if(!validateEmail(employee.getEmailId()))
		{
			throw new ORMException("Validator.INVALID_EMAIL_ID");
		}
	}
	public boolean validateEmail(String emailId)
	{
		return emailId.matches("^[a-zA-z]([a-z]|[0-9])+[@][a-z]+[.][a-z]+");
	}
}
