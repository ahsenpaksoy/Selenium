package practiceMix2;

import com.github.javafaker.Faker;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class FakerHomework extends TestBase {
    @Test
    public void Test01() {

        // "https://facebook.com" Adresine gidin
        driver.get("https://facebook.com");
        bekle(2);

        // “create new account” butonuna basin
        //driver.findElement(By.xpath("//*[@id='u_0_k_eo']")).click();  // cookies accept
        driver.findElement(By.xpath("(//*[@type='submit'])[2]")).click(); // cookies decline
        driver.findElement(By.xpath("(//a[@role='button'])[2]")).click();

        // “firstName” giris kutusuna bir isim yazin
        WebElement isimKutusu = driver.findElement(By.xpath("(//input[@type='text'])[2]"));
        Faker faker = new Faker();
        String email = faker.internet().emailAddress();
        //String firstName = faker.name().firstName();
        //isimKutusu.sendKeys(firstName);


        Actions actions = new Actions(driver);
        actions.click(isimKutusu).sendKeys(faker.name().firstName()).sendKeys(Keys.TAB).sendKeys(faker.name().lastName()).
                sendKeys(Keys.TAB).sendKeys(email).sendKeys(Keys.TAB).sendKeys(faker.internet().password()).sendKeys(Keys.TAB).
                sendKeys(Keys.TAB).sendKeys("July").sendKeys(Keys.TAB).sendKeys("17").sendKeys(Keys.TAB).sendKeys("2000").
                sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.ARROW_RIGHT).sendKeys(Keys.ARROW_RIGHT).sendKeys(Keys.ARROW_RIGHT).sendKeys(Keys.TAB).sendKeys(Keys.TAB).
                sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.ENTER).perform();


       /* actions.click(isimKutusu).
                sendKeys(faker.name().firstName()).
                sendKeys(Keys.TAB).
                sendKeys(faker.name().lastName()).
                sendKeys(Keys.TAB).
                sendKeys(email).
                sendKeys(Keys.TAB).
                sendKeys(email).
                sendKeys(Keys.TAB).
                sendKeys(faker.internet().password()).
                sendKeys(Keys.TAB).
                sendKeys(Keys.TAB).
                sendKeys("15").
                sendKeys(Keys.TAB).
                sendKeys("Mart").
                sendKeys(Keys.TAB).
                sendKeys("2000").
                sendKeys(Keys.TAB).
                sendKeys(Keys.TAB).
                sendKeys(Keys.ARROW_RIGHT).
                sendKeys(Keys.TAB).
                sendKeys(Keys.TAB).
                sendKeys(Keys.TAB).
                sendKeys(Keys.TAB).
                sendKeys(Keys.TAB).
                sendKeys(Keys.ENTER).perform();
*/


        // “surname” giris kutusuna bir soyisim yazin
        // “email” giris kutusuna bir email yazin
        // “email” onay kutusuna emaili tekrar yazin
        // Bir sifre girin
        // Tarih icin gun secin
        // Tarih icin ay secin
        // Tarih icin yil secin
        // Cinsiyeti secin
        // Isaretlediginiz cinsiyetin secili, diger cinsiyet kutusunun secili olmadigini test edin.

        Assert.assertTrue(driver.findElement(By.xpath("(//input[@type='radio'])[1]")).isSelected());
        //Assert.assertTrue(driver.findElement(By.xpath("(//input[@type='radio'])[2]")).isSelected());

        // Sayfayi kapatin

    }
}
