package NavigationalMethods;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class NavMethods {
    public static void main(String[] args) throws MalformedURLException, InterruptedException {
        ChromeDriver driver=new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();
//        WebDriverWait mywait=new WebDriverWait(driver, Duration.ofSeconds(5));
//        URL myUrl= null;
//        try {
//            myUrl = new URL("https://www.saucedemo.com/");
//        } catch (MalformedURLException e) {
//            throw new RuntimeException(e);
//        }
//        //here also, get method is called internally
//        driver.navigate().to(myUrl);
//        mywait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='user-name']")));
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        Thread.sleep(5000);
        driver.get("https://demoblaze.com/index.html");
        Thread.sleep(5000);


        driver.navigate().back();
        System.out.println(driver.getCurrentUrl());
        Thread.sleep(5000);
        driver.navigate().forward();
        Thread.sleep(5000);
        driver.navigate().refresh();
        System.out.println("Hello");


    }
}
