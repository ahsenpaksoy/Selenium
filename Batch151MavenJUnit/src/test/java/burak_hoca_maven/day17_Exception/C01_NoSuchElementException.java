package burak_hoca_maven.day17_Exception;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import burak_hoca_maven.utilities.TestBase;

public class C01_NoSuchElementException extends TestBase {
    @Test
    public void NoSuchElementException() {

        /*
          NoSuchElementException : Sayfada bulunmayan bir elemente erisim saglanmaya calisildiginda
          NoSuchElementException hatasi aliriz.
         */

        // techproeducation sayfasina gidiniz
        driver.get("https://techproeducation.com");
        bekle(3);

        // reklami kapatiniz
        driver.findElement(By.xpath("//*[@class='eicon-close']")).click();

        // searchBox'a java yazip aratalim
        driver.findElement(By.xpath("//input[@id='YANLISelementor-search-form-9f26725']")).sendKeys("Java" + Keys.ENTER);



    }
}
