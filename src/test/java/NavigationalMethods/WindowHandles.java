package NavigationalMethods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class WindowHandles {
    public static void main(String[] args) throws InterruptedException {
        ChromeDriver driver=new ChromeDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.manage().window().maximize();
        Thread.sleep(5000);
        WebElement childWindow=driver.findElement(By.xpath("//a[normalize-space()='OrangeHRM, Inc']"));
        childWindow.click();
        Thread.sleep(5000);
        Set<String> windowIds=driver.getWindowHandles();
        System.out.println(windowIds);
        List<String> mywindowIds=new ArrayList<>(windowIds);
        String parentId=mywindowIds.get(0);
        String childId=mywindowIds.get(1);
        System.out.println(parentId);
        System.out.println(childId);
        //this prints out parent window title
        System.out.println(driver.getTitle());
        //to get child window title, we need to switch window
        driver.switchTo().window(childId);
        System.out.println(driver.getTitle());

//        public void getCurrenturl(){
//            //If we have multiple windows
//            for(String ids:mywindowIds){
//                String title=driver.switchTo().window(ids).getTitle();
//                if(title.equals("Hujfdlasfj")){
//                    //run the commands for parent window
//                    System.out.println(driver.getCurrentUrl());
//                }
//            }
//        }
        //pass the title of the browser windwow that you want to perform action on.
        getCurrentUrlByTitle(driver, mywindowIds, "Human Resources Management Software | OrangeHRM HR Software");
    }

    public static void getCurrentUrlByTitle(ChromeDriver driver, List<String> windowIds, String expectedTitle) throws InterruptedException{
        for (String id : windowIds) {
            driver.switchTo().window(id);
            String title = driver.getTitle();

            if (title.equals(expectedTitle)) {
                System.out.println("Current URL of '" + title + "' is: " + driver.getCurrentUrl());
                //closes this browser window only.hrms|ohs
                driver.close();
                break;
            }
        }
    }
}

