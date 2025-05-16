package SelTestNG;

import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class Testclass2 {
    @Test
    void n1(){
        System.out.println("This is n1");
    }
    @AfterTest
    void n2(){
        System.out.println("This is after test");
    }
}
