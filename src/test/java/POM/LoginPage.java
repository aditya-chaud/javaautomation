package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

//page object class without creating page factory
public class LoginPage {
    WebDriver driver;
    //constructor or initiate driver instance
    LoginPage(WebDriver driver){
        this.driver=driver;
    }
    //locators

    By txt_username=By.xpath("//input[@placeholder='Username']");
    By txt_password=By.xpath("//input[@placeholder='Password']");
    By btn_login=By.xpath("//button[normalize-space()='Login']");

    //Action methods
    public void setUsername(String username){
        driver.findElement(txt_username).sendKeys(username);
    }
    public void setPassword(String password){
        driver.findElement(txt_password).sendKeys(password);
    }
    public void clickLogin(){
        driver.findElement(btn_login).click();
    }
}





/*
Page Object Model is a design pattern where we create separate class for locators or webelements, test methods, test data, validation etc.
Pros:
Reduces the duplication.
Maintenance is easy
POM pattern
For every page, there is dedicated class which will only contain page elements and corresponding actions.
THen in test methods we have only test nethods and validation for that page.
Approaches to create Page Object classes
1. without using PageFactory
2. using PageFactory
 */
