package CheckboxnAlerts;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleAlert {
    public static void main(String[] args) throws InterruptedException {

        ChromeDriver driver=new ChromeDriver();
        driver.get("https://testautomationpractice.blogspot.com/#");
        driver.manage().window().maximize();
        Thread.sleep(3000);

//        //Simple alert
//        WebElement al1=driver.findElement(By.xpath("//button[@id='alertBtn']"));
//        al1.click();
//        Thread.sleep(3000);
//        Alert alert1=driver.switchTo().alert();
//        alert1.getText();
//        alert1.accept();
//        Thread.sleep(2000);
//
//        //Confirmation alert
//        driver.findElement(By.xpath("//button[@id='confirmBtn']")).click();
//        Thread.sleep(3000);
//        Alert alert2=driver.switchTo().alert();
//        alert2.getText();
//        alert2.dismiss();
//        Thread.sleep(3000);

        //Prompt Alert
        WebElement al3=driver.findElement(By.xpath("//button[@id='promptBtn']"));
        Thread.sleep(2000);
        al3.click();
        Thread.sleep(2000);
        Alert alert3=driver.switchTo().alert();
        alert3.getText();
        String alertText="Aditya";
        alert3.sendKeys(alertText);
        Thread.sleep(1000);
        alert3.accept();
        Thread.sleep(2000);
        //verify
        String text=driver.findElement(By.xpath("//p[@id='demo']")).getText();
        System.out.println(text);
        if(text.contains(alertText)){
            System.out.println("Validated the promptAlert");
        }
        else{
            System.out.println("Not validated");
        }
//        alert.dismiss();
        //Authentication popup
//        driver.get("https://username:password@jdlsfjlajfd.com");

    }
}
