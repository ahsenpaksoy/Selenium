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

    @FindBy(xpath = "//*[@class='Toastify__toast-body']") // Bad credentials text'i
    public WebElement verify;

    @FindBy(xpath = "(//*[@type='button'])[1]")
    public WebElement loginVerify;

    @FindBy(xpath = "(//div[@class='invalid-feedback'])[1]")
    public WebElement invalidEmail;

    @FindBy(xpath = "(//a[@class='dropdown-item'])[1]")
    public WebElement reservations;

    @FindBy(xpath = "(//*[@class='invalid-feedback'])[1]")
    public WebElement verify1;

    @FindBy(xpath = "//*[@name='car']")
    public WebElement ddm;

    @FindBy(xpath = "//*[@name= 'pickUpLocation']")
    public WebElement pickLocation;

    @FindBy(xpath = "//*[@name= 'dropOfLocation']")
    public WebElement dropLocation;

    @FindBy(xpath = "//*[@name= 'pickUpDate']")
    public WebElement pickDate;

    @FindBy(xpath = "//*[@name= 'pickUpTime']")
    public WebElement pickTime;

    @FindBy(xpath = "//*[@name='dropOffDate']")
    public WebElement dropDate;

    @FindBy(xpath = "//*[@name='dropOffTime']")
    public WebElement dropTime;

    @FindBy(xpath = "//*[@type='submit']")
    public WebElement continueReserv;

    @FindBy(xpath = "//*[@role='alert']")
    public WebElement verifyson;



}
