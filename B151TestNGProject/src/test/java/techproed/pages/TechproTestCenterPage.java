package techproed.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import techproed.utilities.Driver;

public class TechproTestCenterPage {

    public TechproTestCenterPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "//*[@name='username']")
    public WebElement username;
    @FindBy(xpath = "//*[@name='password']")
    public WebElement password;
    @FindBy(xpath = "//*[@type='submit']")
    public WebElement loginButton;
    @FindBy(xpath = "//*[@role='alert']")
    public WebElement girisVerify;
    @FindBy(xpath = "//a//i")
    public WebElement logoutButton;
    @FindBy(xpath = "//h2")
    public WebElement logoutVerify;

}
