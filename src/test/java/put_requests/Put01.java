package put_requests;

import base_urls.JsonplaceholderBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.*;
import test_data.JsonPlaceHolderTestData;


import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;
import static org.junit.Assert.*;

public class Put01 extends JsonplaceholderBaseUrl {
        /*
        Given
	        1) https://jsonplaceholder.typicode.com/todos/198
	        2) {
                 "userId": 21,
                 "title": "Wash the dishes",
                 "completed": false
               }
        When
	 		I send PUT Request to the Url
	    Then
	   	   Status code is 200
	   	   And response body is like   {
									    "userId": 21,
									    "title": "Wash the dishes",
									    "completed": false
									    "id": 198
									   }
     */

    @Test
    public  void get01() {
        //Set the Url
        spec.pathParams("first","todos","second",198);
        //Set the Expected Data
        JsonPlaceHolderTestData objData = new JsonPlaceHolderTestData();
        
        Map<String,Object> expectedData = objData.expectedDataMethod(21,"Wash the dishes",false);

        System.out.println("expectedData = " + expectedData);
            //Send the Request and get the Response
        Response response= given().spec(spec).
                contentType(ContentType.JSON).body(expectedData).put("/{first}/{second}");

        response.prettyPrint();
        //Do Assertion

        Map actualData= response.as(HashMap.class);

        assertEquals(expectedData.get("completed"),actualData.get("completed"));
        assertEquals(expectedData.get("title"),actualData.get("title"));
        assertEquals(expectedData.get("userId"),actualData.get("userId"));



        







    }



}
