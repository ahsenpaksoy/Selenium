package ssg;

import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import utilities.TestBase;

public class C01_Alert extends TestBase {

    @Test
    public void alertTest01() {
        driver.get("http://demoqa.com/alerts");
        driver.findElement(By.id("alertButton")).click();

        Alert alert = driver.switchTo().alert();
        String str = alert.getText();
        System.out.println("str = " + str);
        alert.accept();

    }

    @Test
    public void alertTest02() {
        driver.get("http://demoqa.com/alerts");
        driver.findElement(By.id("confirmButton")).click();
        Alert alert = driver.switchTo().alert();
        bekle(2);
        alert.dismiss();
        bekle(2);

    }

    @Test
    public void alertTest03() {
        driver.get("http://demoqa.com/alerts");
        driver.findElement(By.id("promtButton")).click();
        Alert alert = driver.switchTo().alert();
        alert.sendKeys("Tuba");
        alert.accept();

    }

    @Test
    public void alertTest04() {

        //Authentication (Kimlik Dogrulama Penceresi) - Basic
        //Digit Authentication (Sifreyi hashode a ceviren bir teknik kullanir)

        driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");
    }

    @Test
    public void alertTest05() {
        driver.get("http://demoqa.com/alerts");
        driver.findElement(By.id("timerAlertButton")).click();
        bekle(6);
        driver.findElement(By.id("confirmButton")).click();//UnhandledAlertException exception aldik

        driver.switchTo().alert().accept();

    }
}
