package tests.practicePdf;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BlueRentalCarPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class US_3 {
    @Test
    public void test01() {

        //dogru email ve dogru sifre ile giris
        Driver.getDriver().get(ConfigReader.getProperty("blueRentalUrl"));
        ReusableMethods.waitFor(2);

        BlueRentalCarPage rentalCarPage = new BlueRentalCarPage();
        rentalCarPage.login.click();
        rentalCarPage.email.sendKeys(ConfigReader.getProperty("blueRentalMail"));
        ReusableMethods.waitFor(1);
        rentalCarPage.password.sendKeys(ConfigReader.getProperty("blueRentalpassword"), Keys.ENTER);

    }

    //dogru email yanlis password
    @Test
    public void test02() {
        Driver.getDriver().get(ConfigReader.getProperty("blueRentalUrl"));
        ReusableMethods.waitFor(2);

        BlueRentalCarPage rentalCarPage = new BlueRentalCarPage();
        rentalCarPage.login.click();
        rentalCarPage.email.sendKeys(ConfigReader.getProperty("blueRentalMail1"));
        ReusableMethods.waitFor(1);
        rentalCarPage.password.sendKeys(ConfigReader.getProperty("fakePassword"), Keys.ENTER);
        ReusableMethods.waitFor(2);
        Assert.assertTrue(rentalCarPage.verify.isDisplayed());

    }
}

  // akan yazilarda locate'ini alamiyorsak yakalayamiyorsak inspect dedikten sonra sources kismina tikla,
  // sonra pause kismina tikla en son elements ve sol ust kosedeki oka tikla













