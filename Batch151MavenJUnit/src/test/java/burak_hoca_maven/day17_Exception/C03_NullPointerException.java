package burak_hoca_maven.day17_Exception;

import com.github.javafaker.Faker;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import techproed.utilities.TestBase;

public class C03_NullPointerException {

    /*
         NullPointerException:

    degisken yada obje olusturup bu degiskene atama yapmadıgımızda yada esitlemedigimizde
    NullPointerException hatası alırız.
 */

    WebDriver driver;
    Faker faker;
    Actions actions;
    Integer sayi;
    String isim;

    @Test
    public void NullPointerException() {

        // driver = new ChromeDriver(); atamasini yapmadigimiz icin NullPointerException hatasini aldik.
        driver.get("https://amazon.com");
        
    }

    @Test
    public void NullPointerExceptionTest2() {
        // faker = new Faker(); atamasini yapmadigimiz icin NullPointerException hatasi aldik.

        System.out.println(faker.name().firstName());
    }

    @Test
    public void NullPointerExceptionTest3() {
        // actions = new Actions(); atamasini yapmadigimiz icin NullPointerException hatasini aldik.
        actions.doubleClick().perform();
    }

    @Test
    public void NullPointerExceptionTest4() {
        // sayi = 6; sayi degiskenine atama yapmadigimiz icin NullPointerException hatasini aldik.
        System.out.println(sayi+5);
    }

    @Test
    public void NullPointerExceptionTest5() {
        // isim = "Ahsen"; isim degiskenine atama yapmadigimiz icin NullPointerException hatasini aldik.
        System.out.println(isim.charAt(0));
    }


}






