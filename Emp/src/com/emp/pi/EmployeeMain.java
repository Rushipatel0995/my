package com.emp.pi;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.emp.bean.EmployeeBean;
import com.emp.exception.EmployeeException;
import com.emp.service.EmployeeServiceImpl;

public class EmployeeMain {
	private static Logger logger=Logger.getRootLogger();

	public static void main(String[] args) {
		PropertyConfigurator.configure("resources/log4j.properties");
		
		boolean isInProcess=true;
		boolean isValid=false;
		
		byte choice=0;
		
		String ename=null;
		int salary=0;
		int dept=0;
		String designation=null;
		
		
Scanner sc=new Scanner(System.in);
		
		EmployeeServiceImpl serviceEmployee=new EmployeeServiceImpl();
		
		EmployeeBean employeeBean=null;
		
		while(isInProcess){
			System.out.println("1) Insert Employee");
			System.out.println("2) Delete Employee");
			System.out.println("3) Update Salary");
			System.out.println("4) View All");
			System.out.println("0) Exit");
			
			choice=Byte.parseByte(sc.nextLine());
			
			switch(choice){
			case 1:
				while(!isValid)
				{
					try{
						System.out.println("Enter Employee name: ");
						ename=sc.nextLine();
						
						isValid=serviceEmployee.isValidName(ename);
						
					}catch(EmployeeException mpe){
						
						logger.error("Invalid name: "+ename);
						System.err.println("Invalid name: "+ename);
						isValid=false;
					}
				}
				isValid=false;
				while(!isValid)
				{
					try{
						System.out.println("Enter salary: ");
						salary=Integer.parseInt(sc.nextLine());
						
						isValid=serviceEmployee.isValidSalary(salary);
						
					}catch(EmployeeException mpe){
						
						logger.error("Invalid salary: "+salary);
						System.err.println("Invalid salary: "+salary);
						isValid=false;
					}
				}
				isValid=false;
				
				System.out.println("Enter Department Name: ");
				dept=sc.nextInt();
				
				System.out.println("Enter Designation: ");
				designation=sc.nextLine();
				
				employeeBean=new EmployeeBean(ename,salary,dept,designation);
				try{
					boolean isInserted=serviceEmployee.insertEmployee(employeeBean);
					
					if(isInserted)
						System.out.println("Inserted Successfully!");
					
				}catch(EmployeeException e){
					logger.error(e.getMessage());
				}
			break;
			
			case 2:
				System.out.println("Enter Employee Id: ");
				int empId=Integer.parseInt(sc.nextLine());
				
				try{
					boolean isDeleted=serviceEmployee.deleteEmployee(empId);
					
					if(isDeleted)
						System.out.println("Deleted successfully!");
					
				}catch(EmployeeException e){
					logger.error(e.getMessage());
				}
				
				
			break;
			
			case 3:
				System.out.println("Enter Employee Id: ");
				int empId1=Integer.parseInt(sc.nextLine());
				
				isValid=false;
				int newSalary=0;
				while(!isValid)
				{
					try{
						System.out.println("Enter salary: ");
						newSalary=Integer.parseInt(sc.nextLine());
						
						isValid=serviceEmployee.isValidSalary(newSalary);
						
					}catch(EmployeeException mpe){
						
						logger.error("Invalid salary: "+newSalary);
						System.err.println("Invalid salary: "+newSalary);
						isValid=false;
					}
				}
				
				try{
					boolean isUpdated=serviceEmployee.updateEmployee(empId1, newSalary);
					
					if(isUpdated)
						System.out.println("Salary Updated!");
					
				}catch(EmployeeException e){
					logger.error(e.getMessage());
				}
				
				break;
				
			
			
			case 4:
				serviceEmployee = new EmployeeServiceImpl();
				try {
					List<EmployeeBean> mobileList = new ArrayList<EmployeeBean>();
					mobileList = serviceEmployee.viewAll();

					if (mobileList != null) {
						Iterator<EmployeeBean> i = mobileList.iterator();
						while (i.hasNext()) {
							System.out.println(i.next());
						}
					} else {
						System.out
								.println("Nobody has made a donation, yet.");
					}

				}

				catch (EmployeeException e) {

					System.out.println("Error  :" + e.getMessage());
				}

				
			break;
			
			case 0:
				isInProcess=false;
				break;
				
			
			
			default:
				System.out.println("Invalid input");
				logger.error("Invalid input: "+choice);
				System.err.println("Invalid input: "+choice);
				
				
			break;
			
			
			}
			
			
			
		}
		
		sc.close();
	}

}
