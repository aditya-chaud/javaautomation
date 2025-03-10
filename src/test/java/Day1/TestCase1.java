/* Test case1:
1. Launch the browser
2. Open URl(https://demo.opencart.com/
3. validate title should be "Your Store"
 */
package Day1;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;


public class TestCase1 {
    public static void main(String[] args){
        ChromeDriver driver = new ChromeDriver();

        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();

        String title=driver.getTitle();
        if(title.equals("Swag Labs")){
            System.out.println("Title is validated");
        }
        else{
            System.out.println("Wrong Title.");
        }

        driver.findElement(By.name("user-name")).sendKeys("standard_user");
        driver.findElement(By.name("password")).sendKeys("secret_sauce");
        driver.findElement(By.name("login-button")).click();
        System.out.println("hello world ia am aditya");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.close();

    }
}
