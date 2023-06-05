package techproed.day07_MavenUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_ClassWork {
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

        // WebElement login = driver.findElement(By.cssSelector("input#user_login"));
        // login.sendKeys("username", Keys.TAB, "password", Keys.ENTER);  -> 3,4,5 in birlikte yapilisi

        // Güvenlik problemini gecmek icin sayfada bir geri gelin
        driver.navigate().back();
        Thread.sleep(2000);

        //6.Online Banking altinda Pay Bills sayfasina gidin
        driver.findElement(By.xpath("(//*[text()='Online Banking'])[1]")).click();
        driver.findElement(By.xpath("//*[@id='pay_bills_link']")).click();
        Thread.sleep(3000);

        /*
           //6.Online Banking altında Pay Bills sayfasina gidin
            driver.findElement(By.xpath("(//*[text()=.])[11]")).click();
            (//*[text()=.])[11] Bu şekilde text ile aldığımız bir xpath'de text değişse bile biz
            o webelementi handle edebiliriz.
         */

        //driver.findElement(By.xpath("(//h4)[4]//span")).click();  -> taglarla tiklama . // ile child'a(span) direkt inebiliriz

        //7.amount kismina yatirmak istediginiz herhangi bir miktari yazin
        WebElement amount = driver.findElement(By.xpath("//*[@id='sp_amount']"));
        amount.sendKeys("500", Keys.TAB, "2020-09-10");
        Thread.sleep(3000);

        //driver.findElement(By.cssSelector("#sp_amount")).sendKeys("500",Keys.TAB,"2020-09-10",Keys.TAB,Keys.TAB,Keys.ENTER);
        //7,8,9 un birlikte yapilmis hali


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

        /*
        WebElement sonucYazisi = driver.findElement(By.xpath("(//span)[1]"));
        System.out.println(sonucYazisi.getText());
        if (sonucYazisi.getText().equals("The payment was successfully submitted.")){
            System.out.println("Test PASSED");
        }else System.out.println("Test FAILED");

        if (sonucYazisi.isDisplayed()){
            System.out.println("Test PASSED");
        }else System.out.println("Test FAILED");

         */

        // (//*[text()=.])[18]  veya  (//span)[1]  ile de locate alinabilir.

        // Sayfayi kapatın
        driver.close();

        //css'de id yerine #, class yerine . kullanilabilir.


    }
}
