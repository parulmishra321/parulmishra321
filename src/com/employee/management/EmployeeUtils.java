package com.employee.management;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class EmployeeUtils {
	
	//Insert into Employee table
	public boolean insertEmployeeToDatabase(EmployeeEntity employee) {
		
		boolean f=false;
		try {
			//jdbc code
			Connection connection = JDBCConnection.createConnection();
			String query = "INSERT INTO employee(firstName,lastName,email,salary,designation,reportTo,joiningDate) values(?,?,?,?,?,?,?)";
			
			//PreparedStatement
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			//set the values of parameter
			preparedStatement.setString(1, employee.getefirstName());
			preparedStatement.setString(2, employee.getelastName());
			preparedStatement.setString(3, employee.geteEmail());
			preparedStatement.setString(4, employee.geteSalary());
			preparedStatement.setString(5, employee.geteDesignation());
			preparedStatement.setString(6, employee.getereportTo());
			preparedStatement.setString(7, employee.getejoiningDate());
			
			//execute
			preparedStatement.executeUpdate();
			f= true;
		}	
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return f;
	}
	
	//Delete from Employee table
	public boolean deleteEmployee(int employeeId) {
		
		boolean f=false;
		try {
			//jdbc code
			Connection connection = JDBCConnection.createConnection();
			String query = "DELETE FROM employee WHERE eid=?";
			
			//PreparedStatement
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			//set the values of parameter
			preparedStatement.setInt(1, employeeId);
			
			//execute
			preparedStatement.executeUpdate();
			f= true;
		}	
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return f;
	}
	
	//1.List All the Employee with following details - id,name(firstName+lastName),email,designation.
	public void showEmployeeDetails() {
		try {
			//jdbc code
			Connection connection = JDBCConnection.createConnection();
			String query = "select eid, CONCAT(firstName,' ',lastName) AS name, email, designation FROM employee;";
			Statement statement = connection.createStatement();
			ResultSet ResultSet = statement.executeQuery(query);
			
			while(ResultSet.next()) {
				int id=ResultSet.getInt("eid");
				String name =  ResultSet.getString("name");
				String email =  ResultSet.getString("email");
				String designation =  ResultSet.getString("designation");
				
				System.out.println("\n==================================");
				System.out.println("ID : "+id);
				System.out.println("Name: "+name);
				System.out.println("Email : "+email);
				System.out.println("Designation : "+designation);
				System.out.println("==================================");		
			}
		}	
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	//2.List All the Employee with designation as Software engineer and QA engineer
	public void showEmployeeDesignation() {
		try {
			//jdbc code
			Connection con = JDBCConnection.createConnection();
			String query = "select eid,CONCAT(firstName,' ',lastName) AS name, email, designation FROM employee WHERE designation= 'Software Engineer' OR designation= 'QA Engineer';";
			Statement statement = con.createStatement();
			ResultSet ResultSet = statement.executeQuery(query);
			
			while(ResultSet.next()) {
				int id=	 ResultSet.getInt("eid");
				String name =  ResultSet.getString("name");
				String email =  ResultSet.getString("email");
				String designation =  ResultSet.getString("designation");
				
				System.out.println("\n==================================");
				System.out.println("ID : "+id);
				System.out.println("Name: "+name);
				System.out.println("Email : "+email);
				System.out.println("Designation : "+designation);
				System.out.println("==================================");		
			}
		}	
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	//3.List All the Employee with their reporting manager
	public void showEmployeeReportTo() {
		try {
			//jdbc code
			Connection con = JDBCConnection.createConnection();
			String query = "select eid, CONCAT(firstName,' ',lastName) AS name, reportTo, email, designation FROM employee;";
			Statement statement = con.createStatement();
			ResultSet ResultSet = statement.executeQuery(query);
			
			while(ResultSet.next()) {
				int id=	 ResultSet.getInt("eid");
				String name =  ResultSet.getString("name");
				String email =  ResultSet.getString("email");
				String designation =  ResultSet.getString("designation");
				String reportTo = ResultSet.getString("reportTo");
				
				System.out.println("==================================");
				System.out.println("ID : "+id);
				System.out.println("Name: "+name);
				System.out.println("Reports To : "+reportTo);
				System.out.println("Email : "+email);
				System.out.println("Designation : "+designation);
				System.out.println("==================================");		
			}
		}	
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	//4.List All the Employee whose name start with Alphabet 'A'
	public void showEmployeeName() {
		try {
			//jdbc code
			Connection con = JDBCConnection.createConnection();
			String query = "select eid, CONCAT(firstName,' ',lastName) AS name, reportTo, email, designation FROM employee WHERE firstName LIKE 'A%';";
			Statement statement = con.createStatement();
			ResultSet ResultSet = statement.executeQuery(query);
			
			while(ResultSet.next()) {
				int id=	 ResultSet.getInt("eid");
				String name =  ResultSet.getString("name");
				String email =  ResultSet.getString("email");
				String designation =  ResultSet.getString("designation");
				
				System.out.println("==================================");
				System.out.println("ID : "+id);
				System.out.println("Name: "+name);
				System.out.println("Email : "+email);
				System.out.println("Designation : "+designation);
				System.out.println("==================================");		
			}
		}	
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	//5. List Top 5 Employee with highest Salary
	public void showEmployeeHighSalary() {
		try {
			//jdbc code
			Connection con = JDBCConnection.createConnection();
			String query = "SELECT DISTINCT salary, eid, CONCAT(firstName,' ',lastName) AS name, designation FROM employee a WHERE 5 >= (SELECT COUNT(DISTINCT salary) FROM employee b WHERE b.salary >= a.salary) ORDER BY a.salary DESC;";
			Statement statement = con.createStatement();
			ResultSet ResultSet = statement.executeQuery(query);
			
			while(ResultSet.next()) {
				int id=	 ResultSet.getInt("eid");
				String name =  ResultSet.getString("name");
				String designation =  ResultSet.getString("designation");
				String salary = ResultSet.getString("salary");
				
				System.out.println("==================================");
				System.out.println("ID : "+id);
				System.out.println("Name: "+name);
				System.out.println("Designation : "+designation);
				System.out.println("Salary : "+salary);
				System.out.println("==================================");		
			}
		}	
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	//6.Find the employee with 2nd highest salary in the company
	public void showSecondHighSalary() {
		try {
			//jdbc code
			Connection con = JDBCConnection.createConnection();
			String query = "SELECT DISTINCT salary, eid, CONCAT(firstName,' ',lastName) AS name, designation FROM employee ORDER BY salary DESC LIMIT 1 OFFSET 1;";
			Statement statement = con.createStatement();
			ResultSet ResultSet = statement.executeQuery(query);
			
			while(ResultSet.next()) {
				int id=	 ResultSet.getInt("eid");
				String name =  ResultSet.getString("name");
				String designation =  ResultSet.getString("designation");
				String salary = ResultSet.getString("salary");
				
				System.out.println("==================================");
				System.out.println("ID : "+id);
				System.out.println("Name: "+name);
				System.out.println("Designation : "+designation);
				System.out.println("Salary : "+salary);
				System.out.println("==================================");		
			}
		}	
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	//7.Find All the employee whose salary is less than employee with 2nd highest salary
	public void showEmployeeLessSecondHighSalary() {
		try {
			//jdbc code
			Connection con = JDBCConnection.createConnection();
			String query = "SELECT eid, CONCAT(firstName,' ',lastName) AS name, designation, salary FROM employee GROUP BY salary ORDER BY salary DESC LIMIT 2,5;";
			Statement statement = con.createStatement();
			ResultSet ResultSet = statement.executeQuery(query);
			
			while(ResultSet.next()) {
				int id=	 ResultSet.getInt("eid");
				String name =  ResultSet.getString("name");
				String designation =  ResultSet.getString("designation");
				String salary = ResultSet.getString("salary");
				
				System.out.println("==================================");
				System.out.println("ID : "+id);
				System.out.println("Name: "+name);
				System.out.println("Designation : "+designation);
				System.out.println("Salary : "+salary);
				System.out.println("==================================");		
			}
		}	
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	//8.List All the Employee with their department name
	public void showEmployeeDepartment() {
		try {
			//jdbc code
			Connection con = JDBCConnection.createConnection();
			String query = "select CONCAT(firstName,' ',lastName) AS name, designation, dname from employee_manage.employee join employee_manage.department where employee.eid=department.eid;";
			Statement statement = con.createStatement();
			ResultSet ResultSet = statement.executeQuery(query);
			
			while(ResultSet.next()) {				
				String name =  ResultSet.getString("name");
				String designation =  ResultSet.getString("designation");
				String dname = ResultSet.getString("dname");
				
				System.out.println("==================================");
				System.out.println("Name: "+name);
				System.out.println("Designation : "+designation);
				System.out.println("Salary : "+dname);
				System.out.println("==================================");		
			}
		}	
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	//9.Get List of the employee who were working on GURGAON city
	public void showEmployeeCity() {
		try {
			//jdbc code
			Connection con = JDBCConnection.createConnection();
			String query = "SELECT DISTINCT CONCAT(firstName,' ',lastName) AS name, dcity, designation FROM employee_manage.employee JOIN employee_manage.department ON employee.eid=department.eid AND dcity ='Gurgaon';";
			Statement statement = con.createStatement();
			ResultSet ResultSet = statement.executeQuery(query);
			
			while(ResultSet.next()) {
				String name =  ResultSet.getString("name");
				String designation =  ResultSet.getString("designation");
				String city = ResultSet.getString("dcity");
				
				System.out.println("==================================");
				System.out.println("Name: "+name);
				System.out.println("Designation : "+designation);
				System.out.println("City : "+city);
				System.out.println("==================================");		
			}
		}	
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	//10.Find Total Salary given to Employee in the company
	public void showEmployeeTotalSalary() {
		try {
			//jdbc code
			Connection con = JDBCConnection.createConnection();
			String query = "SELECT sum(salary) AS totalSalary FROM employee;";
			Statement statement = con.createStatement();
			ResultSet ResultSet = statement.executeQuery(query);
			
			while(ResultSet.next()) {
				String totalSalary = ResultSet.getString("totalSalary");
				
				System.out.println("==================================");
				System.out.println("Total Salary : "+totalSalary);
				System.out.println("==================================");		
			}
		}	
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	
	//11.Find Average Salary given to Employee in GURGAON city 
	public void showEmployeeAverageSalary() {
		try {
			//jdbc code
			Connection con = JDBCConnection.createConnection();
			String query = "SELECT AVG(salary) AS averageSalary, dcity FROM employee_manage.employee join employee_manage.department on employee.eid=department.eid and dcity ='gurgaon';";
			Statement statement = con.createStatement();
			ResultSet ResultSet = statement.executeQuery(query);
			
			while(ResultSet.next()) {
				String city= ResultSet.getString("dcity");
				String averageSalary = ResultSet.getString("averageSalary");
				
				System.out.println("==================================");
				System.out.println("City : "+city);
				System.out.println("Average Salary : "+averageSalary);
				System.out.println("==================================");		
			}
		}	
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	
	//12.Find Total Salary given to the Employee department wise
	public void showEmployeeDepartmentSalary() {
		try {
			//jdbc code
			Connection con = JDBCConnection.createConnection();
			String query = "SELECT dname, sum(salary) AS totalSalary FROM employee e JOIN department d WHERE e.eid- d.eid GROUP BY dname;";
			Statement statement = con.createStatement();
			ResultSet ResultSet = statement.executeQuery(query);
			
			while(ResultSet.next()) {
				String dname =  ResultSet.getString("dname");
				String totalSalary = ResultSet.getString("totalSalary");
				
				System.out.println("==================================");
				System.out.println("Department Name: "+dname);
				System.out.println("Total Department Salary : "+totalSalary);
				System.out.println("==================================");		
			}
		}	
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
