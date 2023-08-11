package get_requests;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class RequestResponse {
    /*
        1- Manuel API testi için Postman kullanıyoruz.
        2- API otomasyon testi için REST Assured kütüphanesini kullanıyoruz.
        3- Otomasyon kodlarının yazımı için şu adımları izleriz:
            A- Gereksinimleri anlama
            B- Test senaryosu yazma
                a- Test senaryosu yazmak içi Gherkin dilini kullanıyoruz.
                    - Given: Endpoint, body ...
                    - When: get, put, post gibi işlemler
                    - Then: Assertion, Close ...
                    - And: Çoklu işlemlerin art arda yapıldığı zaman kullanılır.
            C- Otomasyon kodlarını yazarken şu adımları izleriz:
                1- Set the URL = URL'i tanımla
                2- Set the expected data = Beklenen dataları ayarla
                3- Send the request and get the response = İsteği gönder ve cevabı al
                4- Do assertion = Doğrulama yap
     */

    //  i. Set the URL
    //  ii. Set the expected data
    // iii. Send the request and get the response
    //  iv. Do assertion


    public static void main(String[] args) {
        // Get testi nasıl yapılır?
        //String url = "https://petstore.swagger.io/v2/pet/3435";
        String url = "https://petstore.swagger.io/v2/pet/46466161";
        Response response = given().when().get(url);
        response.prettyPrint();

        // Status Code nasıl yazdırılır?
        System.out.println("Status Code: " + response.statusCode());
        System.out.println("__________________________");
        //statusCode() ile getStatusCode() methodlari ayni islemi gorur.

        // Content Type nasıl yazdırılır?
        System.out.println("Content Type: " + response.contentType());
        System.out.println("__________________________");

        // Status Line nasıl yazdırılır?
        System.out.println("Status Line: " + response.statusLine());
        System.out.println("__________________________");

        // Header'daki veriler nasıl yazdırılır?
        System.out.println("Header | Server: " + response.header("Server"));
        System.out.println("__________________________");
        System.out.println("Header | Connection: " + response.header("Connection"));
        System.out.println("__________________________");

        // Headers bolumu nasıl yazdırılır?
        System.out.println("Headers: " + response.headers());
        System.out.println("__________________________");

        // Time bilgisi nasıl yazdırılır?
        System.out.println("Time: " + response.time());

    }
}
//response.prettyPrint();   //response dan gelen cevabi json olarak yazdirmaya yarar

/*
    200 Success :+1:
    300 Redirection
    400 Client Error
    500 Server Error
 */

   /*
        Request ==> istek
        Response ==> istege gonderilen cevap
        Status code = Gelen cevabin basari durumu
        Post ==> creat ==> Request olusturma islemi => Istek olusturma
        Get ==> read ==>Request sorgulama => Istegin olusup olusmadigini veya
        verilen url deki bilgilerin dogrulugunu sorgulama
        Put ==> update ==> Request i update etme => Istegi guncelleme
        Delete ==> delete ==> Request'i delete etme => Istegi silme islemi
        Bu islemlere kisaca CRUD islemleri denir
         */
   //Status Code ile birbirine benzer bu sadece HTTP protokol versiyonunu da verir
   //post ve put ta body gerekli
    /*
        post ve put islemlerinde request'in body bolumune ihtiyac duyulurken
         get ve delete islemlerinde request'in body bolumune gerek yoktur.
         */
