package ssg;

import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class Alert extends TestBase {
    @Test
    public void alertTest01() {

        //https://demoqa.com/alerts
        driver.get("https://demoqa.com/alerts");

        driver.findElement(By.id("alertButton")).click();
        String str = driver.switchTo().alert().getText();
        System.out.println(str);
        driver.switchTo().alert().accept();
    }

    @Test
    public void alertTest02() {

        //https://demoqa.com/alerts
        driver.get("https://demoqa.com/alerts");

        bekle(2);
        driver.findElement(By.id("confirmButton")).click();
        driver.switchTo().alert().dismiss();
        bekle(2);
    }

    @Test
    public void alertTest03() {
        driver.get("https://demoqa.com/alerts");
        driver.findElement(By.id("promtButton")).click();
        bekle(2);
        driver.switchTo().alert().sendKeys("Gürkay");
        driver.switchTo().alert().accept();
        bekle(2);
    }

    @Test
    public void alertTest04() {

        //https://the-internet.herokuapp.com/
        driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");

        //Authentication (Kimlik Dogrulama Penceresi) - Basic
        //Digit Authentication (Sifreyi hashode a ceviren bir teknik kullanir)
    }

    @Test
    public void alertTest05() {
        driver.get("https://demoqa.com/alerts");
        driver.findElement(By.id("timerAlertButton")).click();
        bekle(6);
        driver.findElement(By.id("confirmButton")).click();
        driver.switchTo().alert().accept();
    }
}















