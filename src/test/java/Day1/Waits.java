package Day1;



//Implicit Wait

//Thread.sleep(5000); this will wait for full 5 seconds for the particular element that is below it. Thus reducing the performance.

//single time/one statement
//it will not wait till maximum time if the element is available.
//Applicable for all elments once declared
//
//Cons: exception occurs when time is not sufficient.--for such elements use Explicit Wait where a condition is required.



import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Waits {
    public static void main(String[] args){
        ChromeDriver driver= new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();

        //implicit Wait
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
//
//        driver.findElement(By.xpath("//input[@id='user-name']"));
//        driver.findElement(By.xpath("//input[@id='password']"));

        //Explicit wait
        //Will wait for 5 seconds of the condition to be True. If the condition fails then exception occurs. Use try catch block to handle the exception
        //declaration
        WebDriverWait mywait=new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement txtusername=mywait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='user-name']")));
        txtusername.sendKeys("standard_user");
//        System.out.println("Username Webelement is: "+ txtusername);
        WebElement txtpassword=mywait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='password']")));
        txtpassword.sendKeys("secret_sauce");
        WebElement loginbtn=mywait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='login-button']")));
        loginbtn.click();

        driver.findElement(By.xpath("//div[normalize-space()='Sauce Labs Backpack']")).click();
        try{
            Thread.sleep(5000);
        }
        catch(InterruptedException e){
            throw new RuntimeException(e);
        }
        driver.close();




    }
}
