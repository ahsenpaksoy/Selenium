package post_requests;

import base_urls.JsonPlaceHolderBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.JsonPlaceHolderPojo;

import static io.restassured.RestAssured.given;
import static junit.framework.TestCase.assertEquals;

public class Post03Pojo extends JsonPlaceHolderBaseUrl {
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
        // Set Url
        spec.pathParam("first","todos");

        // Set Expected Data
        JsonPlaceHolderPojo payload = new JsonPlaceHolderPojo(55,"Tidy your room",false);
        System.out.println("payload = " + payload);

        // sent req and get resp
        Response response =  given(spec).body(payload).when().post("{first}");
        response.prettyPrint();

        // Do Assertion
        JsonPlaceHolderPojo actualDataPojo = response.as(JsonPlaceHolderPojo.class);

        assertEquals(201,response.statusCode());
        assertEquals(payload.getUserId(),actualDataPojo.getUserId());
        assertEquals(payload.getCompleted(),actualDataPojo.getCompleted());
        assertEquals(payload.getTitle(),actualDataPojo.getTitle());
    }
}
    //pojo class variable lari private yapip getter, setter methodlariyla cagisirip degisiklik yaptigimiz class lardir.
    //Ic ice jsonlar geliyorsa ayri ayri pojo class lar olusturmamiz gerekir
