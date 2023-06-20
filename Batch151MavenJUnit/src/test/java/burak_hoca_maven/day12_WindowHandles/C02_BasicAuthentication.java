package burak_hoca_maven.day12_WindowHandles;


import burak_hoca_maven.day10_TestBase.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class C02_BasicAuthentication extends TestBase {

        /*
        -Authentication kimlik dogrulama yöntemidir
        - söz konusu sisteme dahil olup olunamayacagını belirleyen formu ifade eder
        - Authentication üzerinde sag click yapıp locate alınamaz
        - Authentication bir alert degildir
        - Authentication yapabilmek icin uygulamanın kullanıcılara,
        Authentication'ı nasıl yapacagına dair bilgilendirme yapmıs olması gerekir
        - https://username:password@URL gibi

         */

        // Aşağıdaki bilgileri kullanarak authentication yapınız:

        // Url: https://the-internet.herokuapp.com/basic_auth
        // Username: admin
        // Password: admin

        //Paragrafın "Congratulations" kelimesini içerdiğini doğrulayınız

    @Test
    public void basicAuthentication() {

        // Aşağıdaki bilgileri kullanarak authentication yapınız:

        // Url: https://the-internet.herokuapp.com/basic_auth
        // Username: admin
        // Password: admin

        /*
         https://username:password@URL
        Yukarıda belirtilen formata uygun kimlik dogrulaması yapılacaktır
         */

        driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");

        //Paragrafın "Congratulations" kelimesini içerdiğini doğrulayınız
        WebElement paragraf = driver.findElement(By.xpath("//p"));

        Assert.assertTrue(paragraf.getText().contains("Congratulations"));
    }
}
