package Grouping;

import org.testng.annotations.Test;

public class Signup {
    @Test(priority = 2, groups = {"regression"})
    void signupByFacebook(){
        System.out.println("Signup by facebook");
    }
    @Test(priority = 1, groups = {"regression"})
    void signupByGmail(){
        System.out.println("Signup by gmail");
    }
    @Test(priority = 0, groups = {"regression"})
    void signUpByTwitter(){
        System.out.println("Sign up by twitter");
    }
}
