package practice01;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class Get01_IDileContactGetirme {
    @Test
    public void get01() {
        RestAssured.baseURI = "https://thinking-tester-contact-list.herokuapp.com";
        RestAssured.basePath = "/contacts/64d7dce936c2810013fe7d4a";
        String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJfaWQiOiI2NGQ3YzRlYzM2YzI4MTAwMTNmZTdjMzAiLCJpYXQiOjE2OTE4NjM1Nzd9.R43XICXxW1G33Yq5-wfSxIZMp-cX6fHDlUtxpH-bHNs";

        Response response = given()
                .auth().oauth2(token)
                .when()
                .get();
        response.prettyPrint();

        response
                .then()
                .body("firstName", equalTo("Ahsen"))
                .body("lastName", equalToIgnoringCase("doe"))
                .body("email", not(equalTo("ahsen@fake.com")))
                .body("email", containsString("@fake.com"))
                .body("city", startsWith("Any"))
                .body("city", endsWith("own"))
                .body("stateProvince", anyOf(equalTo("KS"), equalTo("CA")))
                .body("country", allOf(equalTo("USA"), equalToIgnoringCase("usa")))
                .body("__v", greaterThan(-1));

    }
}









