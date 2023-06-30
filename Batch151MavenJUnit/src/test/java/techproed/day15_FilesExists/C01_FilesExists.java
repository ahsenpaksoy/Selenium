package techproed.day15_FilesExists;

import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class C01_FilesExists {
    @Test
    public void test01() {

        /*
         Bir web sitesini test ettiğimizde download işlemi yapıldığı zaman dosyanın bilgisayarımıza inip inmediğini
    kontrol etmek varlığını doğrulamak için yada bilgisayarımızdaki herhangi bir dosyanın varlığını doğrulayabilmek
    için;
        Files class'ından exists() methodunu kullanarak parametre olarak Paths.get(dosyaYolu) methodunu kullanarak
    dosyanın varlığını test edebiliriz. --> Files.exists(Paths.get(dosyaYolu)
    Dolayısıyla bu işleme başlamadan önce varlığını test edeceğimiz dosyanın yolunu String bir değişkene
    assing ederiz.
         */
        String dosyaYolu = "C:/Users/Sinem/Desktop/a.txt";
        System.out.println(Files.exists(Paths.get(dosyaYolu))); // Dosya varsa "True" yoksa "False" doner
        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));
    }

    @Test
    public void test02() {

        String dosyaYolu = "C:/Users/Sinem/Desktop/notes.txt"; //"C" den once ve en sondaki cift tirnaktan once /" olmayacak
        System.out.println(Files.exists(Paths.get(dosyaYolu))); // Dosya varsa "True" yoksa "False" doner
        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));

    }



    @Test
    public void test03() throws InterruptedException {
        /*
        Bir server'da farkli işletim sistemleri ile aynı anda dosya varlığını test etmek istediğimiz zaman,
    daha dinamik olması açısından System.getProperty("os.name") bu şekilde işletim sistemi alır
    her işletim sistemin kullanıcı yolu farklı olacağından System.getProperty("user.home")
    bilgisayarımızdaki kullanıcı yolunu bu şekilde String bir değişkene farklıYol ismiyle System.getProperty("user.home")
    atayarak herseferinde farklı yolları almayla uğraşmamış oluruz. Dosya diyelimki masaüstünde ve her işletim
    sisteminde bize aynı yolu vereceği için bunuda ortakYol olarak bir String'e assing ederiz

         */
        // Dosya yolumuz -> "C:/Users/Sinem/Desktop/a.txt";
        String farkliYol = "";
        String isletimSistemiAdi = System.getProperty("os.name"); // isletim sisteminin adini verir
        System.out.println(isletimSistemiAdi);
        System.out.println(System.getProperty("user.home")); // Bilgisayarimizdaki kullanici yolunu verir
        if(isletimSistemiAdi.contains("Win")){
            farkliYol = System.getProperty("user.home"); // Windows 11/ -> \Users\Sinem
        }else if(isletimSistemiAdi.contains("mac")){
            farkliYol = "/Users/aycapolatkamali"; // Mac isletim sistemi yolu
        }
        String ortakYol = "/Desktop/a.txt";
        String dosyaYolu = farkliYol+ortakYol;
        System.out.println(Paths.get(dosyaYolu));
        System.out.println(Files.exists(Paths.get(dosyaYolu)));
        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));

        try {
            Files.delete(Paths.get(dosyaYolu)); // Bu sekilde belirtmis oldugumuz dosyayi sileriz
        } catch (IOException e) {
            System.out.println("Dosya bulunamadi");
        }
        Assert.assertFalse(Files.exists(Paths.get(dosyaYolu))); // Sildigimiz icin assertFalse kullandik



        Thread.sleep(3000);
        //Sildigimiz dosya isminde yeni bir dosya olusturalim
        try {
            Files.createFile(Paths.get(dosyaYolu)); // Belirtmis oldugumuz dosyayi olusturduk
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));
        /*
             Her seferinde test ettiğimiz sayfada download işlemi yapılıyorsa gereksiz dosya kalabalığını önlemek için
        yukardaki delete işlemini kullanabiliriz
         */

    }

    @Test
    public void test04() {
        /*
            Yukarıdaki methodlarda bilgisayarımızdaki dosya yolunun varlığını Files.exists()methoduyla test etmiştik
        Aynı işlemi aşağıdaki örnekteki gibi File class'ından obje oluşturarak da yapabiliriz.
         */

        String dosyaYolu = "C:/Users/Sinem/Desktop/a.txt";
        File file = new File(dosyaYolu);
        System.out.println(file.exists());
        Assert.assertTrue(file.exists());
        file.delete();


    }


}







