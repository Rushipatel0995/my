package com.emp.dao;

public class QueryMapper {
	public static final String INSERT_EMPLOYEE=
			"INSERT INTO emp2 VALUES(emp_sequence1.nextVal,?,?,?,?)";

	public static final String DELETE_EMPLOYEE=
			"DELETE FROM emp2 WHERE employeeid=?";
	
	public static final String UPDATE_EMPLOYEE=
			"UPDATE emp2 SET salary=? WHERE employeeid=?";
	
	public static final String VIEW_EMPLOYEES =
			"SELECT employeeid,employeename,salary FROM emp2";

}
