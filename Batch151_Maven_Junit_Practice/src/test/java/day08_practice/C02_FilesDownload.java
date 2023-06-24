package day08_practice;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

public class C02_FilesDownload extends TestBase {
    @Test
    public void test01() throws InterruptedException {

        // 'https://the-internet.herokuapp.com/download' adresine gidiniz
        driver.get("https://the-internet.herokuapp.com/download");
       Thread.sleep(3);

        // some-file.txt dosyasini indirelim
        File silinecekDosya = new File("C:\\Users\\Sinem\\Downloads\\some-file.txt");
        silinecekDosya.delete();

        driver.findElement(By.xpath("//a[text()='some-file.txt']")).click();
        Thread.sleep(3);

        // dosyanin bilgisayarınızda Downloads(indirilenler)'a basariyla indirilip indirilmedigini test ediniz

        //  "C:\Users\Sinem\Downloads\some-file.txt"

        Assert.assertTrue(Files.exists(Paths.get("C:\\Users\\Sinem\\Downloads\\some-file.txt")));

        //daha dinamik hale getirelim
        String farkliKisim = System.getProperty("user.home");
        String ortakKisim = "\\Downloads\\some-file.txt";
        String dosyaYolu = farkliKisim + ortakKisim;

        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));



    }

}
