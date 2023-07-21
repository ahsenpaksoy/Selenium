package tests.practicePdf;


import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BlueRentalCarPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;


public class US_05 {

    @Test
    public void test01() {

        Driver.getDriver().get(ConfigReader.getProperty("blueRentalUrl"));
        ReusableMethods.waitFor(1);

        BlueRentalCarPage blueRentalCarPage = new BlueRentalCarPage();
        blueRentalCarPage.login.click();
        blueRentalCarPage.email.sendKeys(ConfigReader.getProperty("blueRentalMail"));
        ReusableMethods.waitFor(1);
        blueRentalCarPage.password.sendKeys(ConfigReader.getProperty("blueRentalpassword"), Keys.ENTER);
    }

    @Test
    public void test02() {

        Driver.getDriver().get(ConfigReader.getProperty("blueRentalUrl"));
        ReusableMethods.waitFor(1);

        BlueRentalCarPage blueRentalCarPage = new BlueRentalCarPage();
        blueRentalCarPage.login.click();
        blueRentalCarPage.email.sendKeys(ConfigReader.getProperty("fakeEmail"));
        ReusableMethods.waitFor(1);
        blueRentalCarPage.password.sendKeys(ConfigReader.getProperty("fakePassword"), Keys.ENTER);
        ReusableMethods.waitFor(1);
        Assert.assertTrue(blueRentalCarPage.verify.isDisplayed());
    }

    @Test
    public void test03() {

        Driver.getDriver().get(ConfigReader.getProperty("blueRentalUrl"));
        ReusableMethods.waitFor(1);

        BlueRentalCarPage blueRentalCarPage = new BlueRentalCarPage();
        blueRentalCarPage.login.click();
        blueRentalCarPage.email.sendKeys(ConfigReader.getProperty("blueRentalMail"));
        ReusableMethods.waitFor(1);
        blueRentalCarPage.password.sendKeys(ConfigReader.getProperty("fakePassword"), Keys.ENTER);
        ReusableMethods.waitFor(1);
        Assert.assertTrue(blueRentalCarPage.verify.isDisplayed());
    }

    @Test
    public void test04() {
        Driver.getDriver().get(ConfigReader.getProperty("blueRentalUrl"));
        ReusableMethods.waitFor(1);

        BlueRentalCarPage blueRentalCarPage = new BlueRentalCarPage();
        blueRentalCarPage.login.click();
        blueRentalCarPage.email.sendKeys(ConfigReader.getProperty("gecersizMail"));
        ReusableMethods.waitFor(1);
        blueRentalCarPage.password.sendKeys(ConfigReader.getProperty("fakePassword"), Keys.ENTER);
        ReusableMethods.waitFor(1);
        Assert.assertTrue(blueRentalCarPage.verify1.isDisplayed());
    }

    @Test
    public void test05() {

        Driver.getDriver().get(ConfigReader.getProperty("blueRentalUrl"));
        ReusableMethods.waitFor(1);

        BlueRentalCarPage blueRentalCarPage = new BlueRentalCarPage();
        Select select = new Select(blueRentalCarPage.ddm);
        select.selectByVisibleText(ConfigReader.getProperty("aracMarkasi"));

        blueRentalCarPage.pickLocation.sendKeys(ConfigReader.getProperty("pickUpLocation"));
        ReusableMethods.waitFor(1);
        blueRentalCarPage.pickLocation.sendKeys(ConfigReader.getProperty("pickUpLocation"));
        ReusableMethods.waitFor(1);
        blueRentalCarPage.dropLocation.sendKeys(ConfigReader.getProperty("DropOffLocation"));
        ReusableMethods.waitFor(2);
        blueRentalCarPage.pickDate.sendKeys(ConfigReader.getProperty("pickUpDate"));//alis tarihi
        ReusableMethods.waitFor(1);
        blueRentalCarPage.pickTime.sendKeys(ConfigReader.getProperty("pickUpTime"));//alis saati
        ReusableMethods.waitFor(1);
        blueRentalCarPage.dropDate.sendKeys(ConfigReader.getProperty("dropOffDate"));//geri veris tarihi
        ReusableMethods.waitFor(1);
        blueRentalCarPage.dropTime.sendKeys(ConfigReader.getProperty("dropOffTime"));//geri veris saati
        ReusableMethods.waitFor(1);
        blueRentalCarPage.continueReserv.click();
        ReusableMethods.waitFor(1);
        Assert.assertTrue(blueRentalCarPage.verifyson.isDisplayed());
    }
}


