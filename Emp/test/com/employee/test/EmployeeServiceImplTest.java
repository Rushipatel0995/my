package com.employee.test;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.emp.bean.EmployeeBean;
import com.emp.exception.EmployeeException;
import com.emp.service.EmployeeServiceImpl;
import com.emp.service.IEmployeeService;

public class EmployeeServiceImplTest {

	private EmployeeBean EmployeeBean;
	@Before
	public void setUp() throws Exception {
		EmployeeBean =new EmployeeBean("abc",1213123,1,"manager");
	}

	@After
	public void tearDown() throws Exception {
		EmployeeBean=null;
	}

	@Test
	public final void testInsertEmployee() {
		IEmployeeService employeeService = new EmployeeServiceImpl();
		try{
		assertTrue(employeeService.insertEmployee(EmployeeBean));
		
	}catch(EmployeeException e){
		e.printStackTrace();
	}

}
	

	@Test
	public final void testDeleteEmployee() {
		IEmployeeService employeeService = new EmployeeServiceImpl();
		try{
		assertTrue(employeeService.deleteEmployee(1001));
		
	}catch(EmployeeException e){
		e.printStackTrace();
	}
	}

	@Test
	public final void testUpdateEmployee() {
		fail("Not yet implemented");
	}

	@Test
	public final void testViewAll() {
		fail("Not yet implemented");
	}

}
