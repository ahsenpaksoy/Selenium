package homework_practice;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class RepeatTest3 {
    public static void main(String[] args) throws InterruptedException {

        //By qa_page_career_title = By.xpath("//a[normalize-space()='Career Opportunities In QA']");

        System.setProperty("webdriver.chrome.driver","src/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        //Techproeducation sayfasına gidelim
        driver.get("https://techproeducation.com");
        Thread.sleep(2000);

        //Çıkan reklamı locate edip kapatalım
        driver.findElement(By.xpath("//i[@class='eicon-close']")).click();

        //Arama bölümünde qa aratalım
        driver.findElement(By.xpath("//*[@id='elementor-search-form-9f26725']")).sendKeys("qa", Keys.ENTER);
        Thread.sleep(2000);

        //Sayfa başlığının qa içerdiğini doğrulayalım
        String actualTitle = driver.getTitle();
        String expectedTitle = "qa";
        if(actualTitle.contains(expectedTitle)){
            System.out.println("Test PASSED");
        }else System.out.println("Test FAILED");

        //Carrer Opportunities In QA linkinin görünür ve erişilebilir olduğunu doğrulayalım
        //driver.findElement(qa_page_career_title);
        WebElement carOprElement = driver.findElement(By.xpath("//a[normalize-space()='Career Opportunities In QA']"));
        if(carOprElement.isDisplayed()){
            System.out.println("Carrer Opportunities In QA linki gorunur");
        }else System.out.println("Carrer Opportunities In QA linki gorunur degil");

        if(carOprElement.isEnabled()){
            System.out.println("Carrer Opportunities In QA linki erisilebilir");
        }else System.out.println("Carrer Opportunities In QA linki erisilebilir degil");


        //Carrer Opportunities In QA linkine tıklayalım
        carOprElement.click();
        Thread.sleep(3000);

        //Başlığın Opportunities içerdiğini test edelim
        String actlTitle = driver.getTitle();
        String expctdTitle = "Opportunities";
        if(actlTitle.contains(expctdTitle)){
            System.out.println("Test PASSED");
        }else System.out.println("Test FAILED");

        //driver.findElement(By.xpath("//*[@class='siqico-close']")).click();

        //Tekrar anasayfaya dönelim ve url'in https://techproeducation.com/ olduğunu doğrulayalım
        driver.navigate().back();
        Thread.sleep(3000);

        driver.navigate().back();
        Thread.sleep(3000);

        driver.close();



    }
}
