package com.pnt.api;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DummyPractice {

    /*
    There are following public apis
#	Route	        Method  Type	                    Full route	                                Description	Details
1	/employees	    GET	    JSON	http://dummy.restapiexample.com/api/v1/employees	    Get all employee data Details
2	/employee/{id}	GET	    JSON	http://dummy.restapiexample.com/api/v1/employee/{id}	Get a single employee data Details
3	/create	        POST	JSON	http://dummy.restapiexample.com/api/v1/create	        Create new record in database Details
4	/update/{id}	PUT	    JSON	http://dummy.restapiexample.com/api/v1/update/{id}	    Update an employee record Details
5	/delete/{id}	DELETE	JSON	http://dummy.restapiexample.com/api/v1/delete/{id}	    Delete an employee record Details
*/


    public String baseURI = RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1/";

    private String employeesEndpoint = "employees";
    private String employeeEndpoint = "employee/";
    private String createEndpoint = "create";
    private String updateEndpoint = "update/";
    private String deleteEndpoint = "delete/";


    @Test
    public void getAllEmployees() {
        Response response = RestAssured.given().when().get(employeesEndpoint).then()
                .assertThat().statusCode(200).extract().response();

        System.out.println(response.asString());
        System.out.println(response.getStatusCode());

        JSONObject js = new JSONObject(response.asString());
        System.out.println(js.get("data").toString());
        System.out.println(js.get("status"));

        JSONArray jsonArray = js.getJSONArray("data");
        System.out.println(jsonArray);

        JSONObject js1 = (JSONObject) jsonArray.get(0);
        System.out.println(js1.get("employee_name"));
    }


    @Test
    public void getOneEmployee() {
        Response response = RestAssured.given().when().get(employeeEndpoint + 870).then()
                .assertThat().statusCode(200).extract().response();
        System.out.println(response.asString());

        // store into JSONObject and print employee name
        JSONObject js = new JSONObject(response.asString());
        JSONObject jsData = (JSONObject) js.get("data");
        System.out.println(jsData.get("employee_name"));
    }


    @Test
    public void postAEmployee() {

        JSONObject js = new JSONObject();
        js.put("name", "peoplentech");
        js.put("salary", 1000);
        js.put("age", 27);

        System.out.println(js);

        Response response = RestAssured.given().header("Content-Type", "application/json")
                .body(js.toString()).when().post(createEndpoint).then().assertThat().statusCode(200).extract().response();

        System.out.println(response.asString());

        // after you make a post call, always make a get call if you have the endpoint available or db call
        // to validate the data from the post call made it to db

    }

    @Test
    public void updateARecord() {
        JSONObject js = new JSONObject();
        js.put("name", "Rahat");
        js.put("salary", 135000);
        js.put("age", 27);

        Response response = RestAssured.given().contentType(ContentType.JSON)
                .body(js.toString()).when().put(updateEndpoint + 7258).then().extract().response();

        System.out.println(response.asString());
        System.out.println(response.getStatusCode());
        Assert.assertEquals(response.getStatusCode(), 200);
    }


    @Test
    public void deleteARecord() {
        Response response = RestAssured.given().contentType(ContentType.JSON)
                .delete(deleteEndpoint + 3162).then().extract().response();

        System.out.println(response.asString());
        System.out.println(response.getStatusCode());
        Assert.assertEquals(response.getStatusCode(), 200);
    }


    @Test
    public void testJSONArray() {
        JSONObject js1 = new JSONObject();
        js1.put("name", "peoplentech");
        js1.put("salary", 1000);
        js1.put("age", 27);

        JSONObject js2 = new JSONObject();
        js2.put("name", "peoplentech");
        js2.put("salary", 1000);
        js2.put("age", 27);


        JSONArray array = new JSONArray();
        array.put(js1);
        array.put(js2);


        System.out.println(array);

    }
}
