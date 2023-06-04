package techproed.day01_IlkTest_DriverMethods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C01_IlkTest {
    public static void main(String[] args) {
        System.setProperty("chromeDriver","src/resources/drivers/chromedriver.exe"); //key - value
        //Java uygulamalarinda system ozelliklerini ayarlamak icin setProperty methodu ile kullaniriz
        //setProperty methodu ile classimiza driver'in fiziki yolunu belirtiriz.
        System.out.println(System.getProperty("chromeDriver"));
        //getProperty ile "Key" degerini girerek "value" ya ulasabilirim
        WebDriver driver = new ChromeDriver();
        //ChromeDriver turunde yeni bir obje olusturduk
        driver.get("https://techproeducation.com");  //get() method'u ile String olarak girilen url'e gideriz.
    }
}
