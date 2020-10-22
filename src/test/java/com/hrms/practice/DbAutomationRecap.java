package com.hrms.practice;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class DbAutomationRecap {

	public static void main(String[] args) throws SQLException {
		
		
		// 1. Create Connection to database
		// required credentials are dbURL, dbUsername, dbPassword
		
		
		
		String dbUrl="jdbc:mysql://18.232.148.34:3306/syntaxhrm_mysql";
		String dbUsername="syntax_hrm";
		String dbPassword="syntaxhrm123";
		
		Connection con=DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
		
		DatabaseMetaData dbMetaData=con.getMetaData();
		
		String driverName=dbMetaData.getDriverName();
		System.out.println(driverName);
		
		String driverVersion=dbMetaData.getDriverVersion();
		System.out.println(driverVersion);
		
		String userName=dbMetaData.getUserName();
		System.out.println(userName);
		
		String url=dbMetaData.getURL();
		System.out.println(url);
		String productVersion=dbMetaData.getDatabaseProductVersion();
		System.out.println(productVersion);
		
		// 2. Create a Query statement
		Statement statement=con.createStatement();
		
		// 3. Execute Query and save results from database in ResultSet object
		
		ResultSet resultSet=statement.executeQuery("select * from ohrm_employment_status;");
		
		while(resultSet.next()) {
			String id=resultSet.getString("id");
			String name=resultSet.getString("name");
			
			System.out.println(id+" "+name);
		}
		
		// ResultSetMetaData
		
		ResultSetMetaData rsMetaData=resultSet.getMetaData();
		
		// getColumnCount()
		// getColumnName(int index)
		// getColumnTypeName()
		//getTableName() 
		
		
		// close all connections
		resultSet.close();
		statement.close();		
		con.close();
	}
}
