package com.emp.service;

import java.util.List;

import com.emp.bean.EmployeeBean;
import com.emp.exception.EmployeeException;

public interface IEmployeeService {
	public boolean insertEmployee(final EmployeeBean employeeBean) 
			throws EmployeeException;

	public boolean deleteEmployee(final int empId)
			throws EmployeeException;
	
	public boolean updateEmployee(final int empId,final int salary)
			throws EmployeeException;
	
	public List<EmployeeBean> viewAll()
			throws EmployeeException;
}
