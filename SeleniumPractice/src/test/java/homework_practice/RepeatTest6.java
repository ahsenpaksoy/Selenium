package homework_practice;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class RepeatTest6 {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver","src/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        //2- https://www.google.com/ adresine gidin
        driver.get("https://www.google.com/");
        Thread.sleep(2000);

        //3- cookies uyarisini kabul ederek kapatin
        driver.findElement(By.xpath("(//div[@class='QS5gu sy4vM'])[2]")).click();

        //  4. Sayfa basliginin "Google" ifadesi icerdigini test edin
        String actualTitle = driver.getTitle();
        String expectedTitle = "Google";
        if(actualTitle.contains(expectedTitle)){
            System.out.println("Test PASSED");
        }else System.out.println("Test FAILED");

        //    5. Arama cubuguna "Nutella" yazip aratin
        WebElement searchBox = driver.findElement(By.xpath("//*[@class='gLFyf']"));
        searchBox.sendKeys("Nutella");
        searchBox.submit();
        Thread.sleep(2000);

        //  6. Bulunan sonuc sayisini yazdirin
        WebElement sonucYazisi = driver.findElement(By.xpath("//*[@id='result-stats']"));
        String sonucSayisi = sonucYazisi.getText().split(" ")[1].replace(".","");
        System.out.println("Sonuc Sayisi = " + sonucSayisi);
        int sayi = Integer.parseInt(sonucSayisi);

        //7. sonuc sayisinin 10 milyon'dan fazla oldugunu test edin
        if (sayi > 100000000) {
            System.out.println("Sonuc sayisi 10 milyondan fazla");
        }else {
            System.out.println("Sonuc sayisi 10 milyondan az veya esit");
        }

        //8. Sayfayi kapatin
        Thread.sleep(1000);
        driver.close();











    }
}









