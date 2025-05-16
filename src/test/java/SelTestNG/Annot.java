package SelTestNG;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Annot {
    @Test(priority = 1)
    void openApp(){
        System.out.println("Opening the application");
    }

    @BeforeClass
    void logIn(){
        System.out.println("Logging into application");
    }

    @AfterClass
    void logOut(){
        System.out.println("Logging out of application");
    }
    @Test
    void search(){
        System.out.println("this is before search");
    }
    @Test
    void search2(){
        System.out.println("this is after search");
    }
}

/*
Test.xml file
<Suite name ="TestSuite">
    <Test name="mytest1">
        <Classes>
            <class name="apttest"/>
        </Classes>
    </Test>
    <Test name="mytest2">
        <Classes>
            <class name="annottest"/>
        </Classes>
    </Test>

</Suite>
<!--there are two tests in the test suite TestSuite-->
@BeforeTest: The method having this annotation will run before these two test ie mytest1 and mytest2. It will execute only once. ie before all tests methods.
@AfterTest: The method having this annotation will run after these two test ie mytest1 and mytest2. It will execute only once after all test methods.
BeforeTest and AfterTest will run multiple times if there are multiple classes in each test. here before and after test will be executed two times.

<Suite name ="TestSuite">
    <Test name="mytest1">
        <Classes>
            <class name="apttest"/>
            <class name="apttest"/>
        </Classes>
    </Test>
    <Test name="mytest2">
        <Classes>
            <class name="annottest"/>
            <class name="annottest"/>
        </Classes>
    </Test>
</Suite>
*/















/*
@BeforeMethod, @AfterMethod
@BeforeClass, @AfterClass
For this two below we need xml file, more than 1 test case or more than one class
According to XML: Test is the collection of classes.
@BeforeTest, @AfterTest
@BeforeSuite, @AfterSuite
* */