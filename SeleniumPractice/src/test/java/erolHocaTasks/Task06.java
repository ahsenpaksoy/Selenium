package erolHocaTasks;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import javax.swing.*;

public class Task06 extends TestBase {
    @Test
    public void test01() {
        // http://szimek.github.io/signature_pad/ sayfasına gidiniz
        driver.get("http://szimek.github.io/signature_pad/");

        // Çıkan ekrana istediğiniz çizgi yada şekli çiziniz
        WebElement drag = driver.findElement(By.xpath("//*[@class='signature-pad--body']"));
        Actions actions = new Actions(driver);
        actions.clickAndHold(drag)
                .moveByOffset(40, 50)
                .moveByOffset(60, -40)
                .moveByOffset(-60, -60)
                .moveByOffset(-70, 50)
                .moveByOffset(40, 50)
                .moveByOffset(60, -40)
                .moveByOffset(-60, -60)
                .moveByOffset(-70, 50)
                .moveByOffset(40, 50)
                .moveByOffset(60, -40)
                .moveByOffset(-60, -60)
                .moveByOffset(-70, 50)
                .moveByOffset(40, 50)
                .moveByOffset(60, -40)
                .moveByOffset(-60, -60)
                .moveByOffset(-70, 50)
                .moveByOffset(40, 50)
                .moveByOffset(60, -40)
                .moveByOffset(-60, -60)
                .moveByOffset(-70, 50)
                .moveByOffset(40, 50)
                .moveByOffset(60, -40)
                .moveByOffset(-60, -60)
                .moveByOffset(-70, 50)
                .moveByOffset(40, 50)
                .moveByOffset(60, -40)
                .moveByOffset(-60, -60)
                .moveByOffset(-70, 50)
                .moveByOffset(40, 50)
                .moveByOffset(60, -40)
                .moveByOffset(-60, -60)
                .moveByOffset(-70, 50)
                .release()
                .perform();
        bekle(4);

        // Çizimden sonra clear butonuna basınız
        driver.findElement(By.xpath("//*[@class='button clear']")).click();

        // Sayfayi kapatiniz
    }
}



  /*

   @Test
    public void test01() {
        driver.get("http://szimek.github.io/signature_pad/");

        WebElement canvas = driver.findElement(By.xpath("(//*[@class='signature-pad--body'])/canvas"));
        int canvasWidth = canvas.getSize().getWidth();
        int canvasHeight = canvas.getSize().getHeight();
        int centerX = canvasWidth / 2;
        int centerY = canvasHeight / 2;
        int radius = Math.min(canvasWidth, canvasHeight) / 4; // Yarı çapı canvas boyutlarına gore ayarlama
        int numPoints = 5;
        double angle = 2 * Math.PI / numPoints;

        JavascriptExecutor js = (JavascriptExecutor) driver;

        // Yıldız çizimini JavaScript kodu ile gerçekleştir
        StringBuilder jsCode = new StringBuilder();
        jsCode.append("var canvas = arguments[0];");
        jsCode.append("var context = canvas.getContext('2d');");
        jsCode.append("context.beginPath();");
        jsCode.append("context.moveTo(arguments[1], arguments[2]);");

        for (int i = 1; i <= numPoints * 2; i++) {
            int x, y;
            if (i % 2 == 0) {
                x = (int) (centerX + radius * Math.cos(i * angle));
                y = (int) (centerY + radius * Math.sin(i * angle));
            } else {
                x = centerX;
                y = centerY;
            }
            jsCode.append("context.lineTo(").append(x).append(",").append(y).append(");");
        }

        jsCode.append("context.closePath();");
        jsCode.append("context.stroke();");

        js.executeScript(jsCode.toString(), canvas, centerX, centerY);
    }
}

   */
