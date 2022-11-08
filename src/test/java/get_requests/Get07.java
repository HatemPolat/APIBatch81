package get_requests;

import base_urls.JsonplaceholderBaseUrl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.*;
import org.junit.*;

import java.util.List;

import static io.restassured.RestAssured.*;
import static org.junit.Assert.*;

public class Get07 extends JsonplaceholderBaseUrl {
    /*
        Given
              https://jsonplaceholder.typicode.com/todos
      When
          I send GET Request to the URL == > URL'e Get Request gonderin
      Then
          1)Status code is 200 == > Status kodu 200 olmali

          2)Print all ids greater than 190 on the console ==> id si 190 dan buyuk olanlari konsola yazdirin
                ii)id si 190 dan buyuk olanlardan isismleri getir.

            Assert that there are 10 ids greater than 190 == > 10 tane id nin 190 dan buyuk oldugunu dogrulayin

          3)Print all userIds whose ids are less than 5 on the console ==> id si 5 den kucuk olan tum userid
           lerini konsolunu yazdirin

            Assert that the number of userIds whose ids are less than 5 is 4 ==> id si 5 den kucuk olan 4 tane userId
             oldugunu dogrulayin
          4)Print all titles whose ids are less than 5 ==> ıd si 5 den kucuk olan tum basliklari yazdirin

            Assert that "delectus aut autem" is one of the titles whose id is less than 5 ==> id si 5 den kucuk olan
             datalarin birinin
            basliginin "delectus aut autem" icerdigini dogrulayin
     */

    @Test
    public void get01() {
        //3.SET the Url
        spec.pathParams("first","todos");
        //2.Set the Expected Data
        //I send GET Request to the URL
        Response response =given().spec(spec).when().get("/{first}");
        //response.prettyPrint();

        //4.Do Assertion
            response.then().statusCode(200);
           // assertEquals(200, response.getStatusCode());

        JsonPath json= response.jsonPath();

        List<Integer> ids = json.getList("findAll{it.id>190}.id");//groovy  language java temelli

        System.out.println("ids 190'dan buyuk olanlar= " + ids);
        //2.Assert that there are 10 ids greater than 190
        assertEquals("Id'si 190'dan buyuk olanlar:",10,ids.size());


        //  3)Print all userIds whose ids are less than 5 on the console
        List<Integer> ids5den_Kucukolanlar= json.getList("findAll{it.id<5}.id");
        System.out.println("ids5den_Kucukolanlar = " + ids5den_Kucukolanlar);
        //4)Print all titles whose ids are less than 5 ==> ıd si 5 den kucuk olan tum basliklari yazdirin

        List<String> titles = json.getList("findAll{it.id<5}.title");
        System.out.println("titles = " + titles);
        //  Assert that "delectus aut autem" is one of the titles whose id is less than 5 ==> id si 5 den kucuk olan
        //             datalarin birinin
        //            basliginin "delectus aut autem" icerdigini dogrulayin

        assertTrue("id'si 5 den kucuk olanlarin biri 'delectus aut autem' icermemektedir" ,
                titles.contains("delectus aut autem"));




    }
























}
