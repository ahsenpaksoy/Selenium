package practiceMix;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class BasicAuthentication extends TestBase {
    @Test
    public void test01() {

        // https://the-internet.herokuapp.com/basic_auth sayfasina gidin
        driver.get("https://the-internet.herokuapp.com/basic_auth");
        bekle(2);

        // asagidaki yontem ve test datalarini kullanarak authentication’i yapin
        // URL : https://username:password@URL
        // Username : admin
        // password : admin

        // Basarili sekilde sayfaya girin ve ‘Congratulations!’ yasizini
        //doğrulayın
        WebElement text = driver.findElement(By.xpath("//p"));
        Assert.assertTrue(text.getText().contains("Congratulations"));

    }
}
