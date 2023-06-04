package homework_practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class RepeatTest4 {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver","src/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        //https://www.amazon.com/ adresine gidin
        driver.get("https://www.amazon.com/");
        Thread.sleep(2000);

        //Browseri tam sayfa yapin
        driver.manage().window().fullscreen();
        Thread.sleep(2000);

        //Sayfayi “refresh” yapin
        driver.navigate().refresh();
        Thread.sleep(2000);

        //Sayfa basliginin “Spend less” ifadesi icerdigini test edin
        String actualTitle = driver.getTitle();
        String expextedTitle = "Spend less";
        if(actualTitle.contains(expextedTitle)){
            System.out.println("Test PASSED");
        }else System.out.println("Test FAILED");

        //Gift Cards sekmesine basin
        driver.findElement(By.xpath("//a[text()='Gift Cards']")).click();
        Thread.sleep(2000);

        //Birthday butonuna basin
        driver.findElement(By.xpath("(//img[@alt='Birthday'])[1]")).click();
        Thread.sleep(2000);

        //Best Seller bolumunden ilk urunu tiklayin
        driver.findElement(By.xpath("//*[@alt='Amazon.com eGift Card']")).click();
        Thread.sleep(2000);

        //Gift card details’den 25 $’i secin
        WebElement actualAmount = driver.findElement(By.xpath("//button[@id='gc-mini-picker-amount-1']"));
        actualAmount.click();
        System.out.println(actualAmount.getText());
        Thread.sleep(2000);

        //Urun ucretinin 25$ oldugunu test edin
        if(actualAmount.getText().equals("$25")){
            System.out.println("Test PASSED");
        }else System.out.println("Test FAILED");

        //Sayfayi kapatin
        driver.close();
    }
}





