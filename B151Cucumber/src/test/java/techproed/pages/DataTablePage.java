package techproed.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v85.page.Page;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import techproed.utilities.Driver;

public class DataTablePage {
    public DataTablePage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "(//button)[1]")
    public WebElement newButon;
    @FindBy (xpath = "//*[@id='DTE_Field_first_name']")
    public WebElement firstName;
    @FindBy (xpath = "(//button)[4]")
    public WebElement createButton;
    @FindBy(xpath = "//*[@type='search']")
    public WebElement searchBox;

    @FindBy(xpath = "(//*[@class='sorting_1'])[1]")
    public WebElement searchVerify;

}
