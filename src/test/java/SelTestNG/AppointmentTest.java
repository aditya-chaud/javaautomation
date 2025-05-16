package SelTestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;


public class AppointmentTest {
    WebDriver driver;
    @Test(priority = 1)
    void openApp() throws InterruptedException{
        driver=new ChromeDriver();
        driver.get("https://katalon-demo-cura.herokuapp.com/");
        driver.manage().window().maximize();
        Thread.sleep(3000);
    }

    @Test(priority = 2)
    void logIn(){
        String username="John Doe";
        String password="ThisIsNotAPassword";
        WebElement mkAppoin=driver.findElement(By.xpath("//a[@id='btn-make-appointment']"));
        mkAppoin.click();
        WebElement uname =  driver.findElement(By.xpath("//input[@id='txt-username']"));
        WebElement pword = driver.findElement(By.xpath("//input[@id='txt-password']"));
        uname.sendKeys(username);
        pword.sendKeys(password);
        WebElement login = driver.findElement(By.xpath("//button[@id='btn-login']"));
        login.click();
    }
    @Test(priority = 3)
    void checkBook() throws InterruptedException {
        WebElement bookApbtn=driver.findElement(By.xpath("//button[@id='btn-book-appointment']"));
        boolean bookApBtn= bookApbtn.isDisplayed();
        System.out.println("Booking button visibility status: " + bookApBtn);
        Thread.sleep(3000);
    }

    @Test(priority = 4)
    void logOut(){
        WebElement toggleBtn=driver.findElement(By.xpath("//i[@class='fa fa-bars']"));
        toggleBtn.click();
        WebElement logoutBtn=driver.findElement(By.xpath("//a[normalize-space()='Logout']"));
        logoutBtn.click();
    }
}

/*
To generate a TestNG report in IntelliJ after running a testng.xml file, you first need to ensure that the default report generation is enabled.
This can be done by navigating to Run in the top menu, selecting Edit Configurations, and then choosing the Listeners tab to enable default report generation.
Once enabled, running the testng.xml file will generate a report.
By default, TestNG saves all reports and respective HTML files in the Project -> test-output folder. If this folder does not exist, TestNG will create it.
 */

/*
Test Suite>Test Cases>Test Steps
xml file>classes>Test methods
*/

