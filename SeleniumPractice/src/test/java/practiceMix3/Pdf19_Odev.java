package practiceMix3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.util.List;
public class Pdf19_Odev {

    WebDriver driver;

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test
    public void test01() {

//        1. “http://zero.webappsecurity.com/” Adresine gidin
        driver.get("http://zero.webappsecurity.com/");

//        2. Sign in butonuna basin
        driver.findElement(By.xpath("(//*[@type='button'])[1]")).click();

//        3. Login kutusuna “username” yazin
        driver.findElement(By.xpath("(//*[@id='user_login'])[1]")).sendKeys("username");

//        4. Password kutusuna “password” yazin
        driver.findElement(By.xpath("(//*[@id='user_password'])[1]")).sendKeys("password");

//        5. Sign in tusuna basin
        driver.findElement(By.xpath("(//*[@type='submit'])[1]")).click();
        driver.navigate().back();
        driver.navigate().forward();
        driver.navigate().back();

//        6. Online banking menusu icinde Pay Bills sayfasina gidin
        driver.findElement(By.xpath("(//*[@id='onlineBankingMenu'])[1]")).click();
        driver.findElement(By.xpath("(//*[@id='pay_bills_link'])[1]")).click();

//        7. “Purchase Foreign Currency” tusuna basin
        driver.findElement(By.xpath("(//*[text()='Purchase Foreign Currency'])")).click();

//        8. “Currency” drop down menusunden Eurozone’u secin
        WebElement ddmSelectaState = driver.findElement(By.xpath("//select[@id='pc_currency']"));
        Select select = new Select(ddmSelectaState);
        select.selectByVisibleText("Eurozone (euro)");

//        9. soft assert kullanarak "Eurozone (Euro)" secildigini test edin
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(ddmSelectaState.getText().contains("Eurozone (euro)"));

//        10.soft assert kullanarak DropDown listesinin su secenekleri oldugunu test
//        edin "Select One", "Australia (dollar)", "Canada (dollar)","Switzerland
//        (franc)","China (yuan)","Denmark (krone)","Eurozone (euro)","Great Britain
//        (pound)","Hong Kong (dollar)","Japan (yen)","Mexico (peso)","Norway
//                (krone)","New Zealand (dollar)","Sweden (krona)","Singapore
//                (dollar)","Thailand (baht)"
        List<WebElement> tumOptionlar = select.getOptions();

        for (WebElement each : tumOptionlar) {
            System.out.println(each.getText());
        }
        softAssert.assertTrue(tumOptionlar.contains("Select One"));
        softAssert.assertTrue(tumOptionlar.contains("Australia (dollar)"));
        softAssert.assertTrue(tumOptionlar.contains("Canada (dollar)"));
        softAssert.assertTrue(tumOptionlar.contains("Switzerland(franc)"));
        softAssert.assertTrue(tumOptionlar.contains("China (yuan)"));
        softAssert.assertTrue(tumOptionlar.contains("Denmark (krone)"));
        softAssert.assertTrue(tumOptionlar.contains("Eurozone (euro)"));
        softAssert.assertTrue(tumOptionlar.contains("Great Britain (pound)"));
        softAssert.assertTrue(tumOptionlar.contains("Hong Kong (dollar)"));
        softAssert.assertTrue(tumOptionlar.contains("Japan (yen)"));
        softAssert.assertTrue(tumOptionlar.contains("Mexico (peso)"));
        softAssert.assertTrue(tumOptionlar.contains("Norway (krone)"));
        softAssert.assertTrue(tumOptionlar.contains("New Zealand (dollar)"));
        softAssert.assertTrue(tumOptionlar.contains("Sweden (krona)"));
        softAssert.assertTrue(tumOptionlar.contains("Singapore (dollar)"));
        softAssert.assertTrue(tumOptionlar.contains("Thailand (baht))"));
    }
}

    /*
    import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class day24_homeWork_SoftAssert {

    WebDriver driver;
    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test
    public void test01() {
        //1. “http://zero.webappsecurity.com/” Adresine gidin
        driver.get("http://zero.webappsecurity.com");

        //2. Sign in butonuna basin
        driver.findElement(By.className("icon-signin")).click();

        //3. Login kutusuna “username” yazin
        //4. Password kutusuna “password” yazin
        //5. Sign in tusuna basin
        WebElement login = driver.findElement(By.xpath("//*[@type='text']"));
        login.sendKeys("username", Keys.TAB,"password",Keys.TAB,Keys.ENTER);
        driver.navigate().back();

        //6. Online banking menusu icinde Pay Bills sayfasina gidin
        driver.findElement(By.xpath("(//*[text()='Online Banking'])[1]")).click();
        driver.findElement(By.xpath("(//*[@class='headers'])[4]")).click();

        //7. “Purchase Foreign Currency” tusuna basin
        driver.findElement(By.xpath("//*[text()='Purchase Foreign Currency']")).click();

        //8. “Currency” drop down menusunden Eurozone’u secin
        WebElement ddm = driver.findElement(By.xpath("//*[@id='pc_currency']"));
        Select select = new Select(ddm);
        select.selectByValue("EUR");

        //9. soft assert kullanarak "Eurozone (Euro)" secildigini test edin
        String actual = ddm.getText();
        String expected = "Eurozone (Euro)";
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(actual, expected);

        //10.soft assert kullanarak DropDown listesinin su secenekleri oldugunu test
        //   edin "Select One", "Australia (dollar)", "Canada (dollar)","Switzerland
        //            (franc)","China (yuan)","Denmark (krone)","Eurozone (euro)","Great Britain
        //            (pound)","Hong Kong (dollar)","Japan (yen)","Mexico (peso)","Norway
        //            (krone)","New Zealand (dollar)","Sweden (krona)","Singapore
        //            (dollar)","Thailand (baht)"

        List<String> actualList = new ArrayList<>();
        select.getOptions().forEach(w->actualList.add(w.getText()));
        List<String> expectedList = List.of("Select One", "Australia (dollar)",
                "Canada (dollar)","Switzerland(franc)","China (yuan)","Denmark (krone)",
                "Eurozone (euro)","Great Britain(pound)","Hong Kong (dollar)","Japan (yen)",
                "Mexico (peso)","Norway(krone)","New Zealand (dollar)","Sweden (krona)",
                "Singapore(dollar)","Thailand (baht)");
        softAssert.assertEquals(expectedList, actualList);
    }
}
     */



    /*

    import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.util.List;

public class C01_SoftAssert {
    WebDriver driver;
    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @Test
    public void test01() {

        //1. “http://zero.webappsecurity.com/” Adresine gidin
        driver.get("http://zero.webappsecurity.com/");

        //2. Sign in butonuna basin
        driver.findElement(By.xpath("//i[@class='icon-signin']")).click();

        //3. Login kutusuna “username” yazin
        //4. Password kutusuna “password” yazin
        //5. Sign in tusuna basin
        driver.findElement(By.cssSelector("input#user_login")).sendKeys("username", Keys.TAB,"password",Keys.ENTER);
        driver.navigate().back();

        //6. Online banking menusu icinde Pay Bills sayfasina gidin
        driver.findElement(By.xpath("//*[.='Online Banking']")).click();
        driver.findElement(By.cssSelector("span#pay_bills_link")).click();

        //7. “Purchase Foreign Currency” tusuna basin
        driver.findElement(By.xpath("//a[@href='#ui-tabs-3']")).click();

        //8. “Currency” drop down menusunden Eurozone’u secin
        WebElement ddm= driver.findElement(By.cssSelector("#pc_currency"));
        Select select=new Select(ddm);
        select.selectByVisibleText("Eurozone (euro)");

        //9. soft assert kullanarak "Eurozone (Euro)" secildigini test edin
        String actual=ddm.getText();
        SoftAssert softAssert=new SoftAssert();
        softAssert.assertEquals("Eurozone (Euro)",actual);

        //10.soft assert kullanarak DropDown listesinin su secenekleri oldugunu test
        //edin "Select One", "Australia (dollar)", "Canada (dollar)","Switzerland
        //(franc)","China (yuan)","Denmark (krone)","Eurozone (euro)","Great Britain
        //(pound)","Hong Kong (dollar)","Japan (yen)","Mexico (peso)","Norway
        //(krone)","New Zealand (dollar)","Sweden (krona)","Singapore
        //(dollar)","Thailand (baht)"

        String[] ddmArray={"Select One", "Australia (dollar)", "Canada (dollar)","Switzerland (franc)","China (yuan)",
                "Denmark (krone)","Eurozone (euro)","Great Britain (pound)","Hong Kong (dollar)","Japan (yen)",
                "Mexico (peso)","Norway (krone)","New Zealand (dollar)","Sweden (krona)","Singapore (dollar)",
                "Thailand (baht)"};

        List<WebElement> ddmList=select.getOptions();

        for (String w:ddmArray) {
            for (WebElement t: ddmList) {
                softAssert.assertEquals(w,t.getText());
            }
        }

    }
}

     */






