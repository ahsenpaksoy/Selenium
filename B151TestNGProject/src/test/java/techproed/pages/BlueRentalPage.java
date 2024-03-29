package techproed.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import techproed.utilities.Driver;

public class BlueRentalPage {
    public BlueRentalPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "(//*[@role='button'])[1]")
    public WebElement login;

    @FindBy(xpath = "//*[@name='email']")
    public WebElement email;

    @FindBy(xpath = "(//*[@type='button'])[1]")
    public WebElement loginVerify;

    @FindBy(xpath = "//*[@id='dropdown-basic-button']")
    public WebElement verify;

    /*
        loginVerify ve verify locateleri ayni yerin locate'i. Login oldugunu dogrulamak icin alindi
     */

    @FindBy(xpath = "//*[@role='alert']")
    public WebElement mesajVerify;

    @FindBy(xpath = "//*[.='Logout']")
    public WebElement logOut;

    @FindBy(xpath = "//*[.='OK']")
    public WebElement ok;




    //digerlerine Keys.Tab ile gecis yaptik






}
