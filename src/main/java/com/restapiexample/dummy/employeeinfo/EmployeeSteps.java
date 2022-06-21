package com.restapiexample.dummy.employeeinfo;

import com.restapiexample.dummy.constants.EndPoints;
import com.restapiexample.dummy.model.EmployeePojo;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

public class EmployeeSteps {

    @Step("Getting All Employee Details")
    public ValidatableResponse getEmployees() {
        return SerenityRest.given().log().all()
                .header("Content-Type", "application/json")
                .contentType(ContentType.JSON)
                .when()
                .get(EndPoints.GET_ALL_EMPLOYEES)
                .then();
    }

    @Step("Getting Single Employee List")
    public ValidatableResponse getEmployeeListById(String id) {
        return SerenityRest.given().log().all()
                .contentType(ContentType.JSON)
                .pathParam("id", id)
                .when()
                .get(EndPoints.GET_SINGLE_EMPLOYEE_BY_ID)
                .then();
    }

    @Step("Creating a Employee with name:{0},salary :{1}, age :{2}")
    public ValidatableResponse createEmployee(String name, int salary, int age) {
        EmployeePojo employeePojo = new EmployeePojo();
        employeePojo.setName(name);
        employeePojo.setSalary(salary);
        employeePojo.setAge(age);


        return SerenityRest.given().log().all()
                .contentType(ContentType.JSON)
                .body(employeePojo)
                .when()
                .post(EndPoints.CREATE_EMPLOYEE)
                .then();
    }

    @Step("Updating an Employee with name:{0},salary :{1}, age :{2}")
    public ValidatableResponse updateEmployee(String name, int salary, int age , int id) {
        EmployeePojo employeePojo = new EmployeePojo();
        employeePojo.setName(name);
        employeePojo.setSalary(salary);
        employeePojo.setAge(age);
        employeePojo.setId(id);

        return SerenityRest.given().log().all()
                .contentType(ContentType.JSON)
                .body(employeePojo)
                .when()
                .put(EndPoints.UPDATE_EMPLOYEE_BY_ID)
                .then();
    }
    @Step("Deleting employee information with employeeId: {0}")
    public ValidatableResponse deleteEmployee(int id) {
        return SerenityRest.given().log().all()
                .pathParam("id", id)
                .when()
                .delete(EndPoints.DELETE_EMPLOYEE_BY_ID)
                .then();

    }


}
