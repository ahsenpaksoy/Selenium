package tests.practicePdf;


import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BlueRentalCarPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;


public class US_5 {

    @Test
    public void test01() {

        Driver.getDriver().get(ConfigReader.getProperty("blueRentalUrl"));
        ReusableMethods.bekle(1);

        BlueRentalCarPage blueRentalCarPage = new BlueRentalCarPage();
        blueRentalCarPage.login.click();
        blueRentalCarPage.email.sendKeys(ConfigReader.getProperty("blueRentalMail"));
        ReusableMethods.bekle(1);
        blueRentalCarPage.password.sendKeys(ConfigReader.getProperty("blueRentalpassword"), Keys.ENTER);
    }

    @Test
    public void test02() {

        Driver.getDriver().get(ConfigReader.getProperty("blueRentalUrl"));
        ReusableMethods.bekle(1);

        BlueRentalCarPage blueRentalCarPage = new BlueRentalCarPage();
        blueRentalCarPage.login.click();
        blueRentalCarPage.email.sendKeys(ConfigReader.getProperty("fakeEmail"));
        ReusableMethods.bekle(1);
        blueRentalCarPage.password.sendKeys(ConfigReader.getProperty("fakePassword"), Keys.ENTER);
        ReusableMethods.bekle(1);
        Assert.assertTrue(blueRentalCarPage.verify.isDisplayed());
    }

    @Test
    public void test03() {

        Driver.getDriver().get(ConfigReader.getProperty("blueRentalUrl"));
        ReusableMethods.bekle(1);

        BlueRentalCarPage blueRentalCarPage = new BlueRentalCarPage();
        blueRentalCarPage.login.click();
        blueRentalCarPage.email.sendKeys(ConfigReader.getProperty("blueRentalMail"));
        ReusableMethods.bekle(1);
        blueRentalCarPage.password.sendKeys(ConfigReader.getProperty("fakePassword"), Keys.ENTER);
        ReusableMethods.bekle(1);
        Assert.assertTrue(blueRentalCarPage.verify.isDisplayed());
    }

    @Test
    public void test04() {
        Driver.getDriver().get(ConfigReader.getProperty("blueRentalUrl"));
        ReusableMethods.bekle(1);

        BlueRentalCarPage blueRentalCarPage = new BlueRentalCarPage();
        blueRentalCarPage.login.click();
        blueRentalCarPage.email.sendKeys(ConfigReader.getProperty("gecersizMail"));
        ReusableMethods.bekle(1);
        blueRentalCarPage.password.sendKeys(ConfigReader.getProperty("fakePassword"), Keys.ENTER);
        ReusableMethods.bekle(1);
        Assert.assertTrue(blueRentalCarPage.verify1.isDisplayed());
    }

    @Test
    public void test05() {

        Driver.getDriver().get(ConfigReader.getProperty("blueRentalUrl"));
        ReusableMethods.bekle(1);

        BlueRentalCarPage blueRentalCarPage = new BlueRentalCarPage();
        Select ddm = new Select(blueRentalCarPage.select);
        ddm.selectByVisibleText(ConfigReader.getProperty("aracMarkasi"));

        blueRentalCarPage.pkLocation.sendKeys(ConfigReader.getProperty("pickUpLocation"));
        ReusableMethods.bekle(1);
        blueRentalCarPage.pkLocation.sendKeys(ConfigReader.getProperty("pickUpLocation"));
        ReusableMethods.bekle(1);
        blueRentalCarPage.drLocation.sendKeys(ConfigReader.getProperty("DropOffLocation"));
        ReusableMethods.bekle(2);
        blueRentalCarPage.pkDate.sendKeys(ConfigReader.getProperty("pickUpDate"));//alis tarihi
        ReusableMethods.bekle(1);
        blueRentalCarPage.pkTime.sendKeys(ConfigReader.getProperty("pickUpTime"));//alis saati
        ReusableMethods.bekle(1);
        blueRentalCarPage.drDate.sendKeys(ConfigReader.getProperty("dropOffDate"));//geri veris tarihi
        ReusableMethods.bekle(1);
        blueRentalCarPage.drTime.sendKeys(ConfigReader.getProperty("dropOffTime"));//geri veris saati
        ReusableMethods.bekle(1);
        blueRentalCarPage.continueReserv.click();
        ReusableMethods.bekle(1);
        Assert.assertTrue(blueRentalCarPage.verifyson.isDisplayed());
    }
}


