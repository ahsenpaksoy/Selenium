package techproed.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import techproed.utilities.Driver;

public class OpenSourcePage {
    /*
     TestNG de locate'lerimizi pages package'ı altında oluşturduğumuz class'lar içinde alırız.
Bu class içinde driver'imizi tanimlamak ve webelementleri oluşturabilmek için constructor oluşturup
bu cons. içinde PageFactory class'ından initelements methodunu kullanarak driver'imizi bu class'a tanımlarız

    Bir sayfanin locatelerini page class'inda tutariz. Bir constructor olusturup locatelere ulasabilmek icin
    PageFactory'den initelements() methodu ile driver'imizi bu class'a tanimlariz.
        findelement() methodu yerine @FindBy notasyonu ile bu notasyona parametre olarak locateleri gireriz.
     */

    public OpenSourcePage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    /**
     Webelemtleri locate edebilmek icin findElement() methodu kullaniyorduk.
     @FindBy notasyonu ile artik findElement() methodunu kullanmayip @FindBy notasyonu icinde driver'in yerini
     tarif etmemiz gerekiyor.
     Yukaridaki (Driver.getDriver(), this) komutu burada ihtiyac duydugum driver, Driver class'indaki
     getDriver() methodun'daki driver demek oluyor.
     */

    @FindBy(xpath = "//*[@name='username']") // cogaltmak icin sec ctrl ye bas mouse'un sol tusuyla asagiya cek
    public WebElement username;

    @FindBy(xpath = "//*[@name='password']")
    public WebElement password;

    @FindBy(xpath = "//*[@type='submit']")
    public WebElement loginButton;

    @FindBy(xpath = "//h6")
    public WebElement verify;



}
