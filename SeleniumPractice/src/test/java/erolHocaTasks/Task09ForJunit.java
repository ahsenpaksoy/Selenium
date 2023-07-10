package erolHocaTasks;

import utilities.TestBase;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.MoveTargetOutOfBoundsException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.Set;

public class Task09ForJunit extends TestBase {
    //https://www.selenium.dev/downloads/ adresine gidelim
    //Sayfanın resmini alalım
    //Platforms Supported by Selenium altındaki Browsers bölümü görünene kadar sayfayı indirelim
    //Browser bölümünden Chrome driver bölümündeki documentation linkine tıklıyalım
    //Documentation webelementinin resmini alalım
    //All versions available in Downloads altında Latest stable release olan linki tıklayalım
    //Açılan pencerede chromedriver'i indirelim
    //Driver'in indiğini doğrulayalım
    //İndirmiş olduğumuz dosyayı silelim
    //Silindiğini doğrulayalım
    //Not: Bu task'in her adımı için Html rapor oluşturalım(Extent Report)

    WebDriver driver;

    Actions actions;

    @BeforeClass
    public void beforeClass() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }

    @Test
    public void test01() throws IOException, InterruptedException {
        extentReport("Chrome", "Selenium DEv Testi");
        extentTest = extentReports.createTest("ExtentReport", "Test Raporu");

        //https://www.selenium.dev/downloads/ adresine gidelim
        driver.get("https://www.selenium.dev/downloads/");
        extentTest.info("sayfaya gidildi");

        //Sayfanın resmini alalım
        tumSayfaResmi();
        extentTest.info("tum sayfa resmi alindi");

        //Platforms Supported by Selenium altındaki Browsers bölümü görünene kadar sayfayı indirelim
        actions = new Actions(driver);

        boolean flag = true;
        int sayac = 0;

        while (flag) {
            try {
                WebElement element = driver.findElement(By.xpath("(//button[contains(@class, 'btn-dark')])[1]"));
                actions.moveToElement(element).perform();
                flag = false;

            } catch (MoveTargetOutOfBoundsException e) {
                sayac++;
                System.out.println("Kaydiriliyor :" + sayac);
                actions.sendKeys(Keys.PAGE_DOWN).perform();
                Thread.sleep(1000);

            } catch (NoSuchElementException e) {
                sayac++;
                System.out.println("Kaydiriliyor :" + sayac);
                System.out.println("Kaydiriliyor.");
                actions.sendKeys(Keys.PAGE_DOWN).perform();
                Thread.sleep(1000);

            }
        }
        extentTest.info("Platforms Supported by Selenium altındaki Browsers bölümü görünene kadar sayfa indirildi");
        Thread.sleep(1000);

        //Browser bölümünden Chrome driver bölümündeki documentation linkine tıklıyalım
        driver.findElement(By.xpath("(//*[@class='fas fa-plus show-collapsed pe-2'])[1]")).click();
        Thread.sleep(1000);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Thread.sleep(1000);
        extentTest.info("Browser bölümünden Chrome driver bölümündeki documentation linkine tiklandi");

        //Documentation webelementinin resmini alalım
        WebElement documentationWE = driver.findElement(By.xpath("(//*[text()='documentation'])[5]"));
        webElementResmi(documentationWE);
        documentationWE.click();
        extentTest.info("Documentation webelementinin resmi alindi");

        //All versions available in Downloads altında Latest stable release olan linki tıklayalım
        driver.findElement(By.xpath("(//a[@href='/downloads'])[4]")).click();
        extentTest.info("All versions available in Downloads altında Latest stable release olan linki tiklatildi");

        //Açılan pencerede chromedriver'i indirelim
        String sayfa1Handle = driver.getWindowHandle();
        driver.findElement(By.xpath("//*[text()='ChromeDriver 114.0.5735.90']")).click();

        //yeni sekmeye gecildi
        Set<String> windowHandles = driver.getWindowHandles();
        String sayfa2Handle = "";

        for (String w : windowHandles) {
            if (!w.equals(sayfa1Handle))
                sayfa2Handle = w;
        }
        driver.switchTo().window(sayfa2Handle);
        WebElement link = driver.findElement(By.xpath("//tbody//tr[7]//td[2]"));

        link.click();
        extentTest.info("Açılan pencerede chromedriver indirildi");

        //Driver'in indiğini doğrulayalım
        String dosyaYolu = "C:\\Users\\livde\\Downloads";

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(Files.exists(Paths.get(dosyaYolu)));
        extentTest.info("Driver indigi dogrulandi.");

        bekle(2);
        String dosyaYoluSilinecek = "C:\\Users\\livde\\Downloads\\chromedriver_win32.zip";
        Files.delete(Paths.get(dosyaYoluSilinecek));

        //Silindiğini doğrulayalım
        softAssert.assertTrue(Files.notExists(Path.of(dosyaYoluSilinecek)));
        extentTest.info("Dosyanin silindigi dogrulandi");
        //Not: Bu task'in her adımı için Html rapor oluşturalım(Extent Report)
        extentReports.flush();

    }

}
