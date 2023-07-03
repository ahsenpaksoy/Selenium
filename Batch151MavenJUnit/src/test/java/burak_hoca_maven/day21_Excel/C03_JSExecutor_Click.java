package burak_hoca_maven.day21_Excel;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import burak_hoca_maven.utilities.TestBase;

public class C03_JSExecutor_Click extends TestBase {
    /*
       1- Eger bir web sayfasinin HTML kodlari tamamen yada kismen JavaScript kullanilarak olusturulduysa,
       o sayfayla etkilesimde bulunmak icin standart WebDriver komutlari yetersiz kalabilir.
       2- Bu durumda sayfayla etkilesime gecebilmek icin JavaScriptExecuter arayuzunu kullanmak gerekir.
       JavaScriptExecuter arayuzu sayfaya dogrudan erisebilir.
       3- Ancak mumkunse WebDriver'in sundugu standart yontemlerle sayfayla etkilesime gecmek her zaman daha iyidir.
       Cunku JS kullanimi sayfanin daha yavas yuklenmesine neden olabilir.
     */

    @Test
    public void jsExecuterClick() {

        // https://www.amazon.com sayfasina gidin
        driver.get("https://www.amazon.com");

        // returns kismina tiklayin
        WebElement returns = driver.findElement(By.xpath("//a[@id='nav-orders']"));
        //returns.click();

        /*
        ilgili webElementin HTML kodu JavaScript kullanilarak olusturulduysa standart WebDriver
        komutu olan click() yetersiz kalabilir.
        Boyle durumlarda JavaScriptExecuter kullanilarak sayfayla etkilesime gecilabilir.
         */

        //JavascriptExecutor js = (JavascriptExecutor) driver;
        //js.executeScript("arguments[0].click();",returns);

        click(returns);

    }

}









