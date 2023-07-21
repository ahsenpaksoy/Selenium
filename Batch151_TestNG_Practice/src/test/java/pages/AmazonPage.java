package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import utilities.Driver;

public class AmazonPage {
    public AmazonPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    // C01_PageClassKullanimi

    // dropdown'dan "Computers" optionunu secin
    @FindBy(xpath = "//select[@id='searchDropdownBox']")
    public WebElement ddm;   // dropdown menu locate'i

    // arama motoruna "Asus" yazıp aratın
    @FindBy(xpath = "//*[@id='twotabsearchtextbox']")
    public WebElement aramaKutusu;

    // ikinci urunun fotografını cekin
    @FindBy(xpath = "(//img[@class='s-image'])[2]")
    public WebElement ikinciUrun;


    // C02_Raporlama

    // sonuc yazisinin "Java" icerdigini test edin
    @FindBy(xpath = "//*[@class='a-section a-spacing-small a-spacing-top-small']")
    public WebElement sonucYazisi;




}



















