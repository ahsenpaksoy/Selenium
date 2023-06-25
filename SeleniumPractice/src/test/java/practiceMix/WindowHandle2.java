package practiceMix;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

import java.util.Set;

public class WindowHandle2 extends TestBase {
    @Test
    public void test01() {

       // https://testcenter.techproeducation.com/index.php?page=multiple-windows
        driver.get("https://testcenter.techproeducation.com/index.php?page=multiple-windows");
        String sayfa1Handle = driver.getWindowHandle();
        System.out.println("SAYFA1HANDLE : " + sayfa1Handle);

        // Title in ‘Windows’ oldugunu test edin
        Assert.assertEquals(driver.getTitle(), "Windows");

        // Click here a tiklayin
        driver.findElement(By.xpath("//a[text()='Click Here']")).click();

        // Sonra açılan sayfadaki title in ‘New Window’ oldugunu dogrulayin
        Set<String> windowHandles = driver.getWindowHandles();

        String  sayfa2Handle = "";
        for(String w : windowHandles){
            if(!w.equals(sayfa1Handle)){
                sayfa2Handle = w;
            }
        }
        System.out.println("SAYFA2HANDLE : " + sayfa2Handle);

        driver.switchTo().window(sayfa2Handle);
        Assert.assertEquals("New Window", driver.getTitle());


    }
}






