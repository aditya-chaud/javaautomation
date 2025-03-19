package Day1;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import java.util.List;

public class TestCase2 {
    public static void main(String[] args) throws InterruptedException{
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
        System.out.println(classElements.size());
        List<WebElement> links=driver.findElements(By.tagName("a"));
        System.out.println("Total linkes in this page "+links.size());
//        Thread.sleep(5000);

        //Check if the radio button is selected or not
        WebElement HP_Medicare=driver.findElement(By.xpath("//input[@id='radio_program_medicare']"));
        WebElement HP_Medicaid=driver.findElement(By.xpath("//input[@id='radio_program_medicaid']"));
        WebElement HP_None=driver.findElement(By.xpath("//input[@id='radio_program_none']"));

        //Before selection
        System.out.println("Before Selecting Radio buttons");
        System.out.println(HP_Medicare.isSelected());
        System.out.println(HP_Medicaid.isSelected());
        System.out.println(HP_None.isSelected());

        //After selection
        System.out.println("After Selecting Radio buttons");
        HP_Medicaid.click();
        System.out.println(HP_Medicare.isSelected());
        System.out.println(HP_Medicaid.isSelected());
        System.out.println(HP_None.isSelected());
    }
}
