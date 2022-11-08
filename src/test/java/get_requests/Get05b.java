package get_requests;

import base_urls.ReqresBaseUrl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.*;
import org.junit.*;
import org.testng.asserts.SoftAssert;

import static io.restassured.RestAssured.*;
import static junit.framework.TestCase.assertEquals;

public class Get05b extends ReqresBaseUrl {
    /*
        Given
          https://reqres.in/api/unknown/3
        When
            User send a GET request to the URL
        Then
            HTTP Status Code should be 200
        And
            Response content type is “application/json; charset=utf-8”
        And
            Response body should be like;(Soft Assertion)
        {
        "data": {
            "id": 3,
            "name": "true red",
            "year": 2002,
            "color": "#BF1932",
            "pantone_value": "19-1664"
        },
        "support": {
            "url": "https://reqres.in/#support-heading",
            "text": "To keep ReqRes free, contributions towards server costs are appreciated!"
        }
}
      */

    @Test
    public void get01() {
        //Set the URL
        spec.pathParams("first","unknown","second",3);
        //GET request to the URL
        Response response= given().spec(spec).when().get("/{first}/{second}");
        response.prettyPrint();

        //Set the Expected data
        //Do Assertion
        JsonPath json =response.jsonPath();

        assertEquals(200,response.getStatusCode());
        assertEquals("application/json; charset=utf-8",response.contentType());

        SoftAssert softAssert= new SoftAssert();

        softAssert.assertEquals(json.getInt("data.id"),3);
        softAssert.assertEquals(json.getString("data.name"),"true red");
        softAssert.assertEquals(json.getInt("data.year"),2002);
        softAssert.assertEquals(json.getString("data.color"),"#BF1932");
        softAssert.assertEquals(json.getString("data.pantone_value"),"19-1664");
        softAssert.assertEquals(json.getString("support.url"),"https://reqres.in/#support-heading");
        softAssert.assertEquals(json.getString("support.text"),
                "To keep ReqRes free, contributions towards server costs are appreciated!");
        softAssert.assertAll();



    }





}
