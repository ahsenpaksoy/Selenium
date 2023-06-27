package practiceMix2;

import com.beust.ah.A;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class Actions2 extends TestBase {

    @Test
    public void test01() {
        // Amazon a gidelim https://www.amazon.com/
        driver.get("https://www.amazon.com/");
        bekle(2);

        // Sag ust bolumde bulunan “Account & Lists” menüsüne git “Account” secenegine tikka
        WebElement accountList = driver.findElement(By.xpath("//*[@id='nav-link-accountList-nav-line-1']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(accountList).perform();
        bekle(2);
        driver.findElement(By.xpath("//*[text()='Account']")).click();

        // Acilan sayfanin Title in “Your Account” icerdigini dogrula
        Assert.assertEquals("Your Account",driver.getTitle());

    }
}
