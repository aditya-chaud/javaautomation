package SelTestNG;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Testclass1 {
    @Test
    void m1(){
        System.out.println("This is m1");
    }
    @BeforeTest
    void m2(){
        System.out.println("This is before test");
    }
    @BeforeSuite
    void m3(){
        System.out.println("This is before suite");
    }
    @AfterSuite
    void m4(){
        System.out.println("This is after suite");
    }
}
