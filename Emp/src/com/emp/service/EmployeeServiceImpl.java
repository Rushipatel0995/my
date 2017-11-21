package com.emp.service;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.emp.bean.EmployeeBean;
import com.emp.dao.EmployeeDAOImpl;
import com.emp.dao.IEmployeeDAO;
import com.emp.exception.EmployeeException;

public class EmployeeServiceImpl implements IEmployeeService {
	private IEmployeeDAO employeeDAO;
	@Override
	public boolean insertEmployee(EmployeeBean employeeBean)
			throws EmployeeException {
boolean isItInserted=false;
		
		IEmployeeDAO employeeDAO=new EmployeeDAOImpl();
		
		isItInserted=employeeDAO.insertEmployee(employeeBean);
		
		return isItInserted;
	}

	@Override
	public boolean deleteEmployee(int empId) throws EmployeeException {
		IEmployeeDAO employeeDAO=new EmployeeDAOImpl();
		boolean isDeleted=employeeDAO.deleteEmployee(empId);
		return isDeleted;
	}

	@Override
	public boolean updateEmployee(int empId, int salary)
			throws EmployeeException {
		IEmployeeDAO employeeDAO=new EmployeeDAOImpl();
		boolean isupdated=employeeDAO.updateEmployee(empId, salary);
		return isupdated;
	}

	@Override
	public List<EmployeeBean> viewAll() throws EmployeeException {
		List<EmployeeBean> employeeList = employeeDAO.viewAll();
		return employeeList;
	}

public boolean isValidName(String name) throws EmployeeException{
		
		boolean isValid=false;
		
		String pattern="[A-Z]{1}[a-z]{0,19}";
		
		Pattern ptn=Pattern.compile(pattern);
		
		Matcher matcher=ptn.matcher(name);
		isValid=matcher.matches();
		
		if(!isValid)
			throw new EmployeeException("Invalid Name");
		
		return isValid;
		
	}
	
	public boolean isValidSalary(int salary) throws EmployeeException{
		
		boolean isValid=false;
		
		if(salary>0)
			isValid=true;
		
		if(!isValid)
			throw new EmployeeException("Salary Must Be Positive");
		
		return isValid;
		
	}

}
