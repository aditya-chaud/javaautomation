package Day1;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;

import java.util.List;

public class TestCase2 {
    public static void main(String[] args){
        String username="John Doe";
        String password="ThisIsNotAPassword";
        ChromeDriver driver=new ChromeDriver();
        driver.get("https://katalon-demo-cura.herokuapp.com/");
        driver.manage().window().maximize();
        driver.findElement(By.id("btn-make-appointment")).click();
        driver.findElement(By.id("txt-username")).sendKeys(username);
        driver.findElement(By.id("txt-password")).sendKeys(password);
        driver.findElement(By.id("btn-login")).click();
        List<WebElement> classElements=driver.findElements(By.className("form-group"));
        System.out.println(classElements);
        System.out.println(classElements.size());

    }
}
