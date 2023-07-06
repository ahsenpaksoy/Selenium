package erolHocaTasks;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class Task04 extends TestBase {
    @Test
    public void test01() {
        // http://demo.automationtesting.in/Alerts.html sayfasına gidiniz
        driver.get("http://demo.automationtesting.in/Alerts.html");
        bekle(2);

        // Alert with OK karşısındaki click the button to display an alert box: butonuna tıklayınız
        WebElement alert = driver.findElement(By.xpath("//*[@onclick='alertbox()']"));
        alert.click();

        // Çıkan alert üzerindeki yazıyı konsola yazdırınız ve tamam butonuna basınız
        System.out.println(driver.switchTo().alert().getText());
        driver.switchTo().alert().accept();

        // Alert with OK & Cancel butonuna basınız ve sonrasında click the button to display a confirm box butonuna basınız
        driver.findElement(By.xpath("(//a[@class='analystic'])[2]")).click();
        bekle(2);
        driver.findElement(By.xpath("//*[@onclick='confirmbox()']")).click();
        bekle(2);

        // Çıkan alert'te iptal butonuna basınız
        driver.switchTo().alert().dismiss();

        // Alert with Textbox butonuna basınız ve sonrasında click the button to demonstrate the prompt box butonuna basınız
        driver.findElement(By.xpath("//*[text()='Alert with Textbox ']")).click();
        bekle(2);
        driver.findElement(By.cssSelector("button[onclick='promptbox()']")).click();
        bekle(2);

        // Çıkan prompt box'a 'isminizi' yazdırınız ve Tamam'a basınız
        driver.switchTo().alert().sendKeys("Ahsen");
        bekle(2);
        driver.switchTo().alert().accept();

        // Çıkan mesajı konsola yazdırınız
        WebElement msj = driver.findElement(By.xpath("//p[@id='demo1']"));
        System.out.println(msj.getText());

        // Çıkan mesajın 'Hello <isminiz> How are you today' yazdığını doğrulayınız
        Assert.assertEquals("Hello Ahsen How are you today",msj.getText());
    }







}






