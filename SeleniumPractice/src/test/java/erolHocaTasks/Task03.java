package erolHocaTasks;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

import java.util.List;

public class Task03 extends TestBase {
    @Test
    public void test01() {

        //Amazon sayfasına gidelim
        driver.get("https://amazon.com");
        bekle(2);

        //Arama Kutusundaki Dropdown menuyu yazdıralım
        WebElement ddm = driver.findElement(By.xpath("//*[@id='searchDropdownBox']"));
        Select select = new Select(ddm);
        //select.getOptions().forEach(t-> System.out.println(t.getText()));

        List<WebElement> options = select.getOptions();
        for(WebElement w : options){
            System.out.println(w.getText());
        }
        System.out.println("*********************************************");

        //Dropdown menuden sırasıyla ilk 5 başlığı (Arts&Crafts ile başlayıp Books'a kadar Books dahil) seçip
        //başlık altındakileri aratalım. Her aramada sayfa başlığını yazdıralım
        int sayac = 1;
        for(WebElement w : select.getOptions()){
            Select option = new Select(driver.findElement(By.xpath("//*[@id='searchDropdownBox']")));
            option.selectByIndex(sayac);
            driver.findElement(By.xpath("//*[@type='submit']")).click();
            System.out.println(driver.getTitle());
            bekle(2);
            driver.navigate().back();
            bekle(2);
            sayac++;
            if(sayac>=6){
                break;
            }
        }

    }

}






