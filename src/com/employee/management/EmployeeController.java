package com.employee.management;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class EmployeeController {

		public static void main(String[] args) throws NumberFormatException, IOException {
		
		System.out.println("=======Welcome to Employee Management Appication=========");
		
		BufferedReader bufferReader = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			System.out.println("\n1. Insert data in the 'Employee' table");
			System.out.println("2. Delete data in the 'Employee' table ");
			System.out.println("3. List All the Employee with following details - id,name(firstName+lastName),email,designation.");
			System.out.println("4. List All the Employee with designation as Software engineer and QA engineer");
			System.out.println("5. List All the Employee with their reporting manager");
			System.out.println("6. List All the Employee whose name start with Alphabet 'A'");
			System.out.println("7. List Top 5 Employee with highest Salary");
			System.out.println("8. Find the employee with 2nd highest salary in the company");
			System.out.println("9. Find All the employee whose salary is less than employee with 2nd highest salary");
			System.out.println("10. List All the Employee with their department name");
			System.out.println("11. Get List of the employee who were working on Y city");
			System.out.println("12. Find Total Salary given to Employee in the company");
			System.out.println("13. Find Average Salary given to Employee in city Y");
			System.out.println("14. Find Total Salary given to the Employee department wise");
			System.out.println("15. Exit");
			System.out.println("\nEnter your choice:\t");
				
			int option = Integer.parseInt(bufferReader.readLine());
			
			if(option==1) {
				//1.Insert data in the Employee table
				System.out.println("Enter First name :");
				String fname = bufferReader.readLine();
				
				System.out.println("Enter last name :");
				String lname = bufferReader.readLine();
				
				System.out.println("Enter email :");
				String email = bufferReader.readLine();
				
				System.out.println("Enter Salary :");
				String salary = bufferReader.readLine();
				
				System.out.println("Enter Designation :");
				String designation = bufferReader.readLine();
				
				System.out.println("Enter Reporting To :");
				String reportTo = bufferReader.readLine();
				
				System.out.println("Enter Joining Date :");
				String date = bufferReader.readLine();
				
				EmployeeEntity employee = new EmployeeEntity(fname,lname,email, salary, designation, reportTo, date );
				
				EmployeeUtils employeeUtils = new EmployeeUtils();
				
				boolean insert = false;
				
				try {
					insert = employeeUtils.insertEmployeeToDatabase(employee);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				if(insert)
				{
					System.out.println("Employee Added Successfully!!");
				}
				else {
					System.out.println("Something went wrong. Try again!");
				}
				
				System.out.println(employee);
				
			
			}else if(option==2){
				//2. Delete data from Employee table
				System.out.println("Enter Employee ID to delete: ");
				int employeeId = Integer.parseInt(bufferReader.readLine());
				
				EmployeeUtils employeeUtils = new EmployeeUtils();
				
				boolean delete= false;
				
				delete= employeeUtils.deleteEmployee(employeeId);
				
				if(delete)
				{
					System.out.println("Employee Deleted Successfully!!");
				}
				else {
					System.out.println("Something went wrong. Try again!");
				}
			
			}else if(option==3) {
				//List All the Employee with following details - id,name(firstName+lastName),email,designation.
				EmployeeUtils employeeUtils = new EmployeeUtils();
				employeeUtils.showEmployeeDetails();
			
			}
			else if(option==4) {
				//List All the Employee with designation as Software engineer and QA engineer
				EmployeeUtils employeeUtils = new EmployeeUtils();
				employeeUtils.showEmployeeDesignation();
			}
			else if(option==5){
				//List All the Employee with their reporting manager
				EmployeeUtils employeeUtils = new EmployeeUtils();
				employeeUtils.showEmployeeReportTo();
			}
			else if(option==6){
				//List All the Employee whose name start with Alphabet 'A'
				EmployeeUtils employeeUtils = new EmployeeUtils();
				employeeUtils.showEmployeeName();
			}
			else if(option==7){
				//List Top 5 Employee with highest Salary
				EmployeeUtils employeeUtils = new EmployeeUtils();
				employeeUtils.showEmployeeHighSalary();
			}
			else if(option==8){
				//Find the employee with 2nd highest salary in the company
				EmployeeUtils employeeUtils = new EmployeeUtils();
				employeeUtils.showSecondHighSalary();
		    }
			else if(option==9){
				//Find All the employee whose salary is less than employee with 2nd highest salary
				EmployeeUtils employeeUtils = new EmployeeUtils();
				employeeUtils.showEmployeeLessSecondHighSalary();
		    }
			else if(option==10){
				// List All the Employee with their department name
				EmployeeUtils employeeUtils = new EmployeeUtils();
				employeeUtils.showEmployeeDepartment();
		    }
			else if(option==11){
				//Get List of the employee who were working on Y city
				EmployeeUtils employeeUtils = new EmployeeUtils();
				employeeUtils.showEmployeeCity();
		    }
			else if(option==12){
				//Find Total Salary given to Employee in the company
				EmployeeUtils employeeUtils = new EmployeeUtils();
				employeeUtils.showEmployeeTotalSalary();
		    }
			else if(option==13){
				//Find Average Salary given to Employee in city Y
				EmployeeUtils employeeUtils = new EmployeeUtils();
				employeeUtils.showEmployeeAverageSalary();
		    }
			else if(option==14){
				// Find Total Salary given to the Employee department wise
				EmployeeUtils employeeUtils = new EmployeeUtils();
				employeeUtils.showEmployeeDepartmentSalary();
		    }
			else if(option==15){
				//Exit
				break;
			}
			else {
				System.out.println("Invalid Choice. Enter Again...");
	   }
     }System.out.println("Thank you for using my application....");	
   }
}
