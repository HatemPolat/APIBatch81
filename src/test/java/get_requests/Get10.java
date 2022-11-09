package get_requests;

import base_urls.GORestBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;
import test_data.GoRestTestData;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;
import static org.junit.Assert.assertEquals;

public class Get10 extends GORestBaseUrl {
     /*
  Given
      https://gorest.co.in/public/v1/users/2986
  When
      User send GET Request to the URL
  Then
      Status Code should be 200
  And
      Response body should be like
  {
    "meta": null,
    "data": {
        "id": 2986,
        "name": "Udit Kakkar",
        "email": "kakkar_udit@huels-feeney.com",
        "gender": "female",
        "status": "active"
    }
}

*/
    @Test
    public void get01() {
        //1.Set the Url

          spec.pathParams("first","users","second",2986);


        //2.Set The Expected Data
        GoRestTestData goRestTestData=new GoRestTestData();
       Map<String,String> innerRestDataMap = goRestTestData.dataKeyMapmethod("Udit Kakkar",
                "kakkar_udit@huels-feeney.com","female","active");
        Map<String,Object>expecteddata=goRestTestData.expectedDataMethod(null,innerRestDataMap);



//3.Send The Request and Get The Response
        Response response = given().spec(spec).when().get("/{first}/{second}");
        response.prettyPrint();


//4.Do Assertion
        Map<String, Object> actualData = response.as(HashMap.class);
        System.out.println(actualData);

        assertEquals(200,response.getStatusCode());
        assertEquals(expecteddata.get("meta"),actualData.get("meta"));
        assertEquals(innerRestDataMap.get("name"),((Map)(actualData.get("data"))).get("name"));
        assertEquals(innerRestDataMap.get("email"),((Map)(actualData.get("data"))).get("email"));
        assertEquals(innerRestDataMap.get("gender"),((Map)(actualData.get("data"))).get("gender"));
        assertEquals(innerRestDataMap.get("status"),((Map)(actualData.get("data"))).get("status"));






    }


}
