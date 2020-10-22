package com.hrms.practice;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseTestAutomation {

	// Selenim WebDriver --> Automating Browser --> GUI (Graphical User Interface Testing)
	// JDBC (Java Database Conncetivity API) to execute queries in Selenium
	// What kind of databases we can access with jdbc-- MySQL, MS Access, SQL and etc
	// What is SQL Means --> RDBMS --> Relational Database Management System
	
	// JDBS Provides us
	// DriverManager Class
	// Connection Interface
	// Statement Interface
	// ResultSet Interface
	// SQLException Class
	
	// Steps To Achieve Database Testing by Using Seleinum
	
	// We have to modify our POM.xml file..
	//	MySQL JDBC from maven repository
	
	// 1. Create Connection with the Database
	// 2. Create Statement
	// 3. Execute our Query
	// 4. Process Results
	// 5. Close Connections
	
	/*
	 Now we need information about our DataBase:
	HostName: 166.62.36.207
	Port: 3306
	DB Name: syntaxhrm_mysql
	UserName: syntax_hrm
	Password: syntaxhrm123
	 */
	
	public static void main(String[] args) throws SQLException {
		
		// 1. Create Conncetion with the Database
// Syntax for establishing connection with db	
//	DriverManager.getConnection(DatabaseULR, userId, password);
	// DatabaseURL Syntax
	// jdbc:jdbcType://ipAdress:portNumber/dbName
	// mysql - oracle and so on
	
	// String dbURL="jdbc:mysql://166.62.36.207:3306/syntaxhrm_mysql"
		
		String dbURL="jdbc:mysql://166.62.36.207:3306/syntaxhrm_mysql";
		String userName="syntax_hrm";
		String password="syntaxhrm123";
		
		
		Connection connection=DriverManager.getConnection(dbURL, userName, password);
		
		// DatabaseMetaData --> Information about the database
		// --> Create an object of DatabaseMetaData
		
		DatabaseMetaData dbMetaData=connection.getMetaData();
		
		// By using dbMetaData object we will get some information
		// .getDriverName() --> returns the name of the JDBC driver
		
		String jdbcDriverName=dbMetaData.getDriverName();
		System.out.println("JDCB Driver Name : "+jdbcDriverName);
		
		// .getUserName() --> returns UserName
		String username=dbMetaData.getUserName();
		System.out.println("Username : "+username);
		
		// .getURL();
		// getDatabaseProductName() --> returns product name of the database
		
		// getDatabaseProductversion() --> returns database product version
		
		
		
		// 2. Create Statement
		
		
		Statement statement=connection.createStatement();
		
		
		// 3. Execute our Query
		
		
		String query="SELECT * FROM ohrm_employment_status;";
		
		ResultSet resultSet=statement.executeQuery(query);
		
		// ResultSetMetaData  --> information about the resultSet
		// Create an object of ResultSetMetaData by using resultSet object
		
		ResultSetMetaData rsMetaData=resultSet.getMetaData();
		
		// getColumnCount() --> returns number of columns in resultSet
		
		int colCount=rsMetaData.getColumnCount();
		System.out.println("Numer of Colums in resultSet : "+colCount);
		
		// getColumnName(int index) --> returns name of column at given index
		
		String colname1=rsMetaData.getColumnName(1);
		System.out.println("Name of first coumn : "+ colname1);
		
		// getColumnTypeName(int index) --> Returns data type of column at given index
		
		System.out.println("Column Type : "+rsMetaData.getColumnTypeName(1));
		
		// getTableName();	
		
		
		// 4. Process Results
		
		// Lets print infromation we get from the query
		// next() --> moves the curser to the one mor row next from the current position
		
//		resultSet.next(); // --> the cuser came to the first row
//				
//		String id=resultSet.getString(1);
//		
//		String empStatus=resultSet.getString("name");
//		System.out.println(id+" -- "+empStatus);
//		
//		resultSet.next();
//		
//		id=resultSet.getString(1);		
//		empStatus=resultSet.getString("name");
//		
//		System.out.println(id+" -- "+empStatus);
		
		while(resultSet.next()) {
			String id=resultSet.getString(1); // returns the value of a cell at given index
			String empStatus=resultSet.getString("name");
			System.out.println(id+" -- "+empStatus);
		}
		
		// 5. Close Connections
		
		// connection - statemant - resultSet
		
		resultSet.close();
		statement.close();
		connection.close();
		
		// Break Until 7.50 pm
	}
	
	// What is MetaData --> Data about data
	// 1. DatabaseMetaData --> Information about the database
	// 2. ResultSetMetaData  --> information about the resultSet
	
	
	
	
	
}
