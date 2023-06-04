package homework_practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class LoginTest {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "src/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        // http://a.testaddressbook.com adresine gidiniz.
        driver.get("https://www.heroku.com/home");

        //Thread.sleep(1000);


        driver.findElement(By.id("onetrust-accept-btn-handler")).click();

        Thread.sleep(3000);

        driver.findElement(By.xpath("//*[contains(text(),'Log in')]")).click();

        Thread.sleep(3000);

        driver.findElement(By.xpath("//input[@id='email']")).sendKeys("testtechproed@gmail.com");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Test1234!");
        Thread.sleep(3000);
        driver.findElement(By.xpath(" //button[normalize-space()='Log In']")).click();




        // Sign in butonuna basin


        // email textbox,password textbox, and signin button elementlerini locate ediniz..
        // Kullanıcı adını ve şifreyi aşağıya girin ve oturum aç (sign in)buttonunu tıklayın:
        // Username : testtechproed@gmail.com
        // Password : Test1234!
        // Expected user id nin testtechproed@gmail.com oldugunu dogrulayin(verify).
        //“Addresses” ve “Sign Out” textlerinin görüntülendiğini( displayed) doğrulayin(verify).

        //Sayfada kac tane link oldugunu bulun.


        Thread.sleep(3000);
        driver.close();

    }
}
