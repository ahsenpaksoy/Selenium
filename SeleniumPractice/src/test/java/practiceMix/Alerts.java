package practiceMix;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class Alerts extends TestBase {
    @Test
    public void acceptAlert() {
       // https://testcenter.techproeducation.com/index.php?page=javascript-alerts adresine gidin.
        driver.get("https://testcenter.techproeducation.com/index.php?page=javascript-alerts");
        bekle(2);

        // 1. butona tıklayın, uyarıdaki OK butonuna tıklayın ve result
        //mesajının “You successfully clicked an alert” oldugunu test edin
        driver.findElement(By.xpath("(//button[@class='btn btn-primary'])[1]")).click();
        bekle(2);
        driver.switchTo().alert().accept();
        bekle(2);

        WebElement mesaj = driver.findElement(By.xpath("//*[@id='result']"));
        Assert.assertTrue(mesaj.getText().equals("You successfully clicked an alert"));

    }
    @Test
    public void dismissAlert() {
        // https://testcenter.techproeducation.com/index.php?page=javascript-alerts adresine gidin.
        driver.get("https://testcenter.techproeducation.com/index.php?page=javascript-alerts");
        bekle(2);

        // 2. butona tıklayın, uyarıdaki Cancel butonuna tıklayın ve result
        //mesajının “You clicked: Cancel” oldugunu test edin.
        driver.findElement(By.xpath("(//button[@class='btn btn-primary'])[2]")).click();
        bekle(2);
        driver.switchTo().alert().dismiss();
        WebElement result = driver.findElement(By.xpath("//p[@id='result']"));
        Assert.assertTrue(result.getText().equals("You clicked: Cancel"));

    }
    @Test
    public void sendKeysAlert() {
        // https://testcenter.techproeducation.com/index.php?page=javascript-alerts adresine gidin.
        driver.get("https://testcenter.techproeducation.com/index.php?page=javascript-alerts");
        bekle(2);

        // 3. butona tıklayın, uyarıdaki metin kutusuna isminizi yazin, OK
        //butonuna tıklayın ve result mesajında isminizin görüntülendiğini
        //doğrulayın.
        driver.findElement(By.xpath("(//button[@class='btn btn-primary'])[3]")).click();
        bekle(2);
        driver.switchTo().alert().sendKeys("ahsen");
        bekle(2);
        driver.switchTo().alert().accept();
        bekle(2);
        WebElement result = driver.findElement(By.xpath("//p[@id='result']"));
        Assert.assertTrue(result.getText().contains("ahsen"));


    }

}





