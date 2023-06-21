package day06_practice;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.Set;

public class C01_WindowHandles extends TestBase {
    @Test
    public void test01() throws InterruptedException {

        // 'https://www.n11.com' adresine gidin
        driver.get("https://www.n11.com");
        String sayfa1Handle = driver.getWindowHandle();
        System.out.println("SAYFA1HANDLE : " + sayfa1Handle);
        System.out.println("SAYFA1TITLE : " + driver.getTitle());
        Thread.sleep(2000);

        // arama motoruna 'Oppo' yazıp aratın
        //driver.findElement(By.id("searchData")).sendKeys("Oppo", Keys.ENTER);
        driver.findElement(By.xpath("//input[@id='searchData']")).sendKeys("Oppo", Keys.ENTER);
        Thread.sleep(2000);

        // ilk ürüne tıklayın
        WebElement ilkUrun = driver.findElement(By.xpath("(//img[@class='lazy cardImage'])[1]"));
        ilkUrun.click();
        Thread.sleep(2000);
        //String sayfa2Handle = driver.getWindowHandle();
        //System.out.println("SAYFA2HANDLE : " + sayfa2Handle);
        //driver hala ilk sayfada bunu anliyorum

        Set<String> windowHandleSeti = driver.getWindowHandles();
        System.out.println(windowHandleSeti);

        String sayfa2Handle = "";
        for(String each : windowHandleSeti){
            if(!each.equals(sayfa1Handle)){
               sayfa2Handle = each;
            }
        }
        System.out.println("SAYFA2HANDLE : " + sayfa2Handle);

        driver.switchTo().window(sayfa2Handle);

        // ikinci sayfa title'ının 'Türkiye' icerdigini test edin
        String ikinciSayfaTitle = driver.getTitle();
        Assert.assertTrue(ikinciSayfaTitle.contains("Türkiye"));
        Thread.sleep(2000);

        // ilk sayfaya donun ve Title'ını yazdırın
        driver.switchTo().window(sayfa1Handle);
        String ilkSayfaTitle = driver.getTitle();
        System.out.println("ILKSAYFATITLE : " + ilkSayfaTitle);

    }
}
