package practiceMix;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Cookie;
import utilities.TestBase;

import java.util.Set;

public class Cookies extends TestBase {
    @Test
    public void handleCookies() {

        // Amazona git
        driver.get("https://amazon.com");

        // toplam cookie sayisini bul
        Set<Cookie> cookieSet = driver.manage().getCookies();
        int sayac = 1;
        for(Cookie w : cookieSet){
            System.out.println(sayac + ". cookie : " + w);
            System.out.println(sayac + ". cookieName : " + w.getName());
            System.out.println(sayac + ". cookieValue : " + w.getValue());
            sayac++;
        }
        System.out.println("Cookilerin Sayisi = " + cookieSet.size());

        // Bir Cookie yi ismiyle bul
        // ismi i18n-prefs olan cookie degerinin USD oldugunu test edin
        String actualCookieValue = driver.manage().getCookieNamed("i18n-prefs").getValue();
        String expectedCookieValue = "USD";
        Assert.assertEquals(expectedCookieValue,actualCookieValue);

        // Yeni bir cookie ekle
        // ismi “en sevdigim cookie” ve degeri “cikolatali” olan bir cookie olusturun ve sayfaya ekleyin
        Cookie cookie = new Cookie("en sevdigim cookie","cilekli");
        driver.manage().addCookie(cookie);

        // Bir Cookie yi ismiyle sil
        // ismi skin olan cookie’yi silin ve silindigini test edin
        int silinmedenOnce = cookieSet.size();
        System.out.println("Silinmeden Once Cookie Sayisi = "+silinmedenOnce);
        bekle(2);
        driver.manage().deleteCookieNamed("skin");//-->ismi skin olan cookie'yi sildik
        bekle(2);
        cookieSet = driver.manage().getCookies();//Silindikten sonra cookieSet'e yine atama yapiyoruz aksi taktirde fail aliriz
        int silindiktenSonra = cookieSet.size();
        System.out.println("Silindikten Sonra Cookie Sayisi = "+silindiktenSonra);
        Assert.assertEquals(1,(silinmedenOnce-silindiktenSonra));

        // tum cookie'leri silin ve silindigini test edin
        driver.manage().deleteAllCookies();
        cookieSet = driver.manage().getCookies();
        Assert.assertTrue(cookieSet.isEmpty());

    }
}

