package techproed.stepDefinition;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.But;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.devtools.v85.network.model.DataReceived;
import techproed.pages.GooglePage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.ReusableMethods;

public class GoogleStepDefinition {
    GooglePage googlePage = new GooglePage();
    @Given("kullanici {string} sayfasina properties ile gider")
    public void kullaniciSayfasinaPropertiesIleGider(String url) {
        Driver.getDriver().get(ConfigReader.getProperty(url));
    }

    @Then("kullanici arama kutusunda {string} aratir")
    public void kullaniciAramaKutusundaAratir(String str) {
        googlePage.aramaKutusu.sendKeys(ConfigReader.getProperty(str), Keys.ENTER);
    }

    @And("kullanici sayfa basliginin {string} icerdigini test eder")
    public void kullaniciSayfaBasligininIcerdiginiTestEder(String str) {
        Assert.assertTrue(Driver.getDriver().getTitle().contains(ConfigReader.getProperty(str)));
    }

    @And("kullanici cerezleri kapatir")
    public void kullaniciCerezleriKapatir() {
        googlePage.cerez.click();

    }

    @Then("kullanici google arama kutusunda {string} aratir")
    public void kullaniciGoogleAramaKutusundaAratir(String str) {
        googlePage.aramaKutusu.sendKeys(str,Keys.ENTER);
    }

    @And("kullanici sayfa basliginin {string} icerdigini test etti")
    public void kullaniciSayfaBasligininIcerdiginiTestEtti(String str) {
        Assert.assertTrue(Driver.getDriver().getTitle().contains(str));
    }

    @Then("kullanici google arama kutusunda {string} ile propertiesden aratir")
    public void kullaniciGoogleAramaKutusundaIlePropertiesdenAratir(String str) {
        googlePage.aramaKutusu.sendKeys(ConfigReader.getProperty(str),Keys.ENTER);
    }

    @Then("kullanici data tableda verilen bilgileri aratir")
    public void kullaniciDataTabledaVerilenBilgileriAratir(DataTable data) {
        System.out.println(data.asList());
        for (int i = 1; i < data.asList().size() ; i++) {
            googlePage.aramaKutusu.sendKeys(data.asList().get(i),Keys.ENTER);
            ReusableMethods.bekle(2);
            Assert.assertTrue(Driver.getDriver().getTitle().contains(data.asList().get(i)));
            ReusableMethods.bekle(2);
            googlePage.aramaKutusu.clear();
        }
    }

    @Given("kullanici {string} sayfasina gitti")
    public void kullaniciSayfasinaGitti(String url) {
        Driver.getDriver().get(ConfigReader.getProperty(url));
    }
}



/*

public class GoogleStepDefinition {
    GooglePage googlePage = new GooglePage();
    @Given("kullanici {string} sayfasina gitti")
    public void kullaniciSayfasinaGitti(String url) {
        Driver.getDriver().get(ConfigReader.getProperty(url));

    }

    @Then("kullanici google arama kutusunda {string} aratir")
    public void kullaniciGoogleAramaKutusundaAratir(String arac) {
        googlePage.aramaKutusu.sendKeys(arac, Keys.ENTER);
    }

    @And("google sayfasinda basligin {string} icerdigini test eder")
    public void googleSayfasindaBasliginIcerdiginiTestEder(String baslik) {
        Assert.assertTrue(Driver.getDriver().getTitle().contains(baslik));
    }

    @But("kullanici {int} saniye bekler")
    public void kullaniciSaniyeBekler(int sayi) {
        try {
            Thread.sleep(sayi*1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    @Then("kullanici google arama kutusunda {string} aratti")
    public void kullaniciGoogleAramaKutusundaAratti(String araclar) {
        googlePage.aramaKutusu.sendKeys(ConfigReader.getProperty(araclar),Keys.ENTER);
    }

    @And("google sayfasinda basligin {string} icerdigini test etti")
    public void googleSayfasindaBasliginIcerdiginiTestEtti(String str) {
        Assert.assertTrue(Driver.getDriver().getTitle().contains(ConfigReader.getProperty(str)));
    }

    @Then("kullanici data tableda verilen bilgileri aratir")
    public void kullaniciDataTabledaVerilenBilgileriAratir(DataTable data) {
        System.out.println(data.asList());
        for (int i = 1; i < data.asList().size(); i++) {
            googlePage.aramaKutusu.sendKeys(data.asList().get(i),Keys.ENTER);
            ReusableMethods.bekle(2);
            Assert.assertTrue(Driver.getDriver().getTitle().contains(data.asList().get(i)));
            ReusableMethods.bekle(2);
            googlePage.aramaKutusu.clear();

        }
    }
}

 */








