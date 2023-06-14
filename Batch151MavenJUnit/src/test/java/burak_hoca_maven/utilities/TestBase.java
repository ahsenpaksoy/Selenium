package burak_hoca_maven.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class TestBase {

    /*
       TestBase class'indan obje olusturmanin onune gecmek icin bu class'i abstract yapabiliriz.
       TestBase testBase = new TestBase(); yani bu sekilde obje olusturmanin onune gecmis oluruz.
       Bu class'a extend yaptigimiz test class'larinda ulasabiliriz.
     */
    protected WebDriver driver;
    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
    }

    //HARD WAIT (Bekleme Methodu)
    public void bekle(int saniye) {
        try {
            Thread.sleep(saniye * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    //AcceptAlert
    public void acceptAlert(){
        driver.switchTo().alert().accept();
    }

    //DismisstAlert
    public void dismissAlert(){
        driver.switchTo().alert().dismiss();
    }

    //getTextAlert
    public String getTextAlert(){
        return driver.switchTo().alert().getText();
    }

    //sendKeysAlert
    public void sendKeysAlert(String text) {
        driver.switchTo().alert().sendKeys(text);

    }


    //DropDown VisibleText
    public void selectVisibleText(WebElement ddm, String text){
        Select select = new Select(ddm);
        select.selectByVisibleText(text);
    }

    //DropDown Index
    public void selectIndex(WebElement ddm,int index){
        Select select = new Select(ddm);
        select.selectByIndex(index);
    }

    //DropDown Value
    public void selectValue(WebElement ddm,String value){
        Select select = new Select(ddm);
        select.selectByValue(value);
    }

}
            /*
             //Bir butona tiklayip yeni acilan pencereye sag klik ile mudehale edebiliyorsak buna "HTML Alerts" denir
        //Bir butona tiklayip yeni acilan pencereye sag klik ile mudehale edemiyorsak buna "Js Alert" denir. Burda
        mudehale edebilmemiz icin Alert'i driver.switch() ile degistirmemiz gerekir
             */

