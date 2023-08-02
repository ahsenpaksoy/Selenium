package techproed.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import techproed.utilities.Driver;

import java.util.List;

public class GooglePage {
    public GooglePage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "//*[@class='gLFyf']")
    public WebElement aramaKutusu;

    @FindBy(xpath = "(//*[@class='QS5gu sy4vM'])[2]")
    public WebElement cerez;

    /*
    List<WebElement> urunler = Driver.getDriver().findElements(By.xpath("sdfsdfsdf"));

    PAGE CLASS'ında KARSILIGI
    @FindBy(xpath = "fgdfgdfg")
    public List<WebElement> urunler;
     */






}









