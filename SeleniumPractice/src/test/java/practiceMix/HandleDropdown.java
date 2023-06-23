package practiceMix;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import utilities.TestBase;

public class HandleDropdown extends TestBase {
    @Test
    public void test01() {

        // http://zero.webappsecurity.com/ Adresine gidin
        driver.get("http://zero.webappsecurity.com/");
        bekle(3);

        // Sign in butonuna basin
        driver.findElement(By.xpath("//button[@id='signin_button']")).click();
        bekle(3);

        // Login kutusuna “username” yazin
        driver.findElement(By.xpath("//input[@type='text']")).sendKeys("username");

        // Password kutusuna “password.” yazin
        driver.findElement(By.xpath("//*[@id='user_password']")).sendKeys("password.");

        // Sign in tusuna basin


        // Pay Bills sayfasina gidin
        // “Purchase Foreign Currency” tusuna basin
        // “Currency” drop down menusunden Eurozone’u secin
        // “amount” kutusuna bir sayi girin
        // “US Dollars” in secilmedigini test edin
        // “Selected currency” butonunu secin
        // “Calculate Costs” butonuna basin sonra “purchase” butonuna basin
        // “Foreign currency cash was successfully purchased.” yazisinin ciktigini kontrol edin.


    }
}
