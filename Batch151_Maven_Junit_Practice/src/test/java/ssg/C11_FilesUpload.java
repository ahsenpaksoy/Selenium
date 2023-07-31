package ssg;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C11_FilesUpload extends TestBase {

        // masaustunde bir deneme dosyası olusturun. İcine Merhaba Dunya yazınız.
        // 'https://cgi-lib.berkeley.edu/ex/fup.html' adresine gidiniz
        // 'Notes about the file' kısmına 'Benim Dosyam' notunu yazınız.
        // 'Dosya Seç' kısmına deneme dosyasını yükleyiniz.
        // 'Press' butonuna basın
        // Dosya notunun 'Benim Dosyam' oldugunu test ediniz
        // Dosya iceriginin 'Merhaba Dunya' icerdigini test ediniz.

    @Test
    public void test01() throws InterruptedException {

        // masaustunde bir deneme dosyası olusturun. İcine Merhaba Dunya yazınız.

        // 'https://cgi-lib.berkeley.edu/ex/fup.html' adresine gidiniz
        driver.get("https://cgi-lib.berkeley.edu/ex/fup.html");

        Thread.sleep(2000);

        // 'Notes about the file' kısmına 'Benim Dosyam' notunu yazınız.
        driver.findElement(By.xpath("//input[@name='note']")).sendKeys("Benim Dosyam");

        Thread.sleep(2000);

        // 'Dosya Seç' kısmına deneme dosyasını yükleyiniz.

        // "C:\Users\BURAK\Desktop\deneme.txt"

        String farkliKisim = System.getProperty("user.home");
        String  ortakKisim = "\\Desktop\\deneme.txt";

        String dosyaYolu = farkliKisim + ortakKisim;

        WebElement dosyaSec = driver.findElement(By.xpath("//input[@name='upfile']"));
        dosyaSec.sendKeys(dosyaYolu);  ///////////////////////////////////////////////

        // 'Press' butonuna basın
        driver.findElement(By.xpath("//input[@type='submit']")).click();

        // Dosya notunun 'Benim Dosyam' oldugunu test ediniz
        String dosyaNotu = driver.findElement(By.tagName("blockquote")).getText();
        Assert.assertEquals("Benim Dosyam",dosyaNotu);

        // Dosya iceriginin 'Merhaba Dunya' icerdigini test ediniz.
        String dosyaIcerigi = driver.findElement(By.tagName("pre")).getText();
        Assert.assertTrue(dosyaIcerigi.contains("Merhaba Dunya"));

    }
}