package TestngAssertions;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Assertionn {
    @Test
    void checkTitle(){
        String reqtitle="orangelivemm";
        String captitle="orangelive";
//        if(reqtitle.equals(captitle)){
//            System.out.println("Test passed");
//        }
//        else{
//            System.out.println("Test failed");
//        }
        //Assert is a class than contains different methods
//        Assert.assertEquals(reqtitle, captitle);
        //or we can user like this
        if(reqtitle.equals(captitle)){
            System.out.println("Test passedgg");
//            Assert.assertTrue(true);
        }
        else{
            System.out.println("Test failed");
            Assert.assertTrue(false);
        }
    }
}


/*
Whenever you want a validation in the testng methods, we have to use assertions. Only assertions will make our test case passed or failed.
here, the if statement wont make the Test failed, and the output is not logged in report. So we need assertion.
All assertions are accessible from Assert class.

Kinds of Assertion
1. Hard Assertion
These are hard assertions (static methods), we can directly call from class. (No need for objects)
Assert.equals(2,3) test fail
Assert.NotEquals(2,2) test fail
Assert.True(1==1) test pass
Assert.False(1==2) test pass
Assert.fail() fails the test

Problem with hard assertion: when the assertion is failed, the rest of the code is not executed. This is where soft assertions comes into play. But 99% of time we use hard ass.

2. Soft Assertion
Soft assertion methods are also same as hard. However, the only difference is that object should be used to call the assertion methods.


SoftAsset is a predefined class, and all the methods present in the Assert class are present in this SoftAssert class.
These methods in SoftAssert class are not static, so we need object to call them.
SoftAssert sa= new SoftAssert();
sa.equals(2,3);
.....next lines of code...
sa.assertAll();--this method is must at the end.Otherwise soft assertion will never fail the test.
We cannot create object directly in the class. But only create variable.
*/