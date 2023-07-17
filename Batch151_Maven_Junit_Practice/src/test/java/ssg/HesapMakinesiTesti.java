package ssg;


import org.junit.*;

import java.util.ArrayList;
import java.util.List;

@Ignore("Bu test atlanıyor.")
public class HesapMakinesiTesti extends HesapMakinesi{
    @BeforeClass
    public static void beforeClass(){
        System.out.println("BeforeClass: Bu metot, her class'tan önce çalışır.");
    }

    @AfterClass
    public static void afterClass() throws Exception {
        System.out.println("AfterClass: Bu metot, her class'tan sonra çalışır.");
    }

    @Before
    public void setUp(){
        System.out.println("Before: Bu metot, her testten önce çalışır.");
    }

    @After
    public void tearDown(){
        System.out.println("After: Bu metot, her testten sonra çalışır.");
    }

    @Test
    public void toplamaTesti(){
        int sonuc = topla(5, 6);
        Assert.assertEquals(11, sonuc);
    }

    @Test
    public void cikarmaTesti(){
        int sonuc = cikar(5, 2);
        Assert.assertEquals(3, sonuc);
    }

    @Test(timeout = 500)
    public void carpmaTesti(){
        int sonuc = carp(2, 6);
        Assert.assertEquals(12, sonuc);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void bolmeTesti(){
        List<Integer> sayilar = new ArrayList<>();
        sayilar.add(1);
        System.out.println(sayilar.get(2));
    }

    @Ignore("Bu test atlanıyor.")
    @Test
    public void atlananTest(){
        System.out.println("Bu test atlanıyor");
    }
}

