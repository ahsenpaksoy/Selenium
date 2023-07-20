package techproed.tests.day27_SmokeTest_Excel;

import org.testng.annotations.Test;
import techproed.utilities.ExcelReader;

public class C02_BlueRentalExcelTest {
    @Test
    public void test01() {

        //mysmoketestdata excel dosyasindaki 1. satir bilgilerini konsola yazdiralim
        String dosyaYolu = "src/test/java/techproed/resources/mysmoketestdata.xlsx";
        String sayfaIsmi = "customer_info";
        ExcelReader reader = new ExcelReader(dosyaYolu , sayfaIsmi);
        System.out.println("Birinci Email = "+reader.getCellData(1, 0));
        System.out.println("Birinci Password = "+reader.getCellData(1, 1));

        String email = reader.getCellData(1,0);
        String password = reader.getCellData(1,1);
        System.out.println(email +" || "+password);

    }
}

 //excel'de index 0 dan baslar