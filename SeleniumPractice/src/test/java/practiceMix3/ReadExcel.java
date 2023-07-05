package practiceMix3;

import org.apache.poi.ss.usermodel.*;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ReadExcel {
    @Test
    public void readExcel() throws IOException {

        // Dosya yolunu bir String degiskene atayalim
        // FileInputStream objesi olusturup,parametre olarak dosya yolunu girelim
        // Workbook objesi olusturalim,parameter olarak fileInputStream objesini girelim
        String dosyaYolu = "src/test/java/resources/Capitals (2).xlsx";
        FileInputStream fis = new FileInputStream(dosyaYolu);
        Workbook workbook = WorkbookFactory.create(fis);

        // Worksheet objesi olusturun workbook.getSheetAt(index)
        Sheet sheet = workbook.getSheet("Sheet1");

        // Row objesi olusturun sheet.getRow(index)
        Row row = sheet.getRow(0);

        // Cell objesi olusturun row.getCell(index)
        Cell cell = row.getCell(0);
    }

    @Test
    public void readExcel2() throws IOException {

        String dosyaYolu = "src/test/java/resources/ulkeler.xlsx";
        FileInputStream fis = new FileInputStream(dosyaYolu);
        Workbook workbook = WorkbookFactory.create(fis);

        // 1. satirdaki 2.hucreye gidelim ve yazdiralim
        System.out.println("1. Satir 2. Sutun Bilgisi : " + workbook.getSheet("Sayfa1").getRow(0).getCell(1).toString());

        // 1. satirdaki 2.hucreyi bir string degiskene atayalim ve yazdiralim
        String satir1Sutun2 = workbook.getSheet("Sayfa1").getRow(0).getCell(1).toString();
        System.out.println("1. Satir 2. Sutun Bilgisi : " + satir1Sutun2);

        // 2. satir 4.cell’in afganistan’in baskenti oldugunu test edelim
        String satir2Sutun4 = workbook.getSheet("Sayfa1").getRow(1).getCell(3).toString();
        String actualCapital = satir2Sutun4;
        String expectedCapital = "Kabil";
        Assert.assertEquals(expectedCapital,actualCapital);

        // Satir sayisini bulalim
        int satirSayisi = workbook.getSheet("Sayfa1").getLastRowNum();
        System.out.println("Sayfadaki Satir Sayisi : "+satirSayisi);

        // Fiziki olarak kullanilan satir sayisini bulun
        int kullanilanSatirSayisi = workbook.getSheet("Sayfa1").getPhysicalNumberOfRows();
        System.out.println("Kullanılan Satir Sayisi : "+kullanilanSatirSayisi);

        // Ingilizce Ulke isimleri ve baskentleri bir map olarak  kaydedelim
        Map<String ,String > countryCapital = new HashMap<>();
        for (int i = 0; i <= satirSayisi ; i++) {
            String country = workbook.getSheet("Sayfa1").getRow(i).getCell(0).toString();
            String capital = workbook.getSheet("Sayfa1").getRow(i).getCell(1).toString() + ","
                    + workbook.getSheet("Sayfa1").getRow(i).getCell(2).toString() + ","
                    + workbook.getSheet("Sayfa1").getRow(i).getCell(3).toString();
            countryCapital.put(country,capital + "\n");
        }
        System.out.println(countryCapital);

/*
        // Ingilizce Ulke isimleri ve baskentleri bir map olarak  kaydedelim
        Map<String ,String > countryCapital = new HashMap<>();
        for (int i = 0; i <= satirSayisi ; i++) {
            if(workbook.getSheet("Sayfa1").getRow(i) != null){
                String country = workbook.getSheet("Sayfa1").getRow(i).getCell(0).toString();
                String capital = workbook.getSheet("Sayfa1").getRow(i).getCell(1).toString() + ","
                        + workbook.getSheet("Sayfa1").getRow(i).getCell(2).toString() + ","
                        + workbook.getSheet("Sayfa1").getRow(i).getCell(3).toString();
                countryCapital.put(country,capital + "\n");
            }
        }
        System.out.println(countryCapital);

  */

    }
}











