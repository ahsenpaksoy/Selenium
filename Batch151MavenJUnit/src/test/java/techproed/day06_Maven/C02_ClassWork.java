package techproed.day06_Maven;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_ClassWork {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));


        //1.http://zero.webappsecurity.com sayfasina gidin
        driver.get("http://zero.webappsecurity.com");
        Thread.sleep(2000);

        //2.Signin buttonuna tiklayin
        driver.findElement(By.xpath("//button[@id='signin_button']")).click();
        Thread.sleep(2000);

        //3.Login alanina "username" yazdirin
        WebElement login = driver.findElement(By.xpath("//*[@id='user_login']"));
        login.sendKeys("username");
        Thread.sleep(2000);

        //4.Password alanine "password" yazdirin
        WebElement password = driver.findElement(By.xpath("//*[@type='password']"));
        password.sendKeys("password");
        Thread.sleep(2000);

        //5.Sign in buttonuna tiklayin
        WebElement signIn = driver.findElement(By.xpath("//input[@type='submit']"));
        signIn.click();
        Thread.sleep(2000);

        // Güvenlik problemini gecmek icin sayfada bir geri gelin
        driver.navigate().back();
        Thread.sleep(2000);

        //6.Online Banking altinda Pay Bills sayfasina gidin
        driver.findElement(By.xpath("(//*[text()='Online Banking'])[1]")).click();
        driver.findElement(By.xpath("//*[@id='pay_bills_link']")).click();
        Thread.sleep(3000);

        //7.amount kismina yatirmak istediginiz herhangi bir miktari yazin
        WebElement amount = driver.findElement(By.xpath("//*[@id='sp_amount']"));
        amount.sendKeys("500", Keys.TAB, "2020-09-10");
        Thread.sleep(3000);

        //8.tarih kismina "2020-09-10" yazdirin
       // WebElement date = driver.findElement(By.xpath("//*[@id='sp_date']"));
        //date.sendKeys("2020-09-10");

        //9.Pay buttonuna tiklayin
        driver.findElement(By.xpath("//input[@id='pay_saved_payees']")).click();
        Thread.sleep(2000);

        //10."The payment was successfully submitted." mesajinin ciktigini control edin
        WebElement mesaj = driver.findElement(By.xpath("//span[@title='$ 500 payed to payee sprint']"));
        if(mesaj.isDisplayed()){
            System.out.println("Test PASSED");
        }else System.out.println("Test Failed");
        Thread.sleep(2000);

        // Sayfayi kapatın
        driver.close();


    }
}
