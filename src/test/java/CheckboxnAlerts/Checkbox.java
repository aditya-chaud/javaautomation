package CheckboxnAlerts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Checkbox {
    public static void main(String[] args) throws InterruptedException {
        ChromeDriver driver=new ChromeDriver();
        driver.get("https://testautomationpractice.blogspot.com/#");
        driver.manage().window().maximize();
        Thread.sleep(5000);

    //select specific(one) checkbox
        WebElement Wednesday=driver.findElement(By.xpath("//input[@id='wednesday']"));
        Wednesday.click();
    // select all checkbox
        List<WebElement> checkBoxes=driver.findElements(By.xpath("//input[@class='form-check-input' and @type='checkbox']"));
//        System.out.println(checkBoxes);
        // function1:use normal for loop to select all checkbox
//        normalLoop(checkBoxes);
        //function2: use enhanced for loop to select all checkbox. index cannot be used with this type of loop
//        enhancedLoop(checkBoxes);
        //function3: select only first 3 checkboxes
//        firstThree(checkBoxes);
        //function4: select only last 3 checkboxes
        lastThree(checkBoxes);
        Thread.sleep(4000);
        //function5: unselect the selected checkboxes, use isSelected() method.
        unSelect(checkBoxes);

    }

    // function1:use normal for loop to select all checkbox
    private static void normalLoop(ChromeDriver driver, List<WebElement> checkBoxes) {
        for(int i=0;i<checkBoxes.size();i++){
            checkBoxes.get(i).click();
        }
    }
    private static void enhancedLoop(List<WebElement> checkBoxes){
        for(WebElement checkBox:checkBoxes){
            checkBox.click();
        }
    }
    private static void firstThree(List<WebElement> checkBoxes) {
        for(int i=0;i<3;i++){
            checkBoxes.get(i).click();
        }
    }

    private static void lastThree(List<WebElement> checkBoxes){
//        int last=checkBoxes.size()-1;
//        int i=last;
        for(int i= checkBoxes.size()-1;i>=checkBoxes.size()-3;i--){
            checkBoxes.get(i).click();
        }
    }
    private static void unSelect(List<WebElement> checkBoxes){
        for(WebElement cbox:checkBoxes){
            if(cbox.isSelected()){
                cbox.click();
            }
        }
    }
}
