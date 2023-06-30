package day08_practice;

import org.junit.Assert;
import org.junit.Test;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class C01_Files {

    @Test
    public void test01() {

        // masaustunde bir text dosyası olusturunuz
        // masaustunde text dosyasının olup olmadıgını test ediniz

        //    "C:\Users\Sinem\Desktop\Batch151.txt"

        //Assert.assertTrue(Files.exists(Paths.get("C:\Users\Sinem\Desktop\Batch151.txt")));


        // dinamik hale getirelim

        //     "C:\Users\Sinem          \Desktop\Batch151.txt"

        String farkliKisim = System.getProperty("user.home"); // Herkesin bilgisayarinda farkli olan kisimdir.
        String ortakKisim = "\\Desktop\\Batch151.txt";

        String dosyaYolu = farkliKisim + ortakKisim;

        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));


    }
}