package erolHocaTasks;

import org.junit.Test;
import utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Task10 extends TestBase {

        //https://www.techlistic.com/p/demo-selenium-practice.html adresine gidelim
        //Demo Table altındaki tablodaki otel bilgilerini yazdırınız
        //Demo Table altındaki otel bilgileri olan tablodan Height değeri 601m olan otelin bilgilerini yazdırınız
        //Bütün Height bilgilerini yazdırınız
        //Otel uzunluklarının hepsini toplayınız
        //Bir method ile satır ve sutun bilgilerini çağıralım

        @Test
        public void test01 () {
            //https://www.techlistic.com/p/demo-selenium-practice.html adresine gidelim
            driver.get("https://www.techlistic.com/p/demo-selenium-practice.html");
            WebElement cerez = driver.findElement(By.xpath("//span[@id='ezmob-footer-close']"));
            cerez.click();
            bekle(3);
            WebElement cookie = driver.findElement(By.id("cookieChoiceDismiss"));
            cookie.click();

            //Demo Table altındaki tablodaki otel bilgilerini yazdırınız
            WebElement demoTable = driver.findElement(By.xpath("(//table)[2]"));
            System.out.println(demoTable.getText());
            System.out.println("//////////////////////////////////////");

            //Demo Table altındaki otel bilgileri olan tablodan Height değeri 601m olan otelin bilgilerini yazdırınız
            WebElement height601 = driver.findElement(By.xpath("(//table)[2]//tr[2]"));
            System.out.println("otelin bilgileri = " + height601.getText());
            System.out.println("//////////////////////////////////////");

            //Bütün Height bilgilerini yazdırınız
            WebElement heightsBaslik = driver.findElement(By.xpath("//thead//th[4]"));
            System.out.println(heightsBaslik.getText());
            System.out.println("-------");

            List<WebElement> heightColumns = driver.findElements(By.xpath("(//tbody)[2]//td[3]"));
            heightColumns.forEach(t -> System.out.println(t.getText()));

            //Otel uzunluklarının hepsini toplayınız
            int result = 0;
            for (int i = 0; i < heightColumns.size(); i++) {
                String heigh = heightColumns.get(i).getText().replace("m", "");
                int h = Integer.valueOf(heigh);
                result += h;

            }
            System.out.println("result = " + result);
            System.out.println("//////////////////////////////////////");
            WebElement table2 = driver.findElement(By.xpath("//table[@class=\"tsc_table_s13\"]"));
            List<WebElement> rows = driver.findElements(By.xpath("//tr"));

            //Bir method ile satır ve sutun bilgilerini çağıralım
            printData(1, 3, 2);
        }

    private void printData( int table, int satir, int sutun){
        WebElement satirSutun = driver.findElement(By.xpath("(//table)[" + table + "]//tr[" + satir + "]//td[" + sutun + "]"));

        System.out.println(table + ". tablo " + satir + ".satır  ve " + sutun + ". sütun = " + satirSutun.getText());

    }
}