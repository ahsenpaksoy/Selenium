package practiceMix2;

import org.junit.Assert;
import org.junit.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

public class FileExistTest {
    @Test
    public void isExist() {
        // Masa ustunden bir dosyanın varligini test et

        //C:\Users\Sinem\Desktop\notes.txt
        String farkliKisim = System.getProperty("user.home");
        String ortakKisim = "\\Desktop\\notes.txt";
        String dosyaYolu = farkliKisim + ortakKisim;

        System.out.println(Files.exists(Paths.get(dosyaYolu)));
        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));
    }
}
