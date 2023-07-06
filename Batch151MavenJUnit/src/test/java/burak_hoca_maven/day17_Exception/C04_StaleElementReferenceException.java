package burak_hoca_maven.day17_Exception;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import burak_hoca_maven.utilities.TestBase;

public class C04_StaleElementReferenceException extends TestBase {
    /*
              StaleElementReferanceException:

        bir web sayfasındaki bir webelementin gecerliliginin kayboldugu durumlarda olusur.
        Yani bir webelementi locate ettikten sonra sayfada refresh yada back-forward kullanıyorsak
        yeniden o elemente ulasmak istedigimizde StaleElementReferanceException hatasını alırız.
        Bunu handle edebilmek icin webelemente yeniden aynı locate'ı atamalıyız.
        (webelementin locate'ını hatırlatma gibi diyebiliriz.)
     */

    @Test
    public void StaleElementReferenceExceptionTest1() {
        // techproeducation sayfasina gidiniz
        driver.get("https://techproeducation.com");
        bekle(2);

        //reklami kapatalim
        driver.findElement(By.xpath("//i[@class='eicon-close']")).click();
        bekle(2);

        //sayfayi yenileyelim
        driver.navigate().refresh();   //navigate'den önceki locate'ler bayatlar ve tekrar kullanamayiz.
        bekle(2);

        //LMS LOGIN butonuna tiklayalim
        WebElement login = driver.findElement(By.xpath("(//a[@class='elementor-item'])[4]"));
        login.click();

    }

    @Test
    public void StaleElementReferenceExceptionTest2() {

        // techproeducation sayfasina gidiniz
        driver.get("https://techproeducation.com");
        bekle(2);

        //reklami kapatalim
        driver.findElement(By.xpath("//i[@class='eicon-close']")).click();
        bekle(2);

        // LMS LOGIN butonunun locate'ını alalım
        WebElement login = driver.findElement(By.xpath("(//*[text()='LMS LOGIN'])[1]"));

        // sayfayı yenileyelim
        driver.navigate().refresh();

        // LMS LOGIN butonuna tıklayalım
        login.click();  // burada lms login elementi bayatladigi icin hata verdi

        /*
        LMS LOGIN webelementini locate ettikten sonra sayfayi yeniledigimiz icin LMS LOGIN webelementi
        eskidi(bayatladi). Sonrasinda bayatlayan webelemente click yaptigimiz icin StaleElementReferanceException
        hatasi aldik.
        Bu exception'i handle edebilmek icin refresh yaptiktan sonra tekrar ayni locate'i webelemente atamamiz gerekiyor.
         */

    }

    @Test
    public void StaleElementReferenceExceptionTest3() {

        // techproeducation sayfasina gidiniz
        driver.get("https://techproeducation.com");
        bekle(2);

        //reklami kapatalim
        driver.findElement(By.xpath("//i[@class='eicon-close']")).click();
        bekle(2);

        // LMS LOGIN butonunun locate'ını alalım
        WebElement login = driver.findElement(By.xpath("(//*[text()='LMS LOGIN'])[1]"));

        // sayfayı yenileyelim
        driver.navigate().refresh();

        // LMS LOGIN butonuna tıklayalım
        login = driver.findElement(By.xpath("(//*[text()='LMS LOGIN'])[1]"));
        login.click();

    }


}

  //navigate() isleminden onceki locate'ler navigate() isleminden sonra bayatlar.












