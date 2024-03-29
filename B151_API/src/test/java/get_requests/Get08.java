package get_requests;

import base_urls.JsonPlaceHolderBaseUrl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;
import test_data.JsonPlaceHolderTestData;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Get08 extends JsonPlaceHolderBaseUrl {
    /*
    Given
            https://jsonplaceholder.typicode.com/todos/2
        When
            I send GET Request to the URL
        Then
            Status code is 200
            And "completed" is false
            And "userId" is 1
            And "title" is "quis ut nam facilis et officia qui"
            And header "Via" is "1.1 vegur"
            And header "Server" is "cloudflare"
            {
                "userId": 1,
                "id": 2,
                "title": "quis ut nam facilis et officia qui",
                "completed": false
            }
     */

    @Test // junit den olusturuyoruz
    public void get() {
        // Set url
        spec.pathParams("first","todos", "second",2);

        //expected data
        JsonPlaceHolderTestData obj = new JsonPlaceHolderTestData();
        Map<String,Object> expectedData = obj.expectedDataMapper(1,"quis ut nam facilis et officia qui",false);
        expectedData.put("id",2);
        expectedData.put("Via","1.1 vegur");
        expectedData.put("Server","cloudflare");

        System.out.println("expectedData = " + expectedData);

        // Send request and get response
        Response response = given(spec).when().get("{first}/{second}");
        response.prettyPrint();

        // Do Assertion
        /*
        JsonPath json = response.jsonPath();
        assertEquals(expectedData.get("userId"),json.getInt("userId"));
         */
        Map<String,Object> actualData = response.as(HashMap.class);
        System.out.println("actualData = " + actualData);

        assertEquals(200,response.statusCode());
        assertEquals(expectedData.get("id"),actualData.get("id"));
        assertEquals(expectedData.get("userId"),actualData.get("userId"));
        assertEquals(expectedData.get("title"),actualData.get("title"));
        assertEquals(expectedData.get("completed"),actualData.get("completed"));
        assertEquals(expectedData.get("Via"),response.header("Via"));
        assertEquals(expectedData.get("Server"),response.header("Server"));


    }
}

    //Bir post işlemi yaptığımızda id verisi bize veritabanından geliyor arkadaşlar. Biz id verisini kendimiz
    // girmiyoruz ve id verisinin ne geleceğini bilemiyoruz. Bize gelecek id'nin ne olduğunu bilmediğimiz için
    // id parametresini expectedDataMapper metoduna koymamalıyız, yoksa her kullandığımızda id girmemiz gerekir.
    // Ama burada put metoduyla expectedData objesine ekleyerek doğrulayabiliriz.

 // Sadece put post ve patch de body kullaniyoruz, get de olmaz.

//header, status code, time, size bilgileri response'un icerisinde mevcut. actualData ile sadece body
// icesindeki datalari test ettik.





















