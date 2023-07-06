package erolHocaTasks;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Task02 {
    //BeforeClass methodu ile driver ı olusturun ve Maximize edin, 15 sn bekletin
    //Before methodunda http://www.google.com adresine gidin
    //Üç farklı test methodu ile;
    //arama kutusuna "The God Father" yazip, cikan sonuc sayisini yazdirin
    //arama kutusuna  "Lord of the Rings" yazip, cikan sonuc sayisini yazdirin
    //arama kutusuna  "Kill Bill" yazip, cikan sonuc sayisini yazdirin
    //After method'u ile başlıkları yazdırınız
    //AfterClass ile browser'ı kapatınız
    static WebDriver driver;

    //BeforeClass methodu ile driver ı olusturun ve Maximize edin, 15 sn bekletin
    @BeforeClass
    public static void beforeClass() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    //Before methodunda http://www.google.com adresine gidin
    @Before
    public void setUp() throws Exception {
        driver.get("http://www.google.com");
        driver.findElement(By.xpath("(//div[@class='QS5gu sy4vM'])[1]")).click();
    }

    //arama kutusuna "The God Father" yazip, cikan sonuc sayisini yazdirin
    @Test
    public void test01() {
        WebElement aramaKutusu = driver.findElement(By.xpath("//*[@class='gLFyf']"));
        aramaKutusu.sendKeys("The God Father", Keys.ENTER);
        WebElement theGodFather =  driver.findElement(By.cssSelector("div#result-stats"));
        String [] sonucYazisi = theGodFather.getText().split(" ");
        System.out.println("TheGodFather arama sonucu : "+ sonucYazisi[1]);
    }

    //arama kutusuna  "Lord of the Rings" yazip, cikan sonuc sayisini yazdirin
    @Test
    public void test02() {
        WebElement aramaKutusu = driver.findElement(By.xpath("//*[@class='gLFyf']"));
        aramaKutusu.sendKeys("Lord of the Rings",Keys.ENTER);
        WebElement lordOfTheRings = driver.findElement(By.xpath("//*[@id='result-stats']"));
        String [] sonucYazisi = lordOfTheRings.getText().split(" ");
        System.out.println("lordOfTheRings arama sonucu : "+ sonucYazisi[1]);

    }

    //arama kutusuna  "Kill Bill" yazip, cikan sonuc sayisini yazdirin
    @Test
    public void test03() {
        WebElement aramaKutusu = driver.findElement(By.xpath("//*[@class='gLFyf']"));
        aramaKutusu.sendKeys("Kill Bill", Keys.ENTER);
        WebElement killBill = driver.findElement(By.xpath("//*[@id='result-stats']"));
        String [] sonucYazisi = killBill.getText().split(" ");
        System.out.println("killBill arama sonucu : "+ sonucYazisi[1]);
    }

    //After method'u ile başlıkları yazdırınız
    @After
    public void tearDown() throws Exception {
        System.out.println(driver.getTitle());
    }

    //AfterClass ile browser'ı kapatınız

    @AfterClass
    public static void afterClass() throws Exception {
       // driver.close();
    }
}


   /*

     import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;
public class A03_Task02 {
    static WebDriver driver;
    //BeforeClass methodu ile driver ı olusturun ve Maximize edin, 15 sn bekletin
    @BeforeClass
    public static void beforeClass() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    //Before methodunda http://www.google.com adresine gidin
    @Before
    public void setUp() throws Exception {
        driver.get("http://www.google.com");
    }
    //Üç farklı test methodu ile;
    //arama kutusuna "The God Father" yazip, cikan sonuc sayisini yazdirin
    @Test
    public void theGodFather() {
        driver.findElement(By.xpath("//div//textarea")).sendKeys("The God Father", Keys.ENTER);
        String result[] = driver.findElement(By.cssSelector("div#result-stats")).getText().split(" ");
        System.out.println("The God Father sonuc sayisi = "+result[1]);
    }
    //arama kutusuna  "Lord of the Rings" yazip, cikan sonuc sayisini yazdirin
    @Test
    public void lordOfTheRings() {
        driver.findElement(By.xpath("//div//textarea")).sendKeys("Lord of the Rings", Keys.ENTER);
        String result[] = driver.findElement(By.cssSelector("div#result-stats")).getText().split(" ");
        System.out.println("Lord of the Rings sonuc sayisi = " + result[1]);
    }
    //arama kutusuna  "Kill Bill" yazip, cikan sonuc sayisini yazdirin
    @Test
    public void killBill() {
        driver.findElement(By.xpath("//div//textarea")).sendKeys("Kill Bill", Keys.ENTER);
        String result[] = driver.findElement(By.cssSelector("div#result-stats")).getText().split(" ");
        System.out.println("Kill Bill sonuc sayisi = "+result[1]);
    }
    //After method'u ile başlıkları yazdırınız
    @After
    public void tearDown() throws Exception {
        System.out.println(driver.getTitle());
    }
    //AfterClass ile browser'ı kapatınız
    @AfterClass
    public static void afterClass() throws Exception {
        driver.close();
    }
}

    */



















