package get_requests;

import base_urls.HerokuAppBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;
import org.testng.asserts.SoftAssert;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertEquals;

public class Get06 extends HerokuAppBaseUrl {
    /*
      Given
        https://restful-booker.herokuapp.com/booking/22
    When
        User send a GET request to the URL
    Then
        HTTP Status Code should be 200
    And
        Response content type is “application/json”
    And
        Response body should be like;
      {
        "firstname": "John",
        "lastname": "Smith",
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
    public void Get(){

        spec.pathParams("first","booking"
                ,"second",22);

        Response response = given()
                .spec(spec)
                .when()
                .get("{first}/{second}");

        response.prettyPrint();

        //1. Yol
        response
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("firstname",equalTo("John"),
                        "lastname",equalTo("Smith"),
                        "totalprice",equalTo(111),
                        "depositpaid",equalTo(true),
                        "bookingdates.checkin",equalTo("2018-01-01"),
                        "bookingdates.checkout",equalTo("2019-01-01"),
                        "additionalneeds",equalTo("Breakfast")
                );

        //2. Yol: Response data içerrisindeki değerlere ulaşmak için Jsonpath kullanılır
        JsonPath json = response.jsonPath();
        // System.out.println(json.getString("firstname"));//Jane
//        System.out.println(json.getInt("totalprice"));//111
//        System.out.println(json.getBoolean("depositpaid"));//true
        assertEquals("John",json.getString("firstname"));
        assertEquals("Smith",json.getString("lastname"));
        assertEquals(111,json.getInt("totalprice"));
        assertEquals(true,json.getBoolean("depositpaid"));
        assertEquals("2018-01-01",json.getString("bookingdates.checkin"));
        assertEquals("2019-01-01",json.getString("bookingdates.checkout"));
        assertEquals("Breakfast",json.getString("additionalneeds"));

        //SoftAssertion 3 adimda yapilir --> testng pom a eklenmeli

        //1. Adim: SoftAssertion objesi olusturulur
        SoftAssert softAssert = new SoftAssert();

        //2.Adim: Assertion yapilir
        softAssert.assertEquals(json.getString("firstname"),"John","first name uyusmadi------>");
        softAssert.assertEquals(json.getString("lastname"),"Smith","last name uyusmadi ------>");
        softAssert.assertEquals(json.getInt("totalprice"),111,"toplam ucret uyusmadi ---->");
        softAssert.assertEquals(json.getBoolean("depositpaid"),false);
        softAssert.assertEquals(json.getString("bookingdates.checkin"),"2018-01-01");
        softAssert.assertEquals(json.getString("bookingdates.checkout"),"2019-01-01");
        softAssert.assertEquals(json.getString("additionalneeds"),"Breakfast");

        //3. softAssertion.assertAll anahtar kelimeleriyle bitirilir.
        softAssert.assertAll();

        // 3. YOL (Soft Assertion) (Gurkay hocadan devam)
        SoftAssert softAssert1 = new SoftAssert();
        softAssert1.assertEquals(json.getString("firstname"),"Josh");
        softAssert1.assertEquals(json.getString("lastname"),"Allen");
        softAssert1.assertEquals(json.getInt("totalprice"),111);
        softAssert1.assertTrue(json.getBoolean("depositpaid"));
        softAssert1.assertEquals(json.getString("bookingdates.checkin"),"2018-01-01");
        softAssert1.assertEquals(json.getString("bookingdates.checkout"),"2019-01-01");
        softAssert1.assertEquals(json.getString("additionalneeds"),"super bowls");

        softAssert1.assertAll();




    }

}

/*
        Given
            https://restful-booker.herokuapp.com/booking/23
        When
            User send a GET request to the URL
        Then
            HTTP Status Code should be 200
        And
            Response content type is "application/json"
        And
            Response body should be like;
     {
    "firstname": "Bradley",
    "lastname": "Pearson",
    "totalprice": 132,
    "depositpaid": false,
    "bookingdates": {
        "checkin": "2022-10-27",
        "checkout": "2022-11-07"
    },
    "additionalneeds": "None"
}
     */



//hasSize() methodu kac tane data oldugunu sorgulamak icin kullanilir
//hasItem() methodu list icerisinde verilen elemanin olup olmadigini sorgulamak icin kullanilir
//hasSize() methodu kac tane data oldugunu sorgulamak icin kullanilir

// dönen datada bize liste gelmişse özel bir bilgiye ulaşmak için index kullanılır
// hasItem --> contain() metodu gibi
// hasItems --> containAll() metodu gibi

//Soft asserts TestNg ile gelen bir ozellik oldugu icin TestNg pom'a yuklenmeli



















