package techproed.tests.day25_POM;

import org.testng.annotations.Test;
import techproed.utilities.Driver;

public class C01_DriverTest {

    @Test
    public void testName() {
        Driver.getDriver().get("https://amazon.com");
        Driver.closeDriver();
    }

    @Test
    public void test01() {
        Driver.getDriver().get("https://amazon.com");
        Driver.getDriver().get("https://youtube.com");
        Driver.getDriver().get("https://facebook.com");
        Driver.quitDriver();
        /*
        Bu methodda driver'i if blogu icine almadigimizdan dolayi her sayfa icin
        yeni bir driver actiginin ornegini gosterdik.
         */
    }

    @Test
    public void test02() {
        Driver.getDriver().get("https://amazon.com");
        Driver.getDriver().get("https://youtube.com");
        Driver.closeDriver();
        Driver.getDriver().get("https://facebook.com");
    }

    @Test
    public void test03() {

        //Driver driver = new Driver();  // Driver class'in gizli constructor'indan object olusturuldu
        //driver.getDriver().get("https://amazon.com");

        /*
        Bu ornekte Driver class'indan singleton pattern kullanarak obje olusturmanin onune gecmis olduk.
         */
    }






}













