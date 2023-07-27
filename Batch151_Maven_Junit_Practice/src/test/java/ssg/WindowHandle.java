package ssg;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import utilities.TestBase;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class WindowHandle extends TestBase {
    @Test
    public void WindowTest01() {

        driver.get("https://letcode.in/windows");
        WebElement button = driver.findElement(By.id("home"));
        button.click();
        String ilkPencere = driver.getWindowHandle(); // ilk pencerenin kodunu verir. ikinci pencereye gecmedik henuz
        System.out.println("Ilk Pencere Kodu : " + ilkPencere);

        Set<String> pencereSeti = driver.getWindowHandles();
        System.out.println("Tum Pencereler : " + pencereSeti);

        System.out.println("Ilk Pencere Basligi : " + driver.getTitle());

        for(String pencere : pencereSeti){
            if(!pencere.equals(ilkPencere)){
                driver.switchTo().window(pencere);
                break;
            }
        }
        System.out.println("Ikinci Pencere Basligi : " + driver.getTitle());

        driver.switchTo().window(ilkPencere);
        System.out.println("Ilk Pencere Basligi : " + driver.getTitle());
    }
    @Test
    public void windowTest02() {

        driver.get("https://letcode.in/windows");
        WebElement button = driver.findElement(By.id("home"));
        button.click();

       //Set<String> pencereler = driver.getWindowHandles();
        Iterator <String> iterator = driver.getWindowHandles().iterator();
        String ilkPencere = iterator.next();
        String ikinciPencere = iterator.next();

        System.out.println("Ilk Pencere Basligi : " + driver.getTitle());

        driver.switchTo().window(ikinciPencere);
        System.out.println("Ikinci Pencere Basligi : " + driver.getTitle());

        driver.switchTo().window(ilkPencere);
        System.out.println("Ilk Pencere Basligi : " + driver.getTitle());

    }

    @Test
    public void windowTest03() {

        driver.get("https://letcode.in/windows");
        WebElement button = driver.findElement(By.id("home"));
        button.click();

        Set<String> pencereler = driver.getWindowHandles();
        List<String> pencereList = new ArrayList<>(pencereler);
        System.out.println(pencereList);

        System.out.println("Ilk Pencere Basligi : " + driver.getTitle());

        driver.switchTo().window(pencereList.get(1));
        System.out.println("Ikinci Pencere Basligi : " + driver.getTitle());

        driver.switchTo().window(pencereList.get(0));
        System.out.println("Ilk Pencere Basligi : " + driver.getTitle());
    }
    @Test
    public void windowTesti04() {
        driver.get("https://www.kitapyurdu.com/index.php?route=account/register");
        System.out.println("Birinci Pencere Title: " + driver.getTitle());

        WebElement emailKutusu = driver.findElement(By.id("register-email"));

        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.fakemail.net/");
        WebElement fakeEmail = driver.findElement(By.id("email"));
        String eposta = fakeEmail.getText();
        
        List<String> pencereler = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(pencereler.get(0));
        emailKutusu.sendKeys(eposta);
        bekle(3);
    }




}












