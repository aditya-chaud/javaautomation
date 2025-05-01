package Frames;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

//Driver cannot go from page to frame. So driver need to be switched from page to frame.
//Cannot switch from one frame to another. Need to switch to default
public class HandleFrame {
    public static void main(String[] args){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--lang=en");  // Set browser language to English

        ChromeDriver driver=new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://ui.vision/demo/webtest/frames/");
        driver.manage().window().maximize();
        WebElement frame1=driver.findElement(By.xpath("//frame[@src='frame_1.html']"));
        //passed frame as WebElement
        driver.switchTo().frame(frame1);
        driver.findElement(By.xpath("//input[@name='mytext1']")).sendKeys("frame1");

        //switch to default before switching to next frame
        driver.switchTo().defaultContent();
        //Passed frame as index. Frame2
        //With multiple frames do not use index, because there is not any distinct frame index.
        driver.switchTo().frame(2);
        driver.findElement(By.xpath("//input[@name='mytext3']")).sendKeys("frame3");

        //inner iframe-part of frame3, since frame3 only has a single frame so it is good to use index. No need to switch back to page to switch to inner frame.
        driver.switchTo().frame(0);
        driver.findElement(By.xpath("//div[@id='i9']")).click();
        driver.findElement(By.xpath("//div[@id='i24']//div[@class='uHMk6b fsHoPb']")).click();

        //switching back to the main page
        driver.switchTo().defaultContent();



    }

}

//Types of switching
//1. Switching browser window: driver.switchTo().window("WindowID/Windowhandle")//getWindowHandle()
//2. Switching in alerts: .alert(), .accept(), .dismiss()
//3. Switching in Frames: .frame("id"), .frame("name"), .frame("WebElement")
















