package get_requests;

import base_urls.JsonPlaceHolderBaseUrl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Get07 extends JsonPlaceHolderBaseUrl {
    /*
    Given
           https://jsonplaceholder.typicode.com/todos
    When
       I send GET Request to the URL
    Then
       1)Status code is 200
       2)"Id"leri 190 dan büyük olanları konsola yazdırın
         "Id"si 190 dan büyük 10 adet veri olduğunu doğrulayın
       3)"Id"si 5 den küçük olan tüm kullanıcıların "userid"lerini yazdırın
       "Id"si 5 den küçük olan 4 kullanıcı olduğunu doğrulayın
       4)"Id" si 5 ten küçük tüm kullanıcıların "title" larını yazdırın
         "delectus aut autem" başlığının id numarası 5 den küçük bir kullanıcıya ait olduğunu doğrulayın
     */
    @Test
    public void get(){
        //1. Set url
        spec.pathParam("first","todos");

        //2 Set expected
        //3 Send req and get resp
        Response response = given(spec)
                .when()
                .get("{first}");
        response.prettyPrint();

        //Do Assertion
        assertEquals(200,response.statusCode());
        JsonPath json = response.jsonPath();

        //"Id"leri 190 dan büyük olanları konsola yazdırın
        /*
        List<Object> idList = json.getList("findAll{it.id>190}");
        System.out.println("ID List: " + idList);
         */
        List<Integer> idList = json.getList("findAll{it.id>190}.userId");
        System.out.println("idList --> " + idList); //Groovy language list icindeki jsonlarda sorgulama yapip data geri cagirmamizi saglar

        //"Id"si 190 dan büyük 10 adet veri olduğunu doğrulayın
        assertEquals(10,idList.size());

        //"Id"si 5 den küçük olan tüm kullanıcıların "userid"lerini yazdırın
        List<Integer> userIdList = json.getList("findAll{it.id<5}.userId");
        System.out.println("userIdList = " + userIdList);

        //"Id"si 5 den küçük olan 4 kullanıcı olduğunu doğrulayın
        assertEquals(4,userIdList.size());

        //4)"Id" si 5 ten küçük tüm kullanıcıların "title" larını yazdırın
        List<String> titleList = json.getList("findAll{it.id<5}.title");
        System.out.println("titleList = " + titleList);
        //System.out.println(json.getList("findAll{it.title=='delectus aut autem'}")); //title'i belirtilen json datayi getirir

        //"delectus aut autem" başlığının id numarası 5 den küçük bir kullanıcıya ait olduğunu doğrulayın
        assertTrue(titleList.contains("delectus aut autem"));

        System.out.println(json.getList("findAll{it.title=='delectus aut autem'}.id"));
        //burasi onemli ==> title'i delectus aut autem olan verinin id numarasini aldik burda

    }
}

//Groovy language list icindeki json'lari sorgulama yapip data geri cagirmamizi saglar.
//json ile list icinden data cagirma denebillir gibi.

//findAll{} bir tablo icinde arama yapmak icin kullaniriz. {} icine item 'in kisaltmasi olan
// it yazilir ve hangi veriyi istiyorsak onun sartini ekleriz.

//{} icinde sarti koyunca sarta uyan tum veriler gelirken {} den sonra . koyup neyi almak
// istiyorsak o veriyi yazarsak sadece o veriyi aliriz.

//findAll{} bir tablo icinde arama yapmak icin kullaniriz. {} icine item 'in kisaltmasi olan it yazilir
// ve hangi veriyi istiyorsak onun sartini ekleriz.
//{} icinde sarti koyunca sarta uyan tum veriler gelirken {} den sonra . koyup neyi almak istiyorsak o
// veriyi yazarsak sadece o veriyi aliriz.

//body nin icerisine gondercegimiz veriye payLoad denir.










