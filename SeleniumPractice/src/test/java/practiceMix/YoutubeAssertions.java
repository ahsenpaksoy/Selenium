package practiceMix;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class YoutubeAssertions extends TestBase {
    @Test
    public void test01() {

        // https://www.youtube.com adresine gidin
        driver.get("https://www.youtube.com");
        driver.findElement(By.xpath("(//div[@class='yt-spec-touch-feedback-shape__fill'])[13]")).click();

        // Aşağıdaki adları kullanarak 3 test metodu oluşturun ve gerekli testleri yapin
        //Sayfa başlığının “YouTube” oldugunu test edin
        String actualTitle = driver.getTitle();
        String  expectedTitle = "YouTube";
        Assert.assertEquals(expectedTitle,actualTitle);

        //YouTube resminin görüntülendiğini (isDisplayed()) test edin
        WebElement youTubePicture = driver.findElement(By.xpath("(//*[@id='logo-icon'])[1]"));
        Assert.assertTrue(youTubePicture.isDisplayed());

        // Search Box 'in erisilebilir oldugunu test edin (isEnabled())
        WebElement searchBox = driver.findElement(By.xpath("(//*[@id='search'])[3]"));
        Assert.assertTrue(searchBox.isEnabled());

        // wrongTitleTest => Sayfa basliginin “youtube” olmadigini dogrulayin
        String actualTitle1 = driver.getTitle();
        String  expectedTitle1 = "youtube";
        Assert.assertFalse(expectedTitle1.equals(actualTitle1));

    }
}
