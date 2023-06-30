package practiceMix2;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C05_UploadFile extends TestBase {
    @Test
    public void Test01() {
        // https://the-internet.herokuapp.com/upload adresine gidelim
        driver.get("https://the-internet.herokuapp.com/upload");
        bekle(3);

        String dosyaYolu = "C:\\Users\\Sinem\\Desktop\\notes.txt";
        //chooseFile butonuna basalim
        WebElement dosyaSec = driver.findElement(By.id("file-upload"));
        //dosyaSec.click(); -> click yapmadi hata aldik

        //Yuklemek istediginiz dosyayi secelim.
        dosyaSec.sendKeys(dosyaYolu);
        bekle(2);

        //Upload butonuna basalim.
        driver.findElement(By.id("file-submit")).click();
        bekle(2);

        //"File Uploaded!" textinin goruntulendigini test edelim.
        Assert.assertTrue(driver.findElement(By.xpath("//h3")).isDisplayed());
    }
}
