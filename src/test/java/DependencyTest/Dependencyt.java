package DependencyTest;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Dependencyt {
    @Test(priority = 1)
    void openApp(){
        System.out.println("Opening the application");
        Assert.assertTrue(true);
    }

    @Test(priority = 2, dependsOnMethods = {"openApp"})
    void logIn(){
        System.out.println("Logging into application");
        Assert.assertTrue(false);
    }

    @Test(priority = 3, dependsOnMethods = {"logIn"})
    void search(){
        System.out.println("this is before search");
    }

    @Test(priority = 4, dependsOnMethods = {"logIn", "search"})
    void search2(){
        System.out.println("this is after search");
    }

    @Test(priority = 5, dependsOnMethods = {"logIn"})
    void logOut(){
        System.out.println("Logging out of application");
    }
}

/*
dependsOnMethods helps to skip the rest of the methods that are will not pass if the initial dependent methods do not pass. Like to be able to login you need to be
able to open the application. So if you are not able to open application then remaining other methods will be skipped with dependsOnMethods.
*/