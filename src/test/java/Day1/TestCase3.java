package Day1;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.Set;

public class TestCase3 {
    public static void main(String[] args) throws InterruptedException {
        ChromeDriver driver=new ChromeDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.manage().window().maximize();
//        driver.findElement(By.xpath("//a[contains(text(), 'OrangeHRM, Inc')]")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//a[normalize-space()='OrangeHRM, Inc']")).click();
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[normalize-space()='OrangeHRM, Inc']")));
//        element.click();

//        String id=driver.getWindowHandle();
        Set<String> ids=driver.getWindowHandles();
        System.out.println(ids);
//        for(int i=0;i<ids.size();i++){
//            driver.close(ids[i+1]);
//        }
        WebElement logo=driver.findElement(By.xpath("//img[@alt='company-branding']"));
        System.out.println(logo.isDisplayed());
        WebElement username=driver.findElement(By.xpath("//input[@placeholder='Username']"));
        System.out.println(username.isEnabled());

    }
}
