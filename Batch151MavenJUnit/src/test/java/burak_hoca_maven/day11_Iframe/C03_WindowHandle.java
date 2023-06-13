package burak_hoca_maven.day11_Iframe;

import burak_hoca_maven.day10_TestBase.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WindowType;


public class C03_WindowHandle extends TestBase {

        //  https://www.techproeducation.com adresine gidiniz
        //  Title'ın "Techpro Education | Online It Courses & Bootcamps" olduğunu test edin

        //  Yeni bir pencere acıp,  https://www.youtube.com sayfasına gidiniz

        //  Yeni bir pencere acıp, https://www.linkedin.com sayfasına gidiniz

        //  techproeducation sayfasına geçiniz
        //  youtube sayfasına geçiniz
        //  linkedIn sayfasına geçiniz:

    @Test
    public void windowHandle() {

        //  https://www.techproeducation.com adresine gidiniz
        driver.get("https://www.techproeducation.com");

        bekle(3);

        /*
        techproeducation sayfasının handle degerini getWindowHandle(); methodu ile elde edebiliriz
         */

        String techproWindowHandle = driver.getWindowHandle();
        System.out.println("TECHPRO HANDLE: " + techproWindowHandle);

        //  Title'ın "Techpro Education | Online It Courses & Bootcamps" olduğunu test edin

        String actuelTitle = driver.getTitle();
        String expectedTitle = "Techpro Education | Online It Courses & Bootcamps";

        Assert.assertEquals(expectedTitle,actuelTitle);

        //  Yeni bir pencere acıp,  https://www.youtube.com sayfasına gidiniz

        driver.switchTo().newWindow(WindowType.WINDOW); // Yeni bir pencereye driver'ı tasır
        // WindowType.TAB ==> yeni sekme acar

        driver.get("https://www.youtube.com");

        bekle(3);

        String youTubeWindowHandle = driver.getWindowHandle();
        System.out.println("YOUTUBE HANDLE: " + youTubeWindowHandle);

        //  Yeni bir pencere acıp, https://www.linkedin.com sayfasına gidiniz

        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://www.linkedin.com");

        bekle(3);

        /*
        linkedin sayfasının handle degerini getWindowHandle(); methodu ile elde edecegiz
         */
        String linkedinWindowHandle = driver.getWindowHandle();
        System.out.println("LİNKEDİN HANDLE: " + linkedinWindowHandle);

        //  techproeducation sayfasına geçiniz
        driver.switchTo().window(techproWindowHandle);

        bekle(3);

        //  youtube sayfasına geçiniz
        driver.switchTo().window(youTubeWindowHandle);

        bekle(3);

        //  linkedIn sayfasına geçiniz:
        driver.switchTo().window(linkedinWindowHandle);

        bekle(3);
    }

}
