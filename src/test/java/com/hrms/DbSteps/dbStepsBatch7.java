package com.hrms.DbSteps;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Map;

import org.junit.Assert;

import com.hrms.utils.ConfigUtility;
import com.hrms.utils.DbConstants;
import com.hrms.utils.ExcelUtility;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class dbStepsBatch7 {

	Connection connection;
	Statement statement;
	ResultSet rSet;

	@Given("I create connection to SyntaxHRM database")
	public void i_create_connection_to_SyntaxHRM_database() {
		String url = ConfigUtility.getProperty(DbConstants.DB_CONFIG_FILEPATH, "dbUrl");
		String user = ConfigUtility.getProperty(DbConstants.DB_CONFIG_FILEPATH, "dbUsername");
		String password = ConfigUtility.getProperty(DbConstants.DB_CONFIG_FILEPATH, "dbPassword");

		try {
			connection = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	@Given("I create statement object")
	public void i_create_statement_object() {

		try {
			statement = connection.createStatement();
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	@When("I execute query for jobtitle verification")
	public void i_execute_query_for_jobtitle_verification() {

		try {
			rSet = statement.executeQuery("select job_title from ohrm_job_title order by id limit 0, 4;");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Then("I validate job titles")
	public void i_validate_job_titles(io.cucumber.datatable.DataTable dataTable) throws SQLException {

		// Cucumber datatable without header
//		List<List<String>> expData=dataTable.asLists();
//		
		int i = 0;
//		while(rSet.next()) {
//			String actJobTitle=rSet.getString(1);
//			String expJobTitle=expData.get(i).get(0);
//			i++;
//			
//			Assert.assertEquals(expJobTitle, actJobTitle);			
//		}

		// Cucumber datatable with header
		List<Map<String, String>> expJobTitles = dataTable.asMaps();

		while (rSet.next()) {

			String actJobTitle = rSet.getString(1);
			String expJobTitle = expJobTitles.get(i).get("jobTitle");
			i++;
			Assert.assertEquals(expJobTitle, actJobTitle);
		}

	}

	@Then("I close connections")
	public void i_close_connections() throws SQLException {

		rSet.close();
		statement.close();
		connection.close();
	}

	@Then("I validate job titles with an external excel file")
	public void i_validate_job_titles_with_an_external_excel_file() throws SQLException {

		String filePath = DbConstants.TEST_DATA_FILEPATH;

		List<Map<String, String>> expJobTitles = ExcelUtility.excelIntoListOfMaps(filePath, "jobTitle");
		int i=0;
		
		while (rSet.next()) {

			String actJobTitle = rSet.getString(1);
			String expJobTitle = expJobTitles.get(i).get("jobTitle");
			i++;
			Assert.assertEquals(expJobTitle, actJobTitle);
		}
	}
}
