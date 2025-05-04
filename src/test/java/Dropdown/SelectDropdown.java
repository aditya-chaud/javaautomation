package Dropdown;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SelectDropdown {
    public static void main(String[] args){
        ChromeDriver driver=new ChromeDriver();
        driver.get("https://testautomationpractice.blogspot.com/#");
        driver.manage().window().maximize();
        WebElement selectDrp = driver.findElement(By.xpath("//select[@id='country']"));
        Select select=new Select(selectDrp);

        select.selectByVisibleText("Canada");

    }
}
