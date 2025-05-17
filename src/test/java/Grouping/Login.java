package Grouping;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Login {
    @Test(priority = 1, groups = {"sanity"})
    void loginByFacebook(){
        System.out.println("logged in by facebook");
//        Assert.assertTrue(false);
    }
    @Test(priority = 2, groups = {"sanity"}, dependsOnMethods = {"loginByFacebook"})
    void loginByGmail(){
        System.out.println("logged in by gmail");
    }
    @Test(priority = 3, groups = {"sanity"})
    void loginByTwitter(){
        System.out.println("logged in by twitter");
    }
}
