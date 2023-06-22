package techproed.day17_Exceptions;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import techproed.utilities.TestBase;

public class C01_NoSuchElementException extends TestBase {
    @Test
    public void test01() {
        /*
        NO_SUCH_ELEMENT_EXCEPTION :
            -Bir webelementin locate'ini yanlis aldigimizda, elementi bulamayacagi icin bu exception'i aliriz
       */

        //techproeducation sayfasına gidelim
        driver.get("https://techproeducation.com");
        bekle(2);
        driver.findElement(By.xpath("//i[@class='eicon-close']")).click();

        //arama kutusunda qa aratalım
        WebElement aramaKutusu = driver.findElement(By.xpath("//*[@type='ssearch']"));
        /*
            normal locatemiz //*[@type='search'] bu sekilde iken NoSuchElementException alabilmek icin locate'i bozduk
        //*[@type='ssearch'] ve exception'i aldigimizi gorduk. Dolayisiyla bu hatayi handle edebilmek icin
        duzgun locate almamiz gerekiyor. Webelement bir iframe icinde olabilir, bir butona tikladigimizda yeni bir
        pencere acilabilir yada alert cikabilir. Bu gibi durumlarda da nosuchelementexception aliriz.
         */

        aramaKutusu.sendKeys("qa", Keys.ENTER);

        //sayfa başlığının qa içerdiğini test edelim
        Assert.assertTrue(driver.getTitle().contains("qa"));

    }

    @Test
    public void test02() {

        //techproeducation sayfasına gidelim
        driver.get("https://techproeducation.com");
        bekle(2);
        driver.findElement(By.xpath("//*[@class='eicon-close']")).click();
        //arama kutusunda qa aratalım
        WebElement aramaKutusu = driver.findElement(By.cssSelector("//*[@type='search']"));
    /*
    org.openqa.selenium.InvalidSelectorException: xpath ile aldığımız bir webelementin locate'ini
    cssSelector locator ile kullanırsak bu exception'ı alırız. Dolayısıyla bunu handle etmek için
    doğru locator'ı kullanmamız gerekir.
     */

        aramaKutusu.sendKeys("qa", Keys.ENTER);

        //sayfa başlığının qa içerdiğini test edelim
        Assert.assertTrue(driver.getTitle().contains("qa"));

    }
}




