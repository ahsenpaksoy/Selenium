package get_requests;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class RequestResponse {
    /*
    NOTLAR:
        1- Manuel testler icin Postman kullanacagiz.
        2- API otomasyon testleri icin REST Assured kutuphenesini kullanacagiz
        3- Otomasyon kodlari yazarken su adimlari takip edecegiz:
            a. Gereksinimleri anlama
            b. Test senaryolarini yazma
                i. Test senaryolarini yazarken Gherkin dilini kullanacagiz
                    - Given: On kosullar: Endpoint, body...
                    - When: Islemler: Get, Post, Put, Delete...
                    - Then: Donutler: Assertion, Close...
                    - And: Coklu islemlerin yapilacagi zaman kullanilir.
            c. Otomasyon kodlarını yazarken şu adımları takip ederiz:
                i. Set the URL
                ii. Set the expected data
                iii. Send the request and get the response
                iv. Do assertion
     */
    public static void main(String[] args) {
        String url = "https://petstore.swagger.io/v2/pet/9898";
        Response response = given().when().get(url);
        response.prettyPrint();

        // Status code nasil yazdirilir?
        System.out.println("Status Code : " + response.statusCode());

        // Content Type nasil yazdirilir?
        System.out.println("Content Type : " + response.contentType());

        // Status Line nasil yazdirilir?
        System.out.println("Status Line : " + response.statusLine());

        // Header bolumundeki bir veri nasil yazdirilir?
        System.out.println("Header | Server : " + response.header("Server"));

        // Headers bolumu nasil yazdirilir?
        System.out.println("Headers : " + response.headers());

        // Time bilgisi nasil yazdirilir?
        System.out.println("Time : " + response.time());


    }
}

//prettyPrint() sadece body ' i yazdirir.







