package com.restapiexample.dummy.cucumber.steps;

import com.restapiexample.dummy.employeeinfo.EmployeeSteps;
import com.restapiexample.dummy.utils.TestUtils;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.ValidatableResponse;
import net.thucydides.core.annotations.Steps;

public class EmployeeStepDefs {

    static String name = "NewlyCreatedUser" + TestUtils.getRandomValue();
    static int salary =  60000 ;
    static int age =  50;
    static int id;

    @Steps
    EmployeeSteps employeeSteps ;

    static ValidatableResponse response;


    @When("^User sends a GET request to employee  endpoint$")
    public void userSendsAGETRequestToEmployeeEndpoint() {
        response = employeeSteps.getEmployees();
    }

    @Then("^User must get back a valid status code (\\d+)$")
    public void userMustGetBackAValidStatusCode(int arg0) {
        response.statusCode(200);
    }

    @When("^User sends a GET request to single employee  endpoint$")
   public void userSendsAGETRequestToSingleEmployeeEndpoint() {
        response = employeeSteps.getEmployeeListById("4");
    }


    @When("^User sends a POST request by sending name and salary$")
    public void userSendsAPOSTRequestBySendingNameAndSalary() {
        response = employeeSteps.createEmployee(name,salary,age);
        response.log().all().statusCode(200);
    }

    @When("^User sends a update request to single employee  endpoint$")
    public void userSendsAUpdateRequestToSingleEmployeeEndpoint() {
        name = name + "updated";
       salary = salary + 10000;
       age = age +10;
       response = employeeSteps.updateEmployee(name,salary,age,id);
    }

    @Then("^User verify employee is updated$")
    public void userVerifyEmployeeIsUpdated() {
        response.log().all().statusCode(200);
    }

    @When("^User sends a Delete request to delete an  employee$")
    public void userSendsADeleteRequestToDeleteAnEmployee() {
       int  empid = 4;
        response= employeeSteps.deleteEmployee(empid);
    }

    @Then("^User verify that the employee is deleted and get status (\\d+)$")
    public void userVerifyThatTheEmployeeIsDeletedAndGetStatus(int arg0){
        response.statusCode(404).log().status();
    }
}