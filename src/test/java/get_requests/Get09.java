package get_requests;

import base_urls.RestfulBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;


public class Get09 extends RestfulBaseUrl {
    /*
    Given
        https://restful-booker.herokuapp.com/booking/91
    When
        I send GET Request to the url
    Then
        Response body should be like that;
{
    "firstname": "Sally",
    "lastname": "Brown",
    "totalprice": 111,
    "depositpaid": true,
    "bookingdates": {
        "checkin": "2013-02-23",
        "checkout": "2014-10-23"
    },
    "additionalneeds": "Breakfast"
}
 */



    @Test

    public void get01(){
        //Set the URL
        spec.pathParams("first","booking","second",91);


        //set the expected data
        Map<String,String> bookingdataMap = new HashMap<>();
        bookingdataMap.put("checkin","2013-02-23");
        bookingdataMap.put("checkout","2014-10-23");

        Map<String,Object> expecteddata = new HashMap<>();
        expecteddata.put("firstname","Sally");
        expecteddata.put("lastname","Brown");
        expecteddata.put("totalprice","111");
        expecteddata.put("depositpaid",true);
        expecteddata.put("bookingdates",bookingdataMap);
        expecteddata.put("additionalneeds","Breakfast");
        System.out.println(expecteddata);

        //Get request the URL

        Response response=given().spec(spec).when().get("/{first}/{second}");
        response.prettyPrint();

        Map<String,Object> actualdataMap= new HashMap<>();
















    }
}
