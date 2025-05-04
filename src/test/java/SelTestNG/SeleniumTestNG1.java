package SelTestNG;
/*
Open app
Login
Logout
*/


import org.testng.annotations.Test;

public class SeleniumTestNG1 {
    //By default priority order is albhabetical. Then ...-2,-1,0,1,2,3....
    //if priority is 1,1 then execution order is alphabetical
    @Test(priority = 1)
    void openApp(){
        System.out.println("Opening the application");
    }
    @Test(priority = 2)
    void logIn(){
        System.out.println("Logging into application");
    }
    @Test(priority = 3)
    void logOut(){
        System.out.println("Logging out of application");
    }
}


