package POM;

import com.aventstack.extentreports.reporter.configuration.Theme;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginTest {
    WebDriver driver;
    @BeforeClass
    void setup() throws InterruptedException{
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        Thread.sleep(3000);
        driver.manage().window().maximize();
        Thread.sleep(3000);
    }
    @Test
    void Login() throws InterruptedException{
        Loginpage2 lg=new Loginpage2(driver);
        lg.setUsername("Admin");
        lg.setPassword("admin123");
        lg.clickLogin();
//
//        Assert.assertEquals(driver.getTitle(), "OrangeHRM");
        Thread.sleep(3000);
    }
    @AfterClass
    void TearDown(){
        driver.quit();
    }

}
