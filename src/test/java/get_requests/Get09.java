package get_requests;

import base_urls.RestfulBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;
import static org.junit.Assert.assertEquals;


public class Get09 extends RestfulBaseUrl {
    /*
    Given
        https://restful-booker.herokuapp.com/booking/92
    When
        I send GET Request to the url
    Then
        Response body should be like that;
{
    "firstname": "Carlos",
    "lastname": "Parchment",
    "totalprice": 111,
    "depositpaid": true,
    "bookingdates": {
        "checkin": "2018-01-01",
        "checkout": "2019-01-01"
    },
    "additionalneeds": "Breakfast"
}

 */
    @Test
    public void get09(){
        //  1. Set the URL
        spec.pathParams("first","booking","second",92);

        //  2. SET THE EXPECTED DATA

        //i) ilk olarak inner JSON Map'e donusturulur.
        Map<String,String> bookingdataMap = new HashMap<>();

        bookingdataMap.put("checkin","2018-01-01");
        bookingdataMap.put("checkout","2019-01-01");

        //ii) ikinci olarak outer JSON Map a cevrilir.
        Map<String,Object> expecteddata = new HashMap<>();

        expecteddata.put("firstname","Carlos");
        expecteddata.put("lastname","Parchment");
        expecteddata.put("totalprice",111);
        expecteddata.put("depositpaid",true);
        expecteddata.put("bookingdates",bookingdataMap);
        expecteddata.put("additionalneeds","Breakfast");
        System.out.println(expecteddata);

        //  3. Get request the URL

        Response response=given().spec(spec).when().get("/{first}/{second}");
        response.prettyPrint();

        Map<String,Object> actualData=response.as(HashMap.class);
            assertEquals(expecteddata.get("firstname"),actualData.get("firstname"));
            assertEquals(expecteddata.get("lastname"),actualData.get("lastname"));
            assertEquals(expecteddata.get("totalprice"),actualData.get("totalprice"));
            assertEquals(expecteddata.get("depositpaid"),actualData.get("depositpaid"));
            assertEquals(expecteddata.get("firstname"),actualData.get("firstname"));
            assertEquals(expecteddata.get("bookingdates.checkin"),actualData.get("bookingdates.checkin"));
            assertEquals(bookingdataMap.get("checkin"),((Map)(actualData.get("bookingdates"))).get("checkin"));
            assertEquals(bookingdataMap.get("checkout"),((Map)(actualData.get("bookingdates"))).get("checkout"));

















    }
}
