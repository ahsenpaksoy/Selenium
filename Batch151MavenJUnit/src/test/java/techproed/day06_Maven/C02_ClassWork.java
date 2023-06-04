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

        //2.Signin buttonuna tiklayin
        driver.findElement(By.xpath("//button[@id='signin_button']")).click();

        //3.Login alanine "username" yazdirin
        driver.findElement(By.xpath("//*[@id='user_login']")).sendKeys("username");

        //4.Password alanine "password" yazdirin
        driver.findElement(By.xpath("//*[@type='password']")).sendKeys("password");

        //5.Sign in buttonuna tiklayin
        driver.findElement(By.xpath("//input[@type='submit']")).click();

        //6.Online Banking altinda Pay Bills sayfasina gidin
        driver.navigate().back();
        driver.findElement(By.xpath("(//*[text()='Online Banking'])[1]")).click();
        driver.findElement(By.xpath("//*[@id='pay_bills_link']")).click();
        Thread.sleep(3000);

        //7.amount kismina yatirmak istediginiz herhangi bir miktari yazin
        WebElement amount = driver.findElement(By.xpath("//*[@id='sp_amount']"));
        amount.sendKeys("500", Keys.TAB, "2020-09-10");
        Thread.sleep(3000);

        //8.tarih kismina "2020-09-10" yazdirin
        WebElement amount1 = driver.findElement(By.xpath("//*[@id='sp_date']"));
        amount1.sendKeys("2020-09-10");

        //9.Pay buttonuna tiklayin
        driver.findElement(By.xpath("//input[@id='pay_saved_payees']")).click();

        //10."The payment was successfully submitted." mesajinin ciktigini control edin
        WebElement paymentSubmit = driver.findElement(By.xpath("//span[@title='$ 500 payed to payee sprint']"));
        if(paymentSubmit.isDisplayed()){
            System.out.println("The payment was successfully submitted mesaji gorundu");
        }else System.out.println("The payment was successfully submitted mesaji gorunmedi");



    }
}
