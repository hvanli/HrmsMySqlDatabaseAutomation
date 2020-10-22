package com.hrms.practice;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Assert;

import com.hrms.utils.ConfigUtility;
import com.hrms.utils.DbConstants;

public class DbAutomationRecapBatch7 {

	public static void main(String[] args) throws SQLException {
		
		// precondition Add mysql connector to dependencies (jdbc)
		// Steps to automate database testing
		// 1. Connect to database
		// 2. Create a Statement
		// 3. Execute query
		// 4. Process results (do validations)
		// 5. Close connections
		
		// Create Connection with our database
		// dbURl, dbUsername, dbPassword
		
		// HostName (ipAddress)
		// dbType
		// portNumber
		// dbBaseName
		
		// jdbc:jdbcType://ipAddress:portNumber/dbName
		// String dbUrl="jdbc:mysql://18.232.148.34:3306/syntaxhrm_mysql";
		// config utulity file to read dbConfiguration.properties file
		
		
		// 1. Connect to database
		
		String url=ConfigUtility.getProperty(DbConstants.DB_CONFIG_FILEPATH, "dbUrl");
		String user=ConfigUtility.getProperty(DbConstants.DB_CONFIG_FILEPATH, "dbUsername");
		String password=ConfigUtility.getProperty(DbConstants.DB_CONFIG_FILEPATH, "dbPassword");
		
		Connection connection=DriverManager.getConnection(url, user, password);
		
		DatabaseMetaData dbMetaData=connection.getMetaData();
		
		String dbUrl=dbMetaData.getURL();
		System.out.println(dbUrl);
		
		String dbUsername=dbMetaData.getUserName();
		System.out.println(dbUsername);
		
		String dbProductData=dbMetaData.getDatabaseProductVersion();
		System.out.println(dbProductData);
		
		String dbDriverName=dbMetaData.getDriverName();
		System.out.println(dbDriverName);
		
		// 2. Create a Statement
		Statement statement=connection.createStatement();
		
		// 3. Execute query save results in ResultSet object
		
		ResultSet rSet=statement.executeQuery("select * from ohrm_job_title;");
		
		ResultSetMetaData rsMetaData=rSet.getMetaData();
		
		int colCount=rsMetaData.getColumnCount();
		System.out.println("Number of Columns : "+colCount);
		
		rsMetaData.getColumnName(1);
		
		for(int i=1; i<=colCount; i++) {
			System.out.println("Column Name "+(i)+" : "+rsMetaData.getColumnName(i));
		}
			
		// 4. Process results (print results)
		System.out.println("Printing results");
		
		// next()
		// getString()
		
		while(rSet.next()) {
			
			String id=rSet.getString(1);
			String jobTitle=rSet.getString("job_title");
			String jobDestcription=rSet.getString("job_description");			
			System.out.println(id+"    "+jobTitle+"    "+jobDestcription);
		}
		
		
		
		
		// 5. Close connections in reverse order
		
		rSet.close();
		statement.close();
		connection.close();
		
	}
}
