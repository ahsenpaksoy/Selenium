package practiceMix;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

import java.util.List;

public class DropDown extends TestBase {
    @Test
    public void test01() {

        // https://the-internet.herokuapp.com/dropdown adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dropdown");

        // Index kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
        WebElement ddm = driver.findElement(By.xpath("//select[@id='dropdown']"));
        Select select = new Select(ddm);

        List<WebElement> op = select.getOptions();
        System.out.println(op.get(1).getText());

        select.selectByIndex(1);
        System.out.println(select.getFirstSelectedOption().getText());

        int size = op.size();
        for(int i =0; i<size ; i++){
            String options = op.get(i).getText();
            System.out.println(options);
        }

        // Value kullanarak Seçenek 2'yi (Option 2) seçin ve yazdırın
        select.selectByValue("2");
        System.out.println("OPTION 2 : " + select.getFirstSelectedOption().getText());

        // Visible Text(Görünen metin) kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
        select.selectByVisibleText("Option 1");
        System.out.println(select.getFirstSelectedOption().getText());

        // Tüm dropdown değerleri(value) yazdırın
        List<WebElement> allOptions = select.getOptions();

        for (int i = 0; i < allOptions.size(); i++) {
            String options = allOptions.get(i).getText();
            System.out.println(options);
        }

        // Dropdown’un boyutunu bulun, Dropdown’da 4 öğe varsa konsolda True , degilse False yazdırın.
        int sizeDropDown = allOptions.size();
        if(sizeDropDown==4){
            System.out.println("True");
        }else{
            System.out.println("False");
        }




    }
}
