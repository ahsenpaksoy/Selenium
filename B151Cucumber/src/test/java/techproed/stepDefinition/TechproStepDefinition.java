package techproed.stepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import techproed.pages.TechproPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.ReusableMethods;

public class TechproStepDefinition {

    TechproPage techproPage = new TechproPage();
    @Given("kullanici techpro sayfasina gider")
    public void kullaniciTechproSayfasinaGider() {
        Driver.getDriver().get(ConfigReader.getProperty("techproUrl"));
    }

    @Then("arama kutusunda qa aratir")
    public void aramaKutusundaQaAratir() {
        techproPage.aramaKutusu.sendKeys("qa", Keys.ENTER);
    }

    @And("sayfa basliginin qa icerdigini test eder")
    public void sayfaBasligininQaIcerdiginiTestEder() {
        Assert.assertFalse(Driver.getDriver().getTitle().contains("qa"));
    }

    @Then("arama kutusunda java aratir")
    public void aramaKutusundaJavaAratir() {
        techproPage.aramaKutusu.sendKeys("java", Keys.ENTER);
    }

    @And("sayfa basliginin java icerdigini test eder")
    public void sayfaBasligininJavaIcerdiginiTestEder() {
        Assert.assertFalse(Driver.getDriver().getTitle().contains("java"));
    }

    @Then("arama kutusunda mobile aratir")
    public void aramaKutusundaMobileAratir() {
        techproPage.aramaKutusu.sendKeys("mobile");
    }

    @When("cikan dropdown da mobile developer linkine tiklar")
    public void cikanDropdownDaMobileDeveloperLinkineTiklar() {
        ReusableMethods.bekle(2);
        techproPage.mobileLink.click();
        ReusableMethods.bekle(2);
    }

    @And("sayfa basliginin Mobile icerdigini test eder")
    public void sayfaBasligininMobileIcerdiginiTestEder() {
        Assert.assertTrue(Driver.getDriver().getTitle().contains("Mobile"));
    }

    @Given("kullanici {string} sayfasina gider")
    public void kullaniciSayfasinaGider(String url) {
        Driver.getDriver().get(url);
    }

    @Then("arama kutusunda {string} aratir")
    public void aramaKutusundaAratir(String str) {
        techproPage.aramaKutusu.sendKeys(str);
    }

    @And("kullanici {int} saniye bekler")
    public void kullaniciSaniyeBekler(int sayi) {
        try {
            Thread.sleep(sayi*1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}







