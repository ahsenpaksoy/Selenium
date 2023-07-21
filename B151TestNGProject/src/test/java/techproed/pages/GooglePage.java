package techproed.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import techproed.utilities.Driver;

public class GooglePage {
    public GooglePage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//textarea[@id='APjFqb']")
    public WebElement aramaKutusu;

    @FindBy(xpath = "(//div[@class='QS5gu sy4vM'])[1]")
    public WebElement cerez;





}
