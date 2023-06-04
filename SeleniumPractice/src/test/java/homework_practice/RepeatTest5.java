package homework_practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class RepeatTest5 {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver","src/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        // http://the-internet.herokuapp.com/add_remove_elements/ adresine gidiniz
        driver.get("http://the-internet.herokuapp.com/add_remove_elements/");

        // Add Element butonuna 100 defa basınız
        for(int i = 0; i<100; i++){
            WebElement addButton = driver.findElement(By.cssSelector("button[onclick='addElement()']"));
            addButton.click();
        }

        // 100 defa basıldığını test ediniz
        int addedElementsCount = driver.findElements(By.xpath("//button[contains(text(), 'Delete')]")).size();
        if(addedElementsCount == 100){
            System.out.println("Add Element butonuna 100 defa basildi");
        }else System.out.println("Add Element butonuna 100 defa basilmadi");

        // 90 defa delete butonuna basınız
        for (int i = 0; i < 90; i++) {
            WebElement deleteButton = driver.findElement(By.xpath("(//button[@class='added-manually'])[1]"));
            deleteButton.click();
        }

        // 90 defa basıldığını doğrulayınız
        int deletedElementsCount = driver.findElements(By.xpath("//button[contains(text(),'Delete')]")).size();
        if(deletedElementsCount == 10){
            System.out.println("Delete butonuna 90 defa basildi.");
        } else {
            System.out.println("Delete butonuna 90 defa basilmadi.");
        }

        // Sayfayı kapatınız
        driver.close();
    }
}






