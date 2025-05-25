package Listenerss;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

//if you want to run this test without xml file
//@Listeners(Listenerss.Mylistener.class)
public class TestClas {
    @Test
    void setup(){
        Assert.assertTrue(true);
        System.out.println("setting up");
    }
    @Test(dependsOnMethods = {"setup"})
    void login(){
        Assert.assertTrue(false);
        System.out.println("login");
    }
    @Test(dependsOnMethods = {"login"})
    void logout(){
        Assert.assertTrue(true);
        System.out.println("Logout");
    }
}

/*
TestngListeners: Test methods can pass, fail or skipped. Based on these results, I want to perform certain actions, those actions are called Post Actions.
Only one Listener class should be used for a project
So, we can do those post actions using Testng Listeners. To perform those actions we need to create another class. this class will only have listeners methods not test methods.
Listener class will implements itestlistener interface or extends TestListenerAdapter class. Both of these interface and class contain same methods like ontestsuccess, ontestfailure etc are used for post actions.
Inside the xml file we should also mention this listener class
Listeners class methods are automatically triggered according to test status. no need to call explicitly.

Main purpose of Listeners is to generate the report. In selenium, extent report(is 3rd party report) is popular.

 */



