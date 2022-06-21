@SMOKE
Feature: Testing dummyrestapiexample website with different methods

  Scenario: Check if User can get all employee data
    When User sends a GET request to employee  endpoint
    Then User must get back a valid status code 200

  Scenario: Check if User can get single employee data
    When User sends a GET request to single "id" employee  endpoint
    Then User must get back a valid status code 200

  Scenario: Check if User can create a  single employee data
    When User sends a POST request by sending name and salary
    Then User must get back a valid status code 200

  Scenario: Check if User can update single employee data
    When User sends a update request to single employee  endpoint
    Then User verify employee is updated

  Scenario: Check if User can  delete employee data
    When User sends a Delete request to delete an  employee
    Then User verify that the employee is deleted and get status 200








