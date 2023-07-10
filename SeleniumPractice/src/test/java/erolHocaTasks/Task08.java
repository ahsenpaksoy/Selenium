package erolHocaTasks;

import utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

    public class Task08 extends TestBase {
        //https://bonigarcia.dev/selenium-webdriver-java/slow-calculator.html adresine gidelim
        //Hesap makinasından 2 basamaklı random iki tane sayı seçelim ve random 4 işlemden birini yaptıralım
        //Sonucu konsola yazdırıp
        //Sonucun doğrulamasını yapalım

        Random random;

        @Test
        public void test01(){
            //https://bonigarcia.dev/selenium-webdriver-java/slow-calculator.html adresine gidelim
            driver.get("https://bonigarcia.dev/selenium-webdriver-java/slow-calculator.html");
            //Hesap makinasından 2 basamaklı random iki tane sayı seçelim ve random 4 işlemden birini yaptıralım
            /////rastgele sayi urettik

            //div[@id='calculator']//span[contains(text(),'0')]
            for (int i = 0; i < 2; i++) {
                random = new Random();
                int randomSayi = random.nextInt(10);
                driver.findElement(By.xpath("//div[@id='calculator']//span[contains(text(),'" + randomSayi + "')]")).click();

            }

            //////////////////////////////////////////////////////////////////////////////////////////////////////////////////
            List<WebElement> isaretler = driver.findElements(By.xpath("//*[@id='calculator']//span[contains(@class,'operator btn btn-outline-success')]"));

            int index = random.nextInt(isaretler.size());
            WebElement islemler = isaretler.get(index);

            islemler.click();

            //////////////////////////////////////////////////////////////////////////////////////////////////////////////////
            for (int i = 0; i < 2; i++) {
                random = new Random();
                int randomSayi = random.nextInt(10);
                driver.findElement(By.xpath("//div[@id='calculator']//span[contains(text(),'" + randomSayi + "')]")).click();

            }
            String kova2 = driver.findElement(By.xpath("//*[@class='screen']")).getText();
            System.out.println("kova2 = " + kova2);
            String[] split = kova2.split("[-+x÷]");

            System.out.println("Arrays.toString(split) = " + Arrays.toString(split));

            String rakam1 = split[0];
            double rakam11 = Double.parseDouble(rakam1);
            System.out.println("rakam11 = " + rakam11);

            String rakam2 = split[1];

            double rakam22 = Double.parseDouble(rakam2);
            System.out.println("rakam22 = " + rakam22);

            //Sonucu konsola yazdırıp
            driver.findElement(By.xpath("//*[@class='btn btn-outline-warning']")).click();

            //Sonucun doğrulamasını yapalım
            double sonuc = 0;
            switch (islemler.getText()) {
                case "+":
                    sonuc = rakam11 + rakam22;
                    break;
                case "-":
                    sonuc = rakam11 - rakam22;
                    break;
                case "x":
                    sonuc = rakam11 * rakam22;
                    break;
                case "÷":
                    sonuc = rakam11 / rakam22;
                    break;
                default:
                    System.out.println("Geçersiz işlem yönü");
                    break;
            }
            System.out.println("sonuc = " + sonuc);

            WebElement sonEkran = driver.findElement(By.xpath("//*[@class='screen']"));
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.invisibilityOfElementWithText(By.xpath("//*[@class='screen']"), sonEkran.getText()));

            double screenActual = Double.parseDouble(sonEkran.getText());
            System.out.println("screenActual = " + screenActual);
            System.out.println("screen = " + screenActual);

            Assert.assertEquals(sonuc, screenActual, 0.001);

        }
    }


      /*
      import Utilities.TestBase;
import com.github.javafaker.Faker;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class odev_Calculator extends TestBase {
    @Test
    public void test01() {
        //https://bonigarcia.dev/selenium-webdriver-java/slow-calculator.html adresine gidelim
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/slow-calculator.html");

        //Hesap makinasından 2 basamaklı random iki tane sayı seçelim ve random 4 işlemden birini yaptıralım
        Faker faker = new Faker();
        String sayi1 = String.valueOf(faker.number().numberBetween(1,9));
        String sayi2 = String.valueOf(faker.number().numberBetween(1,10));

        Actions actions = new Actions(driver);
        WebElement sayi1Basamak1 = xpath("(//*[@class='btn btn-outline-primary'])[" + sayi1 + "]");
        actions.moveToElement(sayi1Basamak1).click().perform();
        pause(1);
        WebElement sayi1Basamak2 = xpath("(//*[@class='btn btn-outline-primary'])[" + sayi2 + "]");
        actions.moveToElement(sayi1Basamak2).click().perform();
        pause(1);

        String operator = String.valueOf(faker.number().numberBetween(1,4));
        WebElement oper = xpath("(//*[@class='operator btn btn-outline-success'])[" + operator + "]");
        actions.moveToElement(oper).click().perform();
        pause(1);

        String sayi3 = String.valueOf(faker.number().numberBetween(1,9));
        String sayi4 = String.valueOf(faker.number().numberBetween(1,10));

        WebElement sayi2Basamak1 = xpath("(//*[@class='btn btn-outline-primary'])[" + sayi3 + "]");
        actions.moveToElement(sayi2Basamak1).click().perform();
        pause(1);
        WebElement sayi2Basamak2 = xpath("(//*[@class='btn btn-outline-primary'])[" + sayi4 + "]");
        actions.moveToElement(sayi2Basamak2).click().perform();
        pause(1);

        actions.moveToElement(xpath("//*[@class='btn btn-outline-warning']")).click().perform();

        //Sonucu konsola yazdırıp
        pause(6);
        System.out.println("İşlem sonucu = " + xpath("//*[@class='screen']").getText());

        //Sonucun doğrulamasını yapalım
        int birinciSayi = Integer.parseInt(sayi1Basamak1.getText() + sayi1Basamak2.getText());
        int ikinciSayi = Integer.parseInt(sayi2Basamak1.getText() + sayi2Basamak2.getText());
        if (oper.getText().equals("+")){
            String result = String.valueOf(birinciSayi + ikinciSayi);
            System.out.println(result);
            Assert.assertEquals(xpath("//*[@class='screen']").getText(), result);
        }if (oper.getText().equals("-")){
            String result = String.valueOf(birinciSayi - ikinciSayi);
            System.out.println(result);
            Assert.assertEquals(xpath("//*[@class='screen']").getText(), result);
        }if (oper.getText().equals("x")){
            String result = String.valueOf(birinciSayi * ikinciSayi);
            System.out.println(result);
            Assert.assertEquals(xpath("//*[@class='screen']").getText(), result);
        }if (oper.getText().equals("÷")){
            String result = String.valueOf(birinciSayi / ikinciSayi);
            System.out.println(result);
            Assert.assertEquals(xpath("//*[@class='screen']").getText(), result);
        }
    }
}

       */





