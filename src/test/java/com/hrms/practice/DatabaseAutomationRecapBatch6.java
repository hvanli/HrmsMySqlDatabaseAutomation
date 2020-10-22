package com.hrms.practice;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseAutomationRecapBatch6 {

	public static void main(String[] args) throws SQLException {
		
		
		/* 1. Establish Connection
		 * 2. Create Statement Object
		 * 3. Execute Query
		 * 4. Process Results
		 * 5. Close connections
		 */
		
		// 1. Establish Connection --> dbUrl, username, password
		
		// Database URL --> jdbc:jdbcType://ipAddress:portNumber/dbName
		// jdbcType --> mysql
		// ipAddress --> 18.232.148.34
		// port    --> 3306
		// databaseName  --> syntaxhrm_mysql
		
		
		// username --> syntax_hrm
		// password --> syntaxhrm123
		
		String dbUrl="jdbc:mysql://18.232.148.34:3306/syntaxhrm_mysql";
		String dbUsername="syntax_hrm";
		String dbPassword="syntaxhrm123";
		
		Connection connect=DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
		
		// DataBaseMetaData  --> Information about our database
		
		DatabaseMetaData dbMetaData=connect.getMetaData();
		
		String driverName=dbMetaData.getDriverName();
		System.out.println("Driver Name = "+driverName);
		
		System.out.println("Product Name = "+ dbMetaData.getDatabaseProductName());
		
		System.out.println(dbMetaData.getURL());
		
		// 2. Create a query statement object
		
		Statement statemant=connect.createStatement();
		
		// 3. Execute query and save result in ResultSet object
		
		ResultSet resultSet=statemant.executeQuery("select id, name, country_code from ohrm_location;");
		
		ResultSetMetaData rsMetaData=resultSet.getMetaData();
		
		int colCount=rsMetaData.getColumnCount();
		System.out.println("Number of columns : "+colCount);
		
	//	rsMetaData.getColumnName(0);
		
		for(int i=1; i<=3; i++) {
			System.out.println("Column Name "+ i+" : "+rsMetaData.getColumnName(i));
		}
		
		for(int i=1; i<=3; i++) {
			System.out.println(rsMetaData.getColumnType(i));
		}
		
		// Process or results
		
		System.out.println("Printing results ....");
		
		while(resultSet.next()) {
			String id=resultSet.getString(1);
			String name=resultSet.getString(2);
			String countryCode=resultSet.getString(3);
			
			System.out.println(id + "     "+name + "     " +countryCode);
		}
		
		// 5. Close all connections
		resultSet.close();
		statemant.close();
		connect.close();
		
		
	}
}
