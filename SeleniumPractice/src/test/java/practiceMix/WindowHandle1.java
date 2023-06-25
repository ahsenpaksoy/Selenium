package practiceMix;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WindowType;
import utilities.TestBase;

public class WindowHandle1 extends TestBase {
    @Test
    public void test01() {

        // 1. TechPro education sayfasinin titleinin "Techpro Education" metnini icerdigini test edin
        driver.get("https://techproeducation.com");
        Assert.assertTrue(driver.getTitle().contains("Techpro Education"));


        // 2. Yeni bir pencerede Amazon sayfasini acip titleinin "Amazon" metnini icerdigini test edin
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://amazon.com");
        Assert.assertTrue(driver.getTitle().contains("Amazon"));


        // 3. Yeni bir pencerede linkedin sayfasini acip titleinin "LinkedIn" metnini  icerdigini test edin
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://linkedin.com");
        Assert.assertTrue(driver.getTitle().contains("LinkedIn"));


    }
}
