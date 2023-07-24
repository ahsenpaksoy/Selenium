package ssg;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

import java.util.List;

public class SelectClass extends TestBase {
    @Test
    public void dropDownTesti01() {

        // https://letcode.in/dropdowns adresine gidin.
        driver.get("https://letcode.in/dropdowns");

        // Meyveler menüsünün tıklanabilir olduğunu doğrulayın.
        WebElement meyveler = driver.findElement(By.id("fruits"));
        Assert.assertTrue(meyveler.isEnabled());

        // Meyveler menüsünden Apple seçeneğini görünen metin ile seçin.
        Select select = new Select(meyveler);
        select.selectByVisibleText("Apple");

        // Seçilen seçeneğin Apple olduğunu doğrulayın.
        Assert.assertEquals("Apple",select.getFirstSelectedOption().getText());

        // Menüde seçilen seçeneği yazdırın.
        System.out.println(select.getFirstSelectedOption().getText());
        bekle(3);

    }

    @Test
    public void dropDownTest02() {

        // https://letcode.in/dropdowns adresine gidin.
        driver.get("https://letcode.in/dropdowns");

        //Programlama Dilleri menüsünün tıklanabilir olduğunu doğrulayın.
        WebElement programlamaDilleri = driver.findElement(By.id("lang"));
        Assert.assertTrue(programlamaDilleri.isEnabled());

        //Menüdeki son seçeneği seçin.
        Select select = new Select(programlamaDilleri);
        List<WebElement> programlamaDilleriListesi = select.getOptions();
        select.selectByIndex(programlamaDilleriListesi.size()-1);

        //Seçilen seçeneğin C# olduğunu doğrulayın.
        Assert.assertEquals("C#",select.getFirstSelectedOption().getText());

        //Listede C++ seçeneğinin olmadığını doğrulayın.
        for(WebElement programDili : programlamaDilleriListesi){
            Assert.assertFalse(programDili.getText().contains("C++"));
        }

        //Menüdeki tüm elemanları yazdırın.
        for(WebElement programDili : programlamaDilleriListesi){
            System.out.println(programDili.getText());
        }

    }

    @Test
    public void dropDownTest03() {

        // https://letcode.in/dropdowns adresine gidin.
        driver.get("https://letcode.in/dropdowns");

        //Kahramanlar menüsünün, çoklu seçim yapılabilen bir menü olduğunu doğrulayın.
        WebElement kahramanlar = driver.findElement(By.id("superheros"));
        Select select = new Select(kahramanlar);
        Assert.assertTrue(select.isMultiple());

        //Kahramanlar menüsünden 3 tane kahramanı index numaraları ile seçin.
        select.selectByIndex(3);
        select.selectByIndex(5);
        select.selectByIndex(7);

        //Menüde 3 elemanın seçili olduğunu doğrulayın.
        Assert.assertEquals(3,select.getAllSelectedOptions().size());

        //Menüde seçili elemanların isimlerini doğrulayın.
        List<WebElement> seciliKahramanlarListesi = select.getAllSelectedOptions();
        for (WebElement kahraman : seciliKahramanlarListesi){
            Assert.assertTrue(kahraman.getText().contains("Batman") ||
                    kahraman.getText().contains("Black Panther") ||
                    kahraman.getText().contains("Captain Marvel"));
        }

        //Seçili elemanlardan birinin seçimini kaldırın.
        select.deselectByIndex(3);

        //Menüde 2 elemanın seçili olduğunu doğrulayın.
        Assert.assertEquals(2,select.getAllSelectedOptions().size());

        //Menüde seçili elemanların isimlerini doğrulayın.
        seciliKahramanlarListesi = select.getAllSelectedOptions();
        for (WebElement kahraman : seciliKahramanlarListesi){
            Assert.assertTrue(kahraman.getText().contains("Black Panther") ||
                    kahraman.getText().contains("Captain Marvel"));
        }

        //Seçili elemanların hepsinin seçimini kaldırın.
        select.deselectAll();

        //Menüde hiçbir elemanın seçili olmadığını doğrulayın.
        Assert.assertEquals(0,select.getAllSelectedOptions().size());

    }
}

















