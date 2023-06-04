package homework_practice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class RepeatTest {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver","src/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        //Youtube web sayfasına gidin ve sayfa başlığının “youtube” olup olmadığını doğrulayın  (verify), eğer
        // değilse doğru başlığı(Actual Title) konsolda yazdirin.
        driver.get("https://youtube.com");
        Thread.sleep(2000);
        String actualTitle = driver.getTitle();
        String expectedTitle = "youtube";
        if(actualTitle.equals(expectedTitle)){
            System.out.println("Test PASSED");
        }else{
            System.out.println("Test FAILED \nActual Title : " + actualTitle);
        }

        //Sayfa URL'sinin “youtube” içerip içermediğini (contains) doğrulayın, içermiyorsa doğru  URL'yi yazdırın.
        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = "youtube";
        if(actualUrl.contains(expectedUrl)){
            System.out.println("Test PASSED");
        }else{
            System.out.println("Test FAILED \nactualUrl : " + actualUrl);
        }

        //Daha sonra Amazon sayfasina gidin https://www.amazon.com/
        driver.get("https://www.amazon.com/");
        Thread.sleep(2000);

        //Youtube sayfasina geri donun
        driver.navigate().back();
        Thread.sleep(2000);

        //Sayfayi yenileyin
        driver.navigate().refresh();
        Thread.sleep(2000);

        //Amazon sayfasina donun
        driver.navigate().forward();
        Thread.sleep(2000);

        //Sayfayi tamsayfa yapin
        driver.manage().window().fullscreen();
        Thread.sleep(2000);

        //Ardından sayfa başlığının "Amazon" içerip içermediğini (contains) doğrulayın, Yoksa  doğru
        // başlığı(Actual Title) yazdırın.
        String actlTitle = driver.getTitle();
        String expctdTitle = "Amazon";
        if(actlTitle.contains(expctdTitle)){
            System.out.println("Test PASSED");
        }else{
            System.out.println("Test FAILED \nActual Title : " + actualTitle);
        }

        //Sayfa URL'sinin https://www.amazon.com/ olup olmadığını doğrulayın, degilse doğru URL'yi yazdırın
        String actlUrl = driver.getCurrentUrl();
        String exptdUrl = "https://www.amazon.com/";
        if(actlUrl.equals(exptdUrl)){
            System.out.println("Test PASSED");
        }else{
            System.out.println("Test FAILED \nActual Url : " + actlUrl);
        }

        //Sayfayi kapatin
        driver.close();


    }
}
