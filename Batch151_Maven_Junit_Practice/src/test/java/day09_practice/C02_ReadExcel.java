package day09_practice;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C02_ReadExcel {
    
    // Ulkeler dosyasindaki "Baskent (Ingilizce)" sutununu yazdirin.


    @Test
    public void test01() throws IOException {

        String dosyaYolu = "src/resources/ulkeler.xlsx";
        FileInputStream fis = new FileInputStream(dosyaYolu);
        Workbook workbook = WorkbookFactory.create(fis);

        int sonStirNumarasi = workbook.getSheet("Sayfa1").getLastRowNum();
        System.out.println(sonStirNumarasi);
        // getLastRowNum() son satir numarasini index olarak verir.

        for (int i = 0; i <= sonStirNumarasi; i++) {  // i satirlari sayiyor
            String satirdakiData = C01_ReadExcel.banaDataGetir(i,1);
            System.out.println(satirdakiData);
        }

        // instance methodu farkli classta kullanabilmek icin object olusturmaliyiz.
        //C01_ReadExcel obj = new C01_ReadExcel();
        //String satirdakiData = obj.banaDataGetir(i,1); seklinde olur.

        // static methodu farkli classta kullanabilmek icin class ismini yazmaliyiz.class ismiyle cagirmaliyiz.
        //C01_ReadExcel class'indaki methodu baska classlarda kullanabilmek icin static yapmak zorundayiz.
        // Boylece method'u class ismi ile cagirabiliriz.

        /*
        // 2. YOL
        for (int i = 0; i <= sonStirNumarasi; i++) {
            String satirdakiData = workbook.getSheet("Sayfa1").getRow(i).getCell(1).toString();
            System.out.println(satirdakiData);
        }
         */

    }
}
