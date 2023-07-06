package erolHocaTasks;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Task05 extends TestBase {
    @Test
    public void Test01() {
        // https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/ sitesine gidin
        driver.get("https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/");
        bekle(2);

        // ikinci emojiye tıklayın
        WebElement iframe = driver.findElement(By.xpath("//iframe[@id='emoojis']"));
        driver.switchTo().frame(iframe);
        driver.findElement(By.xpath("(//span[@class='mdl-tabs__ripple-container mdl-js-ripple-effect'])[2]")).click();
        bekle(2);

        // İkinci emoji öğelerini yazdırınız
        List<WebElement> emojiler = driver.findElements(By.xpath("//div[@id='nature']//div"));
        for(WebElement w : emojiler){
            System.out.println(w.getText());
        }
        bekle(2);

        // Parent iframe e geri donun
        driver.switchTo().defaultContent();
        bekle(2);

        // Formu doldurun,(Formu istediğiniz metinlerle doldurun)
        List<WebElement> list = driver.findElements(By.xpath("//input[@class='mdl-textfield__input']"));
        List<String> veriler = new ArrayList<>(Arrays.asList(
                "Ahsen","Yildirim","selenium","lambda","java","sql","gitgithub","fsd","dfasf","lkjl","asdasd","asd","sda"));

        for (int i = 0; i < list.size(); i++) {
            list.get(i).sendKeys(veriler.get(i));
        }

        /*
        driver.findElement(By.xpath("(//input[@class='mdl-textfield__input'])[1]")).
                sendKeys("Merhaba", Keys.TAB , ":)" , Keys.TAB , "Ahsen" , Keys.TAB,
                        "Lahmacun" , Keys.TAB , "Yazilim" , Keys.TAB , "Istanbul" , Keys.TAB ,
                        "Bilgisayar" , Keys.TAB , "Ekran" , Keys.TAB , "Vatan" , Keys.TAB , ":))" ,
                        Keys.TAB , ":))))" , Keys.TAB);
         */

        // Apply button a basiniz
        driver.findElement(By.xpath("//*[text()='Apply']")).click();

    }
}
