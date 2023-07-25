package ssg;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
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

    @Test
    public void selectTest03() {
    /*
        TEST-03:
        1. letcode.in/dropdowns adresine gidin.
        2. Ülkeler menüsünün tıklanabilir olduğunu doğrulayın.
        3. Ülkeler menüsünden India seçeneğini value attribute değeri ile seçin.
        4. Seçilen seçeneğin India olduğunu doğrulayın.
        5. Listede Uruguay seçeneğinin olduğunu doğrulayın.
    */
        driver.get("https://letcode.in/dropdowns");
        WebElement ulkeler = driver.findElement(By.id("country"));
        Assert.assertTrue(ulkeler.isEnabled());
        Select ulkeSelect = new Select(ulkeler);
        ulkeSelect.selectByValue("India");
        Assert.assertEquals("India", ulkeSelect.getFirstSelectedOption().getText());
        List<WebElement> ulkeList = ulkeSelect.getOptions();
        boolean uruguayVarMi = false;
        for (WebElement ulke : ulkeList) {
            if (ulke.getText().equals("Uruguay")){
                uruguayVarMi = true;
                break;
            }
        }
        Assert.assertTrue(uruguayVarMi);
    }
    @Test
    public void selectTest05() {
    /*
        TEST-05:
            1. letcode.in/dropdowns adresine gidin.
            2. Meyveler menüsünden Apple seçeneğini Select class kullanmadan seçin.
            3. Seçilen seçeneğin Apple olduğunu doğrulayın.
            4. Menüde seçilen seçeneği yazdırın.
    */
        driver.get("https://letcode.in/dropdowns");
        WebElement meyveler = driver.findElement(By.id("fruits"));
        meyveler.click();
        WebElement apple = driver.findElement(By.xpath("//option[@value='0']"));
        Actions actions = new Actions(driver);
        actions.keyDown(Keys.ARROW_DOWN).keyDown(Keys.ENTER).build().perform();
        Assert.assertEquals("Apple", apple.getText());
        System.out.println(apple.getText());
    }



}

















