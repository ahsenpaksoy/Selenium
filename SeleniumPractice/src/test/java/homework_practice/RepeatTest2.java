package homework_practice;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class RepeatTest2 {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver","src/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        //https://id.heroku.com/login sayfasina gidin
        driver.get("https://id.heroku.com/login");
        Thread.sleep(2000);

        //Bir mail adersi giriniz
        WebElement addEmail = driver.findElement(By.xpath("//*[@id='email']"));
        addEmail.sendKeys("alican@gmail.com");
        Thread.sleep(2000);

        //Bir password giriniz
        WebElement addPassword = driver.findElement(By.xpath("//*[@class='form-control password']"));
        addPassword.sendKeys("12345");
        Thread.sleep(2000);

        //Login butonuna tiklayiniz
        WebElement loginButton = driver.findElement(By.xpath("//button[@name='commit']"));
        loginButton.click();

        //"There was a problem with your login." texti gorunur ise
        //"kayit yapilamadi" yazdiriniz
        WebElement loginProblemButton = driver.findElement(By.xpath("//*[@class='alert alert-danger']"));
        System.out.println(loginProblemButton.getText());
        if(loginProblemButton.isDisplayed()){
            System.out.println("Kayit yapilamadi");
        }

        //eger yazi gorunur degilse "kayit yapildi" yazdiriniz
        if(!loginProblemButton.isDisplayed()){
            System.out.println("Kayit yapildi");
        }


        //sayfayı kapatiniz
        driver.close();

    }
}
