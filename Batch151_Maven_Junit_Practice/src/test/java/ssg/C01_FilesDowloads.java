package ssg;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C01_FilesDowloads extends TestBase {

    // 'https://testpages.herokuapp.com/' adresine gidiniz
    // File Downloads kısmına tıklayınız
    // Server Download dosyasini indirelim
    // dosyanin bilgisayarınızda Downloads(indirilenler)'a basariyla indirilip indirilmedigini test ediniz


    @Test
    public void test01() throws InterruptedException {

        // 'https://testpages.herokuapp.com/' adresine gidiniz
        driver.get("https://testpages.herokuapp.com/");

        Thread.sleep(3000);

        // File Downloads kısmına tıklayınız

        driver.findElement(By.xpath("//a[@id='download']")).click();
        Thread.sleep(3000);

        // Server Download dosyasini indirelim
        driver.findElement(By.xpath("//button[@id='server-download']")).click();
        Thread.sleep(3000);

        // dosyanin bilgisayarınızda Downloads(indirilenler)'a basariyla indirilip indirilmedigini test ediniz

        //    "C:\Users\BURAK         \Downloads\textfile.txt"

        String farkliKisim = System.getProperty("user.home");
        String ortakKisim = "\\Downloads\\textfile.txt";
        String dosyaYolu = farkliKisim + ortakKisim;
        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));

    }
}