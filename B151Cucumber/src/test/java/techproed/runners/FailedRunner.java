package techproed.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)//-->Test çalıştırıcı Notasyon.Cucumber ile junit arasinda entegrasyonu saglar
@CucumberOptions(plugin = {"pretty",
        "html:target/default-cucumber-reports.html",
        "json:target/json-reports/cucumber.json",
        "junit:target/xml-report/cucumber.xml",
        "rerun:TestOutput/failed_scenario.txt"},
        //rerun ile balirttigimiz dosyada fail olan senaryolar tutulur.
        features = "@TestOutput/failed_scenario.txt",
        glue = {"techproed/stepDefinition"},
        dryRun = false,//-->true seçersek scenarioları kontrol eder browser'ı çalıştırmaz
        monochrome = false // false olursa console'daki ciktilar renkli olur
)

public class FailedRunner {
}

//normalde features lari normal dosya yolu olarak calistirirken rerun da features bolumunun basina @ isaret i konur

/*
  FailedRunner class'ını oluşturma amacımız rerun ile belirttiğimiz yolda fail olan scenarioları
tekrar bu class'dan tüm scenario'ları tekrar çalıştırmak yerine sadece fail olanları çalıştırmak
için kullanırız. @CucumberOptions() parametresi içine belirttiğimiz features tag'ına bu class'da
fail olan scenarioları tutan txt dosyasının yolunu belirtiriz. Dosya yolu belirttiğimiz için
önüne @ işareti koymamız gerekir
 */
