package day06_practice;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

import java.util.Set;

public class C03_ActionMoveToElement extends TestBase {
    @Test
    public void test01() {

        // https://amazon.com adresine gidiniz
        driver.get("https://amazon.com");
        String sayfa1Handle = driver.getWindowHandle();
        System.out.println("SAYFA1HANDLE : " + sayfa1Handle);

        // sag ust bolumde bulunan dil secenek menusunun acilmasi icin mause'u bu menunun ustune getirelim
        Actions actions = new Actions(driver);
        WebElement dilMenu = driver.findElement(By.xpath("//div[text()='EN']"));
        actions.moveToElement(dilMenu).perform();
        bekle(2);

        // Change country/region butonuna basiniz
        driver.findElement(By.xpath("(//div[@class='icp-mkt-change-lnk'])[1]")).click();
        bekle(2);

        // United States dropdown'undan 'Turkey (Türkiye)' seciniz
        WebElement ddm = driver.findElement(By.xpath("//select[@id='icp-dropdown']"));
        Select select = new Select(ddm);
        select.selectByVisibleText("Turkey (Türkiye)");
        //select.selectByValue();
        //select.selectByIndex();
        bekle(2);


        // Go to website butonuna tiklayiniz
        driver.findElement(By.xpath("//span[text()='Changing country/region website']")).click();
        /*
        dropdown option listesi "Go to website" butonuna basmamiza engel oldugu icin herhangi bir
        yere click yapip dropdown option listesinin toparlanmasini sagladik.
         */
        driver.findElement(By.xpath("//*[@class='a-button-input']")).click();


        // acilan yeni sayfadanin Title'inin Elektronik icerdigini test ediniz
        Set<String> windowHandleSeti = driver.getWindowHandles();

        String sayfa2Handle = "";
        for(String each : windowHandleSeti){
            if(!each.equals(sayfa1Handle)){
                sayfa2Handle = each;
            }
        }
        System.out.println("SAYFA2HANDLE : " + sayfa2Handle);
        driver.switchTo().window(sayfa2Handle);
        bekle(2);

        String ikinciSayfaTitle = driver.getTitle();
        System.out.println("IKINCISAYFATITLE : " + ikinciSayfaTitle);

        Assert.assertTrue(ikinciSayfaTitle.contains("Elektronik"));


    }
}




