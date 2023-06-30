package practiceMix2;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileDownloadTest extends TestBase {
    @Test
    public void downloadTestExist() {

        String filePath = "C:\\Users\\Sinem\\Downloads\\b10 all test cases, code.docx";
        try {
            Files.delete(Paths.get(filePath));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // https://testcenter.techproeducation.com/index.php?page=filedownload adresine gidelim.
        driver.get("https://testcenter.techproeducation.com/index.php?page=file-download");
        bekle(3);

        // b10 all test cases dosyasını indirelim
        driver.findElement(By.xpath("(//*[text()=.])[6]")).click();
        bekle(3);

        // Dosyanın başarıyla indirilip indirilmediğini test edelim
        String dosyaYolu = "C:\\Users\\Sinem\\Downloads\\b10 all test cases, code.docx";
        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));
    }
}
