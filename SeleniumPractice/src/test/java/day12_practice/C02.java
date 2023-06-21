package day12_practice;

import utilities.TestBase;
import org.junit.Test;
import org.openqa.selenium.By;

public class C02 extends TestBase {
    /*
    -http://demo.automationtesting.in/Alerts.html sayfasına gidiniz
-Alert with OK karşısındaki click the button to display an alert box: butonuna tıklayınız
-Çıkan alert üzerindeki yazıyı konsola yazdırınız ve tamam butonuna basınız
-Alert with OK & Cancel butonuna basınız ve sonrasında click the button to display a confirm box butonuna basınız
-Çıkan alert'te iptal butonuna basınız
-Alert with Textbox butonuna basınız ve sonrasında click the button to demonstrate the prompt box butonuna basınız
-Çıkan prompt box'a 'isminizi' yazdırınız ve Tamam'a basınız
-Çıkan mesajı konsola yazdırınız
-Çıkan mesajın 'Hello <isminiz> How are you today' yazdığını doğrulayınız
     */

    @Test
    public void test01() {
        driver.get("http://demo.automationtesting.in/Alerts.html");
        bekle(1);

        driver.findElement(By.xpath("//*[@class='btn btn-danger']")).click();
        bekle(1);

        System.out.println(driver.switchTo().alert().getText());
        driver.switchTo().alert().accept();
        bekle(1);

        driver.findElement(By.xpath("(//*[@class='analystic'])[2]")).click();
        bekle(1);

        driver.findElement(By.xpath("//*[@class='btn btn-primary']")).click();
        bekle(1);

        driver.switchTo().alert().dismiss();
        bekle(1);

        driver.findElement(By.xpath("(//*[@class='analystic'])[3]")).click();
        bekle(1);

        driver.findElement(By.xpath("//*[@class='btn btn-info']")).click();
        bekle(1);

        driver.switchTo().alert().sendKeys("omer");
        bekle(1);
        driver.switchTo().alert().accept();

        String sonuc =driver.findElement(By.xpath("//*[@id='demo1']")).getText();
        System.out.println(sonuc);
    }
}
