package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class BlueRentalCarPage {

    public BlueRentalCarPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "(//a)[1]")
    public WebElement login;

    @FindBy(xpath = "//*[@name='email']")
    public WebElement email;

    @FindBy(xpath = "//*[@name='password']")
    public WebElement password;

    @FindBy(xpath = "//*[@class='Toastify__toast-body']")
    public WebElement verify;

    @FindBy(xpath = "(//*[@class='invalid-feedback'])[1]")
    public WebElement verify1;

    @FindBy(xpath = "//*[@name='car']")
    public WebElement select;

    @FindBy(xpath = "//*[@name= 'pickUpLocation']")
    public WebElement pkLocation;

    @FindBy(xpath = "//*[@name= 'dropOfLocation']")
    public WebElement drLocation;

    @FindBy(xpath = "//*[@name= 'pickUpDate']")
    public WebElement pkDate;

    @FindBy(xpath = "//*[@name= 'pickUpTime']")
    public WebElement pkTime;

    @FindBy(xpath = "//*[@name='dropOffDate']")
    public WebElement drDate;

    @FindBy(xpath = "//*[@name='dropOffTime']")
    public WebElement drTime;

    @FindBy(xpath = "//*[@type='submit']")
    public WebElement continueReserv;

    @FindBy(xpath = "//*[@role='alert']")
    public WebElement verifyson;



}
