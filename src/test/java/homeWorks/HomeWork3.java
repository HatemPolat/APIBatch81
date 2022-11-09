package homeWorks;
import base_urls.ReqresBaseUrl;
import io.restassured.http.*;
import io.restassured.path.json.*;
import io.restassured.response.*;
import org.junit.*;
import pojos.Reqres_name_jopPojo;
import test_data.ReqresTestData;
import java.util.HashMap;
import java.util.Map;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.*;
public class HomeWork3 extends ReqresBaseUrl {
    //3: Map ile ve Pojo Class ile ayrı ayrı Gson kullanarak yapınız.
        /*
                Given
                    1) https://reqres.in/api/users/2
                    2) {
                        "name": "morpheus",
                        "job": "zion president"
                        }
                When
                    I send Put Request to the Url
                Then
                    Status code is 200
                    And response body should be like {
                                                        "name": "morpheus",
                                                        "job": "zion president",
                                                        "updatedAt": "2022-10-02T11:35:05.693Z"
                                                    }
        */
    @Test
    public void putHomework(){
        //1.Set the Url
        spec.pathParams("first","users","second",2);
        //Set The Expected
        ReqresTestData objReqres = new ReqresTestData();
        Map expectedData = objReqres.reqresMethodMap("morpheus","zion president");
        System.out.println(expectedData);

        //Send The Request and Get The Response
        Response response = given().spec(spec).
                contentType(ContentType.JSON).body(expectedData).when().put("/{first}/{second}");

        response.prettyPrint();

        //Do Assertion
        Map actualData=response.as(HashMap.class);

        System.out.println(actualData);

        JsonPath json = response.jsonPath();
        assertEquals(200,response.getStatusCode());
        assertEquals(expectedData.get("name"),actualData.get("name"));
        assertEquals(expectedData.get("job"),actualData.get("job"));


            //2 YOL POJO ILE
        //1.Set the Url
        spec.pathParams("first","users","second",2);
        //Set the Expected Data
        Reqres_name_jopPojo expecteddataPojo = new Reqres_name_jopPojo("morpheus","zion president");
        //send the request get the response
        Response responsePojo =given().
                spec(spec).
                contentType(ContentType.JSON).body(expecteddataPojo).when().put("/{first}/{second}");
        responsePojo.prettyPrint();

       Reqres_name_jopPojo actualdataPojo= responsePojo.as(Reqres_name_jopPojo.class);

        JsonPath jsonPojo = response.jsonPath();
        assertEquals(200,response.getStatusCode());
        assertEquals(expecteddataPojo.getJob(),actualdataPojo.getJob());
        assertEquals(expecteddataPojo.getName(),actualdataPojo.getName());




    }




}
