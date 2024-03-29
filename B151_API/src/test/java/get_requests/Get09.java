package get_requests;

import base_urls.HerokuAppBaseUrl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;
import test_data.HerokuAppTestData;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static junit.framework.TestCase.assertEquals;

public class Get09 extends HerokuAppBaseUrl {
    /*

    Given
        https://restful-booker.herokuapp.com/booking/92
    When
        I send GET Request to the url
    Then
        Response body should be like that;
                {
                "firstname": "Jane",
                "lastname": "Doe",
                "totalprice": 111,
                "depositpaid": true,
                "bookingdates": {
                    "checkin": "2018-01-01",
                    "checkout": "2019-01-01"
                 },
    "additionalneeds": "Midnight snack"
     */
    @Test
    public void get(){
        // Set Url
        spec.pathParams("first","booking"
                ,"second", 92);

        // Set expected data
        Map<String,String> bookingDatesMap = new HashMap<>(); // ilk önce iç map oluşturulur
        bookingDatesMap.put("checkin","2018-01-01");
        bookingDatesMap.put("checkout","2019-01-01");
        System.out.println("bookingDatesMap = " + bookingDatesMap);

        Map<String, Object> expectedDataMap = new HashMap<>();
        expectedDataMap.put("firstname","Jane");
        expectedDataMap.put("lastname","Doe");
        expectedDataMap.put("totalprice",111);
        expectedDataMap.put("depositpaid",true);
        expectedDataMap.put("bookingdates",bookingDatesMap);
        expectedDataMap.put("additionalneeds","Extra pillows please");
        System.out.println("expectedDataMap = " + expectedDataMap);

        // Sent Request and Get Response
        Response response = given(spec).when().get("{first}/{second}");
        response.prettyPrint();

        // Do assertion
        Map<String, Object> actualDataMap = response.as(HashMap.class);
        System.out.println("actualDataMap = " + actualDataMap);

        assertEquals(expectedDataMap.get("firstname"),actualDataMap.get("firstname"));
        assertEquals(expectedDataMap.get("lastname"),actualDataMap.get("lastname"));
        assertEquals(expectedDataMap.get("totalprice"),actualDataMap.get("totalprice"));
        assertEquals(expectedDataMap.get("depositpaid"),actualDataMap.get("depositpaid"));
        assertEquals(expectedDataMap.get("additionalneeds"),actualDataMap.get("additionalneeds"));
        //  assertEquals(  ((Map)expectedDataMap.get("bookingdates")).get("checkin"),  ((Map)actualDataMap.get("bookingdates")).get("checkin"));
        assertEquals(  (bookingDatesMap.get("checkin")) ,  ((Map)actualDataMap.get("bookingdates")).get("checkin"));
        assertEquals(  (bookingDatesMap.get("checkout")) ,  ((Map)actualDataMap.get("bookingdates")).get("checkout"));

/*
        Object map =new HashMap<>();
        ((Map)map )   .get("");
 */

        //parentlar childlarin methodunu kullanamaz get methodu HashMap e ait bu nedenle Object bunu kullanamaz.
        // Ama type casting ile bunu yapabiliriz.

    }
    @Test     // Reusable method kullanarak map uluşturmayı test_data sınıfında yapabiliriz.
    public void get02(){

        // Set Url
        spec.pathParams("first","booking"
                ,"second", 92);

        // Set expected data
        Map<String , String> bookingMap = new HerokuAppTestData()
                .bookingDateMapper("2018-01-01","2019-01-01");
        Map<String,Object> expectedDataMap = new HerokuAppTestData()
                .expectedDataMapper("John","Smith"
                        ,111,true,bookingMap
                        , "Breakfast");

        // Sent Request and Get Response
        Response response = given(spec).when().get("{first}/{second}");
        response.prettyPrint();

        // Do assertion
        JsonPath json = response.jsonPath();
        assertEquals(200,response.statusCode());
        assertEquals(expectedDataMap.get("firstname"),json.getString("firstname"));
        assertEquals(expectedDataMap.get("lastname"),json.getString("lastname"));
        assertEquals(expectedDataMap.get("totalprice"),json.getInt("totalprice"));
        assertEquals(expectedDataMap.get("depositpaid"),json.getBoolean("depositpaid"));
        assertEquals(bookingMap.get("checkin"),json.getString("bookingdates.checkin"));
        assertEquals(bookingMap.get("checkout"),json.getString("bookingdates.checkout"));
        assertEquals(expectedDataMap.get("additionalneeds"),json.getString("additionalneeds"));


        /*
         // Set the URL
        spec.pathParams("first", "booking", "second", 687);

        // Set the expected data --> Gurkay hocanin yazdigi
        HerokuAppTestData obj = new HerokuAppTestData();
        Map<String, String> bookingdatesData = obj.bookingDateMapper("2018-01-01", "2019-01-01");
        Map<String, Object> expectedData = obj.expectedDataMapper("Jane", "Doe", 111,
                true, bookingdatesData, "Extra pillows please");

         // Send the request and get the response
        Response response = given(spec).when().get("{first}/{second}");
        response.prettyPrint();

        // Do assertion
        Map<String, Object> actualData = response.as(HashMap.class);
        assertEquals(expectedData.get("firstname"), actualData.get("firstname"));
        assertEquals(expectedData.get("lastname"), actualData.get("lastname"));
        assertEquals(expectedData.get("totalprice"), actualData.get("totalprice"));
        assertEquals(expectedData.get("depositpaid"), actualData.get("depositpaid"));
        assertEquals(expectedData.get("additionalneeds"), actualData.get("additionalneeds"));
        assertEquals(bookingdatesData.get("checkin"), ((Map)actualData.get("bookingdates")).get("checkin"));
        assertEquals(bookingdatesData.get("checkout"), ((Map)actualData.get("bookingdates")).get("checkout"));

         */

    }

}

//Ic ice datalarla islem yaparken once icerden islem yapmaya baslariz.


















