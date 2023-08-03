package techproed.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


/*
Runner class'ı testNG deki .xml file kullanımındaki gibi istediğimiz scenario lari kullanacağımız tag parametresi
sayesinde çalıştırabiliriz. Ve plugin parametresi ile raporlar alabiliriz
 */
@RunWith(Cucumber.class)//-->Test çalıştırıcı Notasyon.Cucumber ile junit arasinda entegrasyonu saglar
@CucumberOptions(plugin = {"pretty",
                            "html:target/default-cucumber-reports.html",
                            "json:target/json-reports/cucumber.json",
                            "junit:target/xml-report/cucumber.xml"},
                features = "src/test/resources/features",
                glue = {"techproed/stepDefinition"},
                tags = "@g",  //"@techpro or @iphone",
                dryRun = false,//-->true seçersek scenarioları kontrol eder browser'ı çalıştırmaz
                monochrome = false // false olursa console'daki ciktilar renkli olur
)

public class Runner {
}
/*
@CucumberOptions() notasyonuna parametre olarak
            features--> feature packege'ınin yolunu belirtiriz(Content Root)
            glue-->stepdefinition package(source root)
            tags-->çalıştırmak istediğimiz scenariolari burda belirtiriz
    @CucumberOptions() notasyonu Scenarioların nerede ve nasıl çalışacağı, hangi raporu kullanacağı ile
alakalı seçanekleri bu notasyonda belirtiriz
 */
//@CucumberOptions() notasyonu icerisinde plugin parametresi ile yukaridaki gibi almak istedigimiz
        //rapor cesidini secip ekliyoruz.
        //pretty-->konsolda calistirdigimiz scenario ile ilgili ayrintili bilgi verir

  //"@techpro and @iphone"  and kullansaydik sadece techpro ve iphone a sahip olanlari calistirir.
  //yani tag in ikisine de sahip olmasi gerekir.
  //or kullaninca "@techpro or @iphone" techpro veya iphone a sahip olan hangisiyse onlari calistirir







  //Biz detayli raporu sadece Runner'da calistirinca alabildik. Feature'da detayli rapor almak icin:
//https://reports.cucumber.10 adresinden raporlamalari alabiliriz. Ancak resources altinda cucumber.properties
//isimli bir dosya olusturmaliyiz.
/*
gitHub ile ilisklilendirdikten sonra Create a collection'a gelecegiz ve Collections altinda Name icine B151CucumberNT
yazdik ve create new collection'i tikladik. Bize bir TOKEN verilir. Bu sifre ya da link
gibi yazili TOKEN'i alacagiz. Bu bizim icin bir adres olacak. Kopyaladiktan sonra projemizi aciyoruz ve
cucumber.properties dosyasina gelip icine CUCUMBER_PUBLISH_TOKEN'i yapistiriyoruz.
 */