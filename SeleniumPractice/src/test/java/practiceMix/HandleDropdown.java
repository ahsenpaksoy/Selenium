package practiceMix;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

public class HandleDropdown extends TestBase {
    @Test
    public void test01() {

        // http://zero.webappsecurity.com/ Adresine gidin
        driver.get("http://zero.webappsecurity.com/");
        bekle(2);

        // Sign in butonuna basin
        driver.findElement(By.xpath("//button[@id='signin_button']")).click();
        bekle(2);

        // Login kutusuna “username” yazin
        driver.findElement(By.xpath("//input[@type='text']")).sendKeys("username");
        bekle(2);

        // Password kutusuna “password.” yazin
        driver.findElement(By.xpath("//*[@id='user_password']")).sendKeys("password.");
        bekle(2);

        // Sign in tusuna basin
        driver.findElement(By.xpath("//input[@type='submit']")).click();
        bekle(2);

        // Pay Bills sayfasina gidin
        driver.findElement(By.xpath("(//*[text()='Online Banking'])[1]")).click();
        bekle(2);
        driver.findElement(By.xpath("(//span[@class='headers'])[4]")).click();
        bekle(2);

        // “Purchase Foreign Currency” tusuna basin
        driver.findElement(By.xpath("(//a)[17]")).click();
        bekle(2);

        // “Currency” drop down menusunden Eurozone’u secin
        WebElement ddm = driver.findElement(By.xpath("//select[@id='pc_currency']"));
        Select select = new Select(ddm);
        select.selectByVisibleText("Eurozone (euro)");

        // “amount” kutusuna bir sayi girin
        driver.findElement(By.xpath("//*[@id='pc_amount']")).sendKeys("500");

        // “US Dollars” in secilmedigini test edin
        WebElement dollarButton = driver.findElement(By.xpath("(//*[@type='radio'])[1]"));
        Assert.assertFalse(dollarButton.isSelected());

        // “Selected currency” butonunu secin
        driver.findElement(By.xpath("(//input[@type='radio'])[2]")).click();

        // “Calculate Costs” butonuna basin sonra “purchase” butonuna basin
        driver.findElement(By.xpath("//*[@id='pc_calculate_costs']")).click();
        driver.findElement(By.xpath("(//input[@type='submit'])[2]")).click();

        // “Foreign currency cash was successfully purchased.” yazisinin ciktigini kontrol edin.


    }
}
