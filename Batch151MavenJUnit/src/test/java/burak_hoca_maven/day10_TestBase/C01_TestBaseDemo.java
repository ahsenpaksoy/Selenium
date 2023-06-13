package burak_hoca_maven.day10_TestBase;

import org.junit.Assert;
import org.junit.Test;
import techproed.utilities.TestBase;


public class C01_TestBaseDemo extends TestBase {
    //techproeducation sayfasına gidiniz
    //Baslıgın "Bootcamp" icerdigini test ediniz

    @Test
    public void name() {

        //techproeducation sayfasına gidiniz
        driver.get("https://techproeducation.com");


        //Baslıgın "Bootcamp" icerdigini test ediniz
        String actuelTitle = driver.getTitle();
        String expectedTitle = "Bootcamp";

        Assert.assertTrue(actuelTitle.contains(expectedTitle));

    }

}
