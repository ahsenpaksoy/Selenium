package techproed.stepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.ReusableMethods;

public class AmazonStepDefinition {
    @Given("kullanici amazon sayfasina gider")
    public void kullanici_amazon_sayfasina_gider() {
        Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));
    }
    @Then("kullnici aramaKutusunda iphone aratir")
    public void kullnici_arama_kutusunda_iphone_aratir() {
        Driver.getDriver().findElement(By.id("twotabsearchtextbox")).sendKeys("iphone", Keys.ENTER);
    }
    @Then("sayfayi kapatir")
    public void sayfayi_kapatir() {
        Driver.closeDriver();
    }

    @And("sayfayi yeniler")
    public void sayfayiYeniler() {
        ReusableMethods.bekle(2);
        Driver.getDriver().navigate().refresh();
    }

    @And("basligin iphone icerdigini test eder")
    public void basliginIphoneIcerdiginiTestEder() {
        Assert.assertTrue(Driver.getDriver().getTitle().contains("iphone"));
    }

    @And("kullnici aramaKutusunda samsung aratir")
    public void kullniciAramaKutusundaSamsungAratir() {
        Driver.getDriver().findElement(By.id("twotabsearchtextbox")).sendKeys("samsung", Keys.ENTER);
    }

    @And("basligin samsung icerdigini test eder")
    public void basliginSamsungIcerdiginiTestEder() {
        Assert.assertTrue(Driver.getDriver().getTitle().contains("samsung"));
    }
}












