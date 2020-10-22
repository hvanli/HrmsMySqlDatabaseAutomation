//package com.hrms.DbSteps;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
//import java.util.ArrayList;
//import java.util.List;
//
//import org.junit.Assert;
//
//import io.cucumber.java.en.Given;
//import io.cucumber.java.en.Then;
//import io.cucumber.java.en.When;
//
//public class DbSteps {
//
////	private Connection connection;
////	private Statement statement;
////	private ResultSet resultSet;
//
////	@Given("I create connection with SyntaxHrms database")
////	public void i_create_connection_with_SyntaxHrms_database() {
////
////		String dbURL = "jdbc:mysql://166.62.36.207:3306/syntaxhrm_mysql";
////		String userName = "syntax_hrm";
////		String password = "syntaxhrm123";
////
////		try {
////			connection = DriverManager.getConnection(dbURL, userName, password);
////		} catch (SQLException e) {
////			e.printStackTrace();
////		}
////	}
////
////	@Given("I create a statement")
////	public void i_create_a_statement() {
////
////		try {
////			statement = connection.createStatement();
////		} catch (SQLException e) {
////			e.printStackTrace();
////		}
////	}
////
////	@When("I retrieve all job tittles from database")
////	public void i_retrieve_all_job_tittles_from_database() {
////		
////
////		String query = "SELECT DISTINCT(job_title) FROM ohrm_job_title";
////
////		try {
////			resultSet = statement.executeQuery(query);
////		} catch (SQLException e) {
////			e.printStackTrace();
////		}
////	}
////
////	@Then("I validate results for Job Titles")
////	public void i_validate_results_for_Job_Titles(io.cucumber.datatable.DataTable dataTable) throws SQLException {
////
////		// we will compare results in resulSet and in dataTabe
////		
////		List<Map<String, String>> expResults=dataTable.asMaps();
////		
////		Iterator <Map<String, String>> it=expResults.iterator();
////		
//////		resultSet.next();
////		
////		while(it.hasNext()) {
////			
////			// retrieve expected value from datatable
////			Map<String, String> expRes=it.next();
////			String expJobTitle=expRes.get("job_title");
////			
////			// retrive actual result from resultSet
////			
////			resultSet.next();
////			String actJobTitle=resultSet.getString("job_title");
////			
////			
////			Assert.assertEquals(expJobTitle, actJobTitle);
////			
////		}
////		
////		
////	}
////
////	@Then("I close all connections")
////	public void i_close_all_connections() throws SQLException {
////
////		resultSet.close();
////		statement.close();
////		connection.close();
////	}
//
//	Connection connect;
//	Statement statement;
//	ResultSet resultSet;
//
//	@Then("I close all connections")
//	public void i_close_all_connections() throws SQLException {
//		resultSet.close();
//		statement.close();
//		connect.close();
//	}
//
//	@Given("I create connection with SyntaxHRM database")
//	public void i_create_connection_with_SyntaxHRM_database() {
//		String dbUrl = "jdbc:mysql://18.232.148.34:3306/syntaxhrm_mysql";
//		String dbUsername = "syntax_hrm";
//		String dbPassword = "syntaxhrm123";
//
//		try {
//			connect = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//	}
//
//	@Given("I create statement object")
//	public void i_create_statement_object() {
//		try {
//			statement = connect.createStatement();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//	}
//
//	@When("I retrieve all locations from database")
//	public void i_retrieve_all_locations_from_database() {
//		try {
//			resultSet = statement.executeQuery("select id, name, country_code from ohrm_location limit 1,4;");
//		} catch (SQLException e) {
//
//			e.printStackTrace();
//		}
//	}
//
//	@Then("I validate locations for SyntaxHRM")
//	public void i_validate_locations_for_SyntaxHRM(io.cucumber.datatable.DataTable dataTable) {
//		List<List<String>> data = dataTable.asLists();
//		int i = 0;
//		try {
//			while (resultSet.next()) {
//
//				String actId = resultSet.getString(1);
//				String actName = resultSet.getString(2);
//				String actCountryCode = resultSet.getString(3);
//				
//
//				String expId = data.get(i).get(0);
//				String expName = data.get(i).get(1);
//				String expCountryCode = data.get(i).get(2);
//
//				i++;
//				Assert.assertEquals(expId, actId);
//				Assert.assertEquals(expName, actName);
//				Assert.assertEquals(expCountryCode, actCountryCode);
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//	}
//
//}
