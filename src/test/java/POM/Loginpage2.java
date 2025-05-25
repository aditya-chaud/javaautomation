package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

//page object class using PageFactory.... this is more common
public class Loginpage2 {
    WebDriver driver;
    //constructor or initiate driver instance
    Loginpage2(WebDriver driver){
        this.driver=driver;
        //using PageFactory we do not need to use driver on every locators.
        //Using PF, driver is applicable to all the locators.
        //init method will initiate all the elements using driver internally
        PageFactory.initElements(driver, this);
    }
    //locators
//single elements
    @FindBy(xpath = "//input[@placeholder='Username']") WebElement txt_username;
    @FindBy(xpath = "//input[@placeholder='Password']") WebElement txt_password;
    @FindBy(xpath = "//button[normalize-space()='Login']") WebElement btn_login;
    //multiple elements-alternative to findElements
    @FindBy(tagName = "a")
    List<WebElement> links;
    //Action methods

    public void setUsername(String username){
        txt_username.sendKeys(username);
    }
    public void setPassword(String password){
        txt_password.sendKeys(password);
    }
    public void clickLogin(){
        btn_login.click();
    }

}
