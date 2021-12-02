package com.employee.management;

import java.sql.Connection;
import java.sql.DriverManager;

public class JDBCConnection {
	
	static Connection con;
	
	public static Connection createConnection() {
		try {
			//load the driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//create the connection
			String user="root";
			String password="9211";
			String url= "jdbc:mysql://localhost:3306/employee_manage?characterEncoding=utf8";
			
			con= DriverManager.getConnection(url,user, password);
					
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return con;
	}
}
