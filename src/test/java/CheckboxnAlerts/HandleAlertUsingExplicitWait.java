package CheckboxnAlerts;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HandleAlertUsingExplicitWait{
    public static void main(String[] args) throws InterruptedException{
        ChromeDriver driver= new ChromeDriver();
        driver.get("https://testautomationpractice.blogspot.com/#");
        driver.manage().window().maximize();
        Thread.sleep(3000);

        WebDriverWait mywait=new WebDriverWait(driver, Duration.ofSeconds(1));
        driver.findElement(By.xpath("//button[@id='confirmBtn']")).click();
        Thread.sleep(2000);
        Alert alert=mywait.until(ExpectedConditions.alertIsPresent());
        alert.accept();

    }

}
