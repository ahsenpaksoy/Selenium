package techproed.tests.day28_DataProvider;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class C01_DataProviderTest {
    /*
    Dataprovider, bir cok veriyi test caselerde loop kullanmadan aktarmak icin kullanilir.
    TestNG'den gelen bir ozelliktir. Iki boyutlu Object Array return eder.
    Kullanimi icin @Test notasyonundan sonra parametre olarak (dataprovider="method ismi") yazilir.
    Kac tane veri ile calisacaksak test methoduna o kadar parametre eklenir.
    Data driven testing(DDT) de datalarimizi 3 farkli sekilde kullanabiliriz.
       1- .properties dosyasindan datalari alabiliriz --> ConfigReader.getProperty() ile
       2- Excel dosyasindan datalari alabiliriz --> ExcelReader class'i ile
       3- DataProvider kullanarak datalari alabiliriz --> DataProvider methodu ile
       (DataProvider veri az ise)
     */

    @DataProvider(name = "test02")
    public static Object[][] isimler() {  // buraya test02 baglandigi icin artik test01 calismaz. Normalde test01 e aitti.
        return new Object[][]{             // test02 yi silersek test01 calisir.
                {"esen"},
                {"mehmet"},      //--> Bu dataProvider'i test02 methodu icin kullan anlamina gelir
                {"esma"},
                {"ali"},
                {"mert"},
                {"burcu"},
                {"yunus"}};
    }

    @DataProvider
    public static Object[][] arabalar() {
        return new Object[][]{
                {"ford"},
                {"mercedes"},
                {"volvo"},
                {"audi"}};
    }
    /*
    Olusturdugumuz dataprovider methodunu baska bir test methodunda da kullanabiliriz.
    Bunun icin @DataProvider notasyonundan sonra yeni olusturdugumuz methodun ismini (name="test02") olarak
    belirtmemiz gerekir
     */

    // ayni verileri kullanacaksak 1 dataprovider'i tum test methodlari icin kullanabiliriz
     /*
    dataProvider'i database veya excel gibi dusunebiliriz.
    Istersek 10 tane test methodu olusturup burdan istedigimiz veriyi cekip kullanabiliriz
     */

    @Test(dataProvider = "isimler")
    public void test01(String data) {
        System.out.println(data);
    }

    @Test(dataProvider = "test02")  // ayni dataProvider kullanacaksak test'i ona tanimlamamiz gerekir.
    public void test02(String isim) {
        System.out.println(isim);
    }

    @Test(dataProvider = "arabalar")
    public void test03(String arabalar) {
        System.out.println(arabalar);
    }
}
