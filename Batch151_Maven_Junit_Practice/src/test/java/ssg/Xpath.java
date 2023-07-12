package ssg;

import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class Xpath extends TestBase {
    @Test
    public void XpathTestleri() {
        driver.get("https://theautomationzone.blogspot.com/2020/07/xpath-practice.html");

        // XPATH Basics
        System.out.println(driver.findElement(By.xpath("//*[@id='id1']")).getText());
        System.out.println(driver.findElement(By.xpath("//*[@name='name1']")).getText());
        System.out.println(driver.findElement(By.xpath("//*[@value='value1']")).getText());
        System.out.println(driver.findElement(By.xpath("//p[@class='class1']")).getText());

        System.out.println(driver.findElement(By.xpath("//p[@name='a' and @id='a']")).getText());

        System.out.println(driver.findElement(By.xpath("//p[text()='unique id']")).getText());

        driver.findElement(By.xpath("//div[@id='divA']/*"));
        driver.findElement(By.xpath("//div[@id='divA']/input"));
        driver.findElement(By.xpath("//div[@id='divC']/span/input"));
        driver.findElement(By.xpath("//div[@id='divC']//input[@type='text']"));


        System.out.println(driver.findElement(By.xpath("//p[contains(text(),'logged in')]")));
        System.out.println(driver.findElement(By.xpath("//p[starts/with(text(),'logged in')]")));
        System.out.println(driver.findElement(By.xpath("(//label[@id='lable'])[last()]")));



    }
}
