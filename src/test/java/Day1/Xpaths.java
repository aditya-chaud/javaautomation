package Day1;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;

public class Xpaths {
    public static void main(String[] args){
        ChromeDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("");
    }
}