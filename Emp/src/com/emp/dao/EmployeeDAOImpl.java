package com.emp.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.emp.bean.EmployeeBean;
import com.emp.exception.EmployeeException;
import com.emp.util.DBConnection;

public class EmployeeDAOImpl implements IEmployeeDAO {

	@Override
	public boolean insertEmployee(EmployeeBean employeeBean)
			throws EmployeeException {

		int records=0;
		boolean isInserted=false;
		try(Connection connPurchaseDetails = DBConnection.getInstance().getConnection();	
	
	PreparedStatement preparedStatement=
		connPurchaseDetails.prepareStatement(QueryMapper.INSERT_EMPLOYEE);)
		{
			//java.sql.Date purchaseDate=new Date(new java.util.Date().getTime());
			
			/*String str = purchaseDetailsBean.getHiredate();
			 * 
			 * TemporalAccessor ta = dtf.parse(str);
			
			LocalDate localDate = LocalDate.from(ta);
			
			java.sql.Date translatedDate = java.sql.Date.valueOf(localDate);*/
			
			
			preparedStatement.setString(1, employeeBean.getEname());
			preparedStatement.setInt(2, employeeBean.getSalary());
			preparedStatement.setInt(3, employeeBean.getDept());
			
			preparedStatement.setString(4, employeeBean.getDesignation());
			
			records=preparedStatement.executeUpdate();
			
			if(records>0){
				isInserted=true;
			}
			
		} catch(SQLException sqlEx){
			throw new EmployeeException(sqlEx.getMessage());
		}
	return isInserted;
	}

	@Override
	public boolean deleteEmployee(int empId) throws EmployeeException {
		int records=0;
		boolean isDeleted=false;
		try(Connection connPurchaseDetails = DBConnection.getInstance().getConnection();	
	
	PreparedStatement preparedStatement=
		connPurchaseDetails.prepareStatement(QueryMapper.DELETE_EMPLOYEE);)
		{
			
			
			preparedStatement.setInt(1, empId);
			
			records=preparedStatement.executeUpdate();
			
			if(records>0){
				isDeleted=true;
			}
			
		} catch(SQLException sqlEx){
			throw new EmployeeException(sqlEx.getMessage());
		}
	return isDeleted;
		
	}

	

	@Override
	public boolean updateEmployee(int empId, int salary)
			throws EmployeeException {
		int records=0;
		boolean isUpdated=false;
		try(Connection connMobile = DBConnection.getInstance().getConnection();	
	
	PreparedStatement preparedStatement=
		connMobile.prepareStatement(QueryMapper.UPDATE_EMPLOYEE);)
		{
			
			
			preparedStatement.setString(1,Integer.toString(salary));
			
			preparedStatement.setInt(2, empId);
			
			records=preparedStatement.executeUpdate();
			
			if(records>0){
				isUpdated=true;
			}
			
		} catch(SQLException sqlEx){
			throw new EmployeeException(sqlEx.getMessage());
		}
	return isUpdated;
	}

	@Override
	public List<EmployeeBean> viewAll() throws EmployeeException {
		List<EmployeeBean>employeeList=new ArrayList<EmployeeBean>();
		try(Connection connMobile = DBConnection.getInstance().getConnection();	
	
	PreparedStatement preparedStatement=
		connMobile.prepareStatement(QueryMapper.VIEW_EMPLOYEES);
		ResultSet rsMobiles=preparedStatement.executeQuery();
				)
		{
			
		
			
			while(rsMobiles.next()){
				EmployeeBean employee=new EmployeeBean();
				
				employee.setEmpid(rsMobiles.getInt("(employeeid"));
				employee.setEname(rsMobiles.getString("employeename"));
				employee.setSalary(rsMobiles.getInt("salary"));
				employee.setDept(rsMobiles.getInt("departmentname"));
				employee.setDesignation(rsMobiles.getString("designation"));
				
				employeeList.add(employee);
			}
			
			if(employeeList.size()==0){
				throw new EmployeeException("No records Found");
			}
			
		} catch(SQLException sqlEx){
			throw new EmployeeException(sqlEx.getMessage());
		}
	return employeeList;
	}

}
