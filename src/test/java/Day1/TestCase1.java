/* Test case1:
1. Launch the browser
2. Open URl(https://demo.opencart.com/
3. validate title should be "Your Store"
 */
package Day1;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class TestCase1 {
    public static void main(String[] args){
        ChromeDriver driver = new ChromeDriver();
//        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.get("https://demo.nopcommerce.com/");
        driver.manage().window().maximize();

        String title=driver.getTitle();
        if(title.equals("nopCommerce demo store. Home page title")){
            System.out.println("Title is validated");
        }
        else{
            System.out.println("Title is not validated.");
        }

        driver.findElement(By.id("small-searchterms")).sendKeys("smartphone");
        driver.findElement(By.className("search-box-button")).click();
//        driver.close();
    }
}
