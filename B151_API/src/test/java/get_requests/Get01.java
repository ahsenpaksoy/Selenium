package get_requests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class Get01 {
    /*
       Given
           https://restful-booker.herokuapp.com/booking/55
       When
           Kullanıcı URL'e bir GET request gönderir
       Then
           HTTP Status Code 200 olmalı
       And
           Content Type "application/json" olmalı
       And
           Status Line "HTTP/1.1 200 OK" olmalı
   */
    @Test
    public void get01(){
        //Birinci Yontem
        String url = "https://restful-booker.herokuapp.com/booking/1";

        //Ikinci Yontem
        RestAssured.baseURI = "https://restful-booker.herokuapp.com";
        RestAssured.basePath = "/booking/1";

        Response response = given().when().get();
        response.prettyPrint();

        response
                .then()
                .statusCode(200)
                .contentType("application/json") // prettyPrint() ile yazdirdigimiz verinin json formatinda geldigini soyler
                .statusLine("HTTP/1.1 200 OK");

    }
}

//given() kismi testin basinda request'in hazirlanmasi asamasidir. Testin temel kosullarini olusturdugumuz adim
//when() kismi olusturulan kosullarin eyleme gecirilip gerceklesmesi
//baseURI kismi degismezken basePath kismi degisebilir
//given() kismi testin basinda request'in hazirlanmasi asamasidir. Testin temel kosullarinin olusturdugumuz adimdir.
// Orn: Rezervasyon bilgilerini siteye girme islemi
//when() kismi olusturulan kosullarin eyleme gecirilip gerceklesmesi adimidir. get,put, post islemleri gibi...
//Orn: Rezervasyonu onayla butonuna tiklanmasi
//then() kismi eylemin sonuclarini kontrol etme islemidir, dogrulanmasidir.
// Onceden belirlenen beklentilerin karsidan gelen cevaplarla karsilastirilmasi islemidir.//Orn:Rezervasyonunuz
// onaylanmistir mesajinin gorulmesi

/*
  response.
                then().
                statusCode(200).        //status kodu dogruladik. Veriyi basarili bir sekilde getirdik. Islem olumlu
                contentType("application/json").    //Bize gelen veri turu Json veri turundedir.Bunu dogruladik
                statusLine("HTTP/1.1 200 OK");      //Bize status kodun detaylarini (protokolu, versiyon numarasini) veriyor.
 */






