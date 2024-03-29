package post_requests;

import base_urls.JsonPlaceHolderBaseUrl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class Post01 extends JsonPlaceHolderBaseUrl {
    /*
    Given
           1) https://jsonplaceholder.typicode.com/todos
           2)  {
                 "userId": 55,
                 "title": "Tidy your room",
                 "completed": false
              }
        When
            I send POST Request to the Url
        Then
            Status code is 201
        And
            response body is like {
                                    "userId": 55,
                                    "title": "Tidy your room",
                                    "completed": false,
                                    "id": 201
                                    }

     */
    @Test
    public void post() {
        //Set url
        spec.pathParam("first","todos");

        //2 Set expected data
        String payload = " {\n" +
                        "\"userId\": 55,\n" +
                        "\"title\": \"Tidy your room\",\n" +
                        "\"completed\": false\n" +
                        "}";

        //Send request and get response
        Response response = given(spec).body(payload).when().post("{first}");
        response.prettyPrint();

        //Do assertion
        //assertEquals(201,response.statusCode());

        JsonPath json = response.jsonPath();

        assertEquals(55,json.getInt("userId"));
        assertEquals("Tidy your room",json.getString("title"));
        assertFalse(json.getBoolean("completed"));
        assertEquals(201, json.getInt("id"));
    }

    // Dinamik Method
    @Test
    public void post01Map() {

        //Set url
        spec.pathParam("first","todos");

        //2 Set expected data
        Map<String,Object> expectedData = new HashMap<>();
        expectedData.put("userId",55);
        expectedData.put("title","Tidy your room");
        expectedData.put("completed",false);
        System.out.println("expectedData = " + expectedData);

        //Send request and get response
        Response response = given(spec).body(expectedData).when().post("{first}"); //Burada Serialization yapiliyor
                                                                          //java object'sini ---> json objesine cevirir
        response.prettyPrint();

        //Do assertion
        Map<String,Object> actualData = response.as(HashMap.class); //Deserialization yapildi --> json objesini java objesine donusturdu

        assertEquals(201,response.statusCode());
        assertEquals(expectedData.get("userId"),actualData.get("userId"));
        assertEquals(expectedData.get("title"),actualData.get("title"));
        assertEquals(expectedData.get("completed"),actualData.get("completed"));
        assertEquals(201,actualData.get("id"));

    }
}
    //Serialization ---> Java Objesinin Json Objesine cevrilmesidir
    //Deserialization ---> Json Objesinin Java Objesine cevrilmesidir.
    //Bu işlemler için jackson-databind kütüphanesi kullanılır
    //payload==body

//Biz map gondermeye calisiyoruz karsi taraf json data bekliyor. Bu nedenle IllegalStateException aliriz.
//Serialization icin (veri donusumu) Jackson (Databind) eklentisini pom a yukleyerek handle edebiliriz

//Biz map gonderiyoruz karsi tarafa ama bizden json bekleniyor, bu java objesini jason objesine donusturmeliyiz
//Java object'in Json object'e cevrilmesine serialization deniyor
//Bunu yapabilmek icin de POM.xml'e Jackson repository'sini ekleyecegiz
// Serialization = Java Map datasının Json datasına çevrilmesidir
//Deserialization ---> Json Objesinin Java Map Objesine cevrilmesidir.

















