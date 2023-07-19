package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class FacebookPage {

    public FacebookPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    // kullanıcı email kutusuna rastgele bir isim yazın
    @FindBy(xpath = "//*[@name='email']")
    public WebElement emailKutusu;

    // kullanıcı sifre kutusuna rastgele bir password yazın
    @FindBy(xpath = "//input[@id='pass']")
    public WebElement sifreKutusu;

    // giris yap butonuna tıklayın
    @FindBy(xpath = "//*[@name='login']")
    public WebElement girisYapButonu;

    // "baska sekilde tanimla" yazı elementinin, gorunur oldugunu test edin
    @FindBy(xpath = "//div[@class='_9ay7']")
    public WebElement girdiginSifreYanlisYaziElementi;


    @FindBy(xpath = "//*[@class='_42ft _4jy0 _al65 _4jy3 _4jy1 selected _51sy']")
    public WebElement cerez;



}


















