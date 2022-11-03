package get_requests;

import base_urls.RestfulBaseUrl;
import io.restassured.response.*;
import org.junit.Test;

import static io.restassured.RestAssured.*;
import static org.testng.AssertJUnit.*;

public class Get05 extends RestfulBaseUrl {
     /*
        Given
            https://restful-booker.herokuapp.com/booking
        When
            User sends get request to the URL
        Then
            Status code is 200
      And
         Among the data there should be someone whose firstname is "Johhny" and lastname is "Dear"
     */



    @Test
    public void get01(){
        //Set the Url
        spec.pathParam("first","booking").
                queryParams("firstname","Johhny","second","Dear");
        //2.Set the Expected Data
        //3.send the request get the response
        Response response =given().spec(spec).when().get("/{first}");

        //Do Assertion
        assertEquals(200,response.getStatusCode());
        assertFalse(response.asString().contains("bookingid"));












    }

}
