package practiceMix;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

public class HandleDropdown extends TestBase {
    @Test
    public void test01() {

        // http://zero.webappsecurity.com/ Adresine gidin
        driver.get("http://zero.webappsecurity.com/");
        bekle(2);

        // Sign in butonuna basin
        driver.findElement(By.xpath("//button[@id='signin_button']")).click();
        bekle(2);

        // Login kutusuna “username” yazin
        driver.findElement(By.xpath("//input[@type='text']")).sendKeys("username");
        bekle(2);

        // Password kutusuna “password” yazin
        driver.findElement(By.xpath("//*[@id='user_password']")).sendKeys("password");
        bekle(2);

        // Sign in tusuna basin
        driver.findElement(By.xpath("//input[@type='submit']")).click();
        bekle(2);
        driver.navigate().back();

        // Pay Bills sayfasina gidin
        driver.findElement(By.xpath("(//*[text()='Online Banking'])[1]")).click();
        //driver.findElement(By.xpath("(//strong)[2]")).click();
        bekle(2);
        driver.findElement(By.xpath("(//span[@class='headers'])[4]")).click();
        bekle(2);

        // “Purchase Foreign Currency” tusuna basin
        driver.findElement(By.xpath("(//a)[17]")).click();
        bekle(2);

        // “Currency” drop down menusunden Eurozone’u secin
        WebElement ddm = driver.findElement(By.xpath("//select[@id='pc_currency']"));
        Select select = new Select(ddm);
        select.selectByVisibleText("Eurozone (euro)");

        // “amount” kutusuna bir sayi girin
        driver.findElement(By.xpath("//*[@id='pc_amount']")).sendKeys("500");

        // “US Dollars” in secilmedigini test edin
        WebElement dollarButton = driver.findElement(By.xpath("(//*[@type='radio'])[1]"));
        Assert.assertFalse(dollarButton.isSelected());

        // “Selected currency” butonunu secin
        driver.findElement(By.xpath("(//input[@type='radio'])[2]")).click();

        // “Calculate Costs” butonuna basin sonra “purchase” butonuna basin
        driver.findElement(By.xpath("//*[@id='pc_calculate_costs']")).click();
        driver.findElement(By.xpath("(//input[@type='submit'])[2]")).click();

        // “Foreign currency cash was successfully purchased.” yazisinin ciktigini kontrol edin.
        WebElement text = driver.findElement(By.xpath("//div[@id='alert_content']"));
        Assert.assertEquals("Foreign currency cash was successfully purchased.",text.getText());
    }
}

  /*

      import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class Odev3 {

    WebDriver driver;
     @Before
     public void setUp() throws Exception {
         WebDriverManager.chromedriver().setup();
         driver = new ChromeDriver();
         driver.manage().window().maximize();
         driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
         driver.get("http://zero.webappsecurity.com/");
     }

    @Test
    public void test01() throws InterruptedException {
         //2.Sign in butonuna basin
        driver.findElement(By.xpath("//button")).click();

        //3.Login kutusuna "username" yazin
       // 4.Password kutusuna "password." yazin
        //5.Sign in tusuna basin(not: navigate.Back yapınız)
        driver.findElement(By.xpath("//*[@id='user_login']")).sendKeys("username", Keys.TAB,"password",Keys.ENTER);
        Thread.sleep(2000);
        driver.navigate().back();
        //6.Online Bankingé tiklayip Pay Bills sayfasina gidin
        driver.findElement(By.xpath("(//strong)[2]")).click();
        driver.findElement(By.xpath("//*[@id='pay_bills_link']")).click();

       // 7."Purchase Foreign Currency" tusuna basin
        driver.findElement(By.xpath("(//a)[17]")).click();

        //8."Currency" drop down menusunden Eurozone'u secin
        //9."amount" kutusuna bir sayi girin
        WebElement ddm =driver.findElement(By.xpath("(//select)[3]"));
        Select select = new Select(ddm);
        ddm.sendKeys("Eurozone (euro)",Keys.TAB,"208");

        //10."US Dollars" in secilmedigini test edin
       WebElement usDolarButon=driver.findElement(By.cssSelector("input[id='pc_inDollars_true']"));
        Assert.assertTrue(!usDolarButon.isSelected());
        //Assert.assertFalse(usDolarButon.isSelected());


        //11."Selected currency" butonunu secin
       // 12."Calculate Costs" butonuna basin sonra "purchase" butonuna basin
        //"Foreign currency cash was successfully purchased." yazisinin ciktigini kontrol edin
        usDolarButon.sendKeys(Keys.ARROW_RIGHT,Keys.TAB,Keys.ENTER,Keys.TAB,Keys.ENTER);//!!!!!!!

        WebElement dogrulama= driver.findElement(By.xpath("//*[@id='alert_content']"));
        Assert.assertEquals("Foreign currency cash was successfully purchased.",dogrulama.getText());


    }

    @After
    public void tearDown() throws Exception {
        driver.close();
    }
}
   */


   /*

   import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class C03 {
    WebDriver driver;

    @Before
    public void before()  {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        //1.http://zero.webappsecurity.com/ Adresine gidin
        driver.get("http://zero.webappsecurity.com/");
    }

    @Test
    public void test01() {

       //2.Sign in butonuna basin
        driver.findElement(By.cssSelector("button[id='signin_button']")).click();
       //3.Login kutusuna “username” yazin
        driver.findElement(By.cssSelector("input#user_login")).sendKeys("username");
       //4.Password kutusuna “password.” yazin
        driver.findElement(By.cssSelector("#user_password")).sendKeys("password");
       //5.Sign in tusuna basin(not: navigate.Back yapınız)
        driver.findElement(By.xpath("//input[@type='submit']")).click();
        driver.navigate().back();
        driver.navigate().refresh();
       //6.Pay Bills sayfasina gidin
        driver.findElement(By.cssSelector("#onlineBankingMenu")).click();
        driver.findElement(By.cssSelector("#pay_bills_link")).click();
       //7.“Purchase Foreign Currency” tusuna basin
        driver.findElement(By.xpath("//a[@href='#ui-tabs-3']")).click();

       //8.“Currency” drop down menusunden Eurozone’u secin
        WebElement option= driver.findElement(By.xpath("//select[@id='pc_currency']"));
        Select select=new Select(option);
        select.selectByVisibleText("Eurozone (euro)");

       //9.“amount” kutusuna bir sayi girin
        driver.findElement(By.cssSelector("#pc_amount")).sendKeys("24");

       //10.“US Dollars” in secilmedigini test edin
        Assert.assertFalse(driver.findElement(By.cssSelector("#pc_inDollars_true")).isSelected());

       //11.“Selected currency” butonunu secin
        driver.findElement(By.cssSelector("#pc_inDollars_false")).click();

       //12.“Calculate Costs” butonuna basin sonra “purchase” butonuna basin
        driver.findElement(By.cssSelector("#pc_calculate_costs")).click();
        driver.findElement(By.xpath("(//input[@class='btn btn-primary'])[2]")).click();

       //“Foreign currency cash was successfully purchased.” yazisinin ciktigini kontrol edin
        Assert.assertTrue(driver.findElement(By.cssSelector("div#alert_content")).isDisplayed());

    }
}

    */









