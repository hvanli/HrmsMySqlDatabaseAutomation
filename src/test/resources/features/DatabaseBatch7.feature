@dbBatch7
Feature: Syntax HRM Database Verification

  Background: 
    Given I create connection to SyntaxHRM database
    And I create statement object

  #@jobTitlesBatch7
  #Scenario: Title of your scenario
    #When I execute query for jobtitle verification
    #Then I validate job titles
      #| jobTitle                          |
      #| Cloud Architect                   |
      #| Cloud Consultant                  |
      #| Cloud Product and Project Manager |
      #| IT Analyst                        |
    #And I close connections

  # if we have one row of cucumber datatable without header --> List<String>
  # if we have more than one row of cucumber datatable without header --> List<List<String>>
  # if we have one row of cucumber datatable with header --> Map<Key, Value>
  # if we have more than one row of cucumber datatable with header --> List<Map<Key, Value>>
  @jobTitlesBatch7
  Scenario: Title of your scenario
    When I execute query for jobtitle verification
    Then I validate job titles with an external excel file
    And I close connections
