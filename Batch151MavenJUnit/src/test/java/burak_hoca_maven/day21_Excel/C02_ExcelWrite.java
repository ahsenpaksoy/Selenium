package burak_hoca_maven.day21_Excel;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class C02_ExcelWrite {
    //web sayfasina gitmedigimiz icin extends yapmadik
    @Test
    public void ExcelWriteTest1() throws IOException {

        // Bir "Nufus" sutunu olusturun
        // baskent nufuslarini excel dosyasina yaziniz.
        // (D.C.:1100, Paris:1500, London:1200, Ankara:1300)

        String dosyaYolu = "src/test/java/resources/Capitals (2).xlsx";
        FileInputStream fis = new FileInputStream(dosyaYolu);
        // capitals dosyasını bizim sistemimize getirdik.

        Workbook workbook = WorkbookFactory.create(fis);
        // dosyayı workbook'a atadık.

        workbook.getSheet("Sheet1").getRow(0).createCell(2).setCellValue("NUFUS");
        workbook.getSheet("Sheet1").getRow(1).createCell(2).setCellValue("1100");
        workbook.getSheet("Sheet1").getRow(2).createCell(2).setCellValue("1500");
        workbook.getSheet("Sheet1").getRow(3).createCell(2).setCellValue(1200);
        workbook.getSheet("Sheet1").getRow(4).createCell(2).setCellValue(1300);

        // Excel'de bir hucre olusturmak icin createCell() methodu kullanilir.
        // hucre icine yazdiracagimiz deger icin setCellValue() methodu kullanilir.

        FileOutputStream fos = new FileOutputStream(dosyaYolu);
        // datalari bizim class'imizdan Capitals dosyasina gonderecegiz.

        workbook.write(fos);
        // workbook'taki datalari fos'a yazdik.

    }
}

//önce excel dosyasinda degisiklik yapiyoruz sonra capitals dosyasina ekleme yapiyoruz, datalari classimizdan
//capitals dosyasina fos gönderir. workbooktan fos a yaz diyoruz. ondan ddolayi son eklemeleri fos un üstüne yaptik.
//indirilenler klasöründeki excelde degisiklikler görünmüyor . sadece resources'taki excell'de görebiliyoruz.
