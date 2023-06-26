package burak_hoca_maven.day20_WebTables_Excel;

import org.apache.poi.ss.usermodel.*;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C02_ExcelRead {
    @Test
    public void excelReadTest1() throws IOException {

        // excel dosyasindan veri okuyabilmemiz icin;
        // 1- dosya yolunu aliriz
          String dosyaYolu = "src/test/java/resources/Capitals (2).xlsx";

        // 2- Capitals dosyasini bizim sistemimize getirmeliyiz.Dosyayi okuyabilmek icin akisa almaliyiz.
        FileInputStream fis = new FileInputStream(dosyaYolu);

        // 3- Dosyayi workbook'a atamaliyiz. Java ortaminda bir excel dosyasi olusturmaliyiz.
        Workbook workbook = WorkbookFactory.create(fis);

        // 4- Sayfayi (sheet) secmeliyiz.
        Sheet sheet = workbook.getSheet("Sheet1");

        // 5- Satiri (row) secmeliyiz.
        Row row = sheet.getRow(0);  // 1.satir , index 0 dan baslar.

        // 6- Hucreyi (cell) secmeliyiz.
        Cell cell = row.getCell(0);  // 1.sutun , index 0 dan baslar.
    }
    @Test
    public void readExcelTest2() throws IOException {
        // KISA YONTEM

        // 1. satir 1. sutundaki bilgiyi yazdiriniz.
        String dosyaYolu = "src/test/java/resources/Capitals (2).xlsx";
        FileInputStream fis = new FileInputStream(dosyaYolu);
        Workbook workbook = WorkbookFactory.create(fis);

        String satir1Sutun1 = workbook.getSheet("Sheet1").getRow(0).getCell(0).toString();
        System.out.println(satir1Sutun1);
    }

    @Test
    public void readExcelTest3() throws IOException {

        // 1. satir 2. sutundaki hucreyi yazdirin.
        String dosyaYolu = "src/test/java/resources/Capitals (2).xlsx";
        FileInputStream fis = new FileInputStream(dosyaYolu);
        Workbook workbook = WorkbookFactory.create(fis);

        String satir1Sutun2 = workbook.getSheet("Sheet1").getRow(0).getCell(1).toString();
        System.out.println(satir1Sutun2);

    }
}

  // Excel dosyalarinda index 0 dan baslar.





