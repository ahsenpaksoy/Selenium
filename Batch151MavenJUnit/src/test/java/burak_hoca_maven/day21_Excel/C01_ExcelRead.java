package burak_hoca_maven.day21_Excel;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class C01_ExcelRead {
    @Test
    public void readExcelTest1() throws IOException {

        // 3. satir 1. sutun degerini yazdirin ve "France" oldugunu test edin.

        // Excel dosyasindan veri okuyabilmemiz icin;
        // 1- Dosya yolunu aliriz.
        String dosyaYolu = "src/test/java/resources/Capitals (2).xlsx";

        // 2- Capitals dosyasini bizim sistemimize getirmeliyiz.Dosyayi okuyabilmek icin akisa almaliyit.
        FileInputStream fis = new FileInputStream(dosyaYolu);

        // 3- Dosyayi workbook'a atamaliyiz. Java ortaminda bir excel dosyasi olusturmaliyiz.
        Workbook workbook = WorkbookFactory.create(fis);

        String satir3Sutun1 = workbook.getSheet("Sheet1").getRow(2).getCell(0).toString();
        System.out.println("satir3Sutun1 = " + satir3Sutun1);
        Assert.assertEquals("France",satir3Sutun1);


        // Son satir sayisini bulunuz.
        int sonSatirSayisi = workbook.getSheet("Sheet1").getLastRowNum();  // son satiri index olarak veriyor
        // index excel de 0 dan basladigi icin son satir sayisi +1 ile 11 oluyor.
        System.out.println("sonSatirSayisi = " + sonSatirSayisi);

        // excel tablosundaki son satir sayisini getLastRowNum() methodu ile alabiliriz
        // (index olarak verir)

        // Kullanilan satir sayisini bulunuz
        int kullanilanSatirSayisi = workbook.getSheet("Sheet1").getPhysicalNumberOfRows();
        System.out.println("kullanilanSatirSayisi = " + kullanilanSatirSayisi);
        // excel tablosundaki kullanilan satir sayisini getPhysicalNumberOfRows() methodu ile alabiliriz.
        // (index olarak vermez) 1 den baslar.
    }

    @Test
    public void readExcelTest2() throws IOException {
        // Capitals dosyasindaki verileri yazdiriniz
        Map<String,String> capitalsMap = new HashMap<>();
        //Capitals dosyasındaki tüm verileri koyabilecegimiz en uygun java objesi map'dir.
        //Key VAlue rastgele geliyor.  Sebebi:
        //Biz Map'i HashMap olarak olusturduk. HashMap rastgele siralama yapar, bu nedenle de cok hizlidir.

        String dosyaYolu = "src/test/java/resources/Capitals (2).xlsx";
        FileInputStream fis = new FileInputStream(dosyaYolu);
        Workbook workbook = WorkbookFactory.create(fis);

        int sonSatirSayisi = workbook.getSheet("Sheet1").getLastRowNum();
        //for loop son satir sayisinda durmali bu sebeple önce son satir sayisini bulmaliyiz
        for (int i = 0; i <= sonSatirSayisi; i++) {
            String key = workbook.getSheet("Sheet1").getRow(i).getCell(0).toString();
            String value = workbook.getSheet("Sheet1").getRow(i).getCell(1).toString();
            capitalsMap.put(key,value);
            //System.out.println(key+"/"+value);
        }
        System.out.println(capitalsMap);

    }
}

