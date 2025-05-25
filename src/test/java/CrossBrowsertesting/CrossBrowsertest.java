package CrossBrowsertesting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class CrossBrowsertest {
    WebDriver driver;
    @BeforeClass
    @Parameters({"browser"})
    void openApp(String br) throws InterruptedException{
        switch(br.toLowerCase()){
            case "firefox":
                FirefoxOptions options = new FirefoxOptions();
                options.setBinary("/usr/bin/firefox"); // Adjust this path to the correct one
                driver = new FirefoxDriver(options);
                break;
            case "chrome":
                driver=new ChromeDriver();
                break;
            default:
                System.out.println("Invalid browsernaem");
                return;
        }
        driver.get("https://katalon-demo-cura.herokuapp.com/");
        driver.manage().window().maximize();
        Thread.sleep(3000);
    }

    @Test(priority = 1, dataProvider = "testdatalogin")
        //since dataprovider is sending the data, so the test method should receive the data ie 2d array ie. username and password.
    void logIn(Object username, Object password) throws InterruptedException {
//        String username="John Doe";
//        String password="ThisIsNotAPassword";
        WebElement mkAppoin=driver.findElement(By.xpath("//a[@id='btn-make-appointment']"));
        mkAppoin.click();
        WebElement uname =  driver.findElement(By.xpath("//input[@id='txt-username']"));
        WebElement pword = driver.findElement(By.xpath("//input[@id='txt-password']"));
        uname.sendKeys(username.toString());
        pword.sendKeys(password.toString());
        WebElement login = driver.findElement(By.xpath("//button[@id='btn-login']"));
        login.click();
        Thread.sleep(3000);
        boolean status=driver.findElement(By.xpath("//button[@id='btn-book-appointment']")).isDisplayed();
        if(status){
            WebElement toggleBtn=driver.findElement(By.xpath("//i[@class='fa fa-bars']"));
            toggleBtn.click();
            WebElement logoutBtn=driver.findElement(By.xpath("//a[normalize-space()='Logout']"));
            logoutBtn.click();
            Assert.assertTrue(true);
        }
        else{
            Assert.fail();
        }
    }
    @Test(priority = 2)
    void end(){
        driver.close();
    }
    //DataProvider method always return 2 dimensional array. which is generally object.
    //here name is chosen for the dataproviider so that, the test method knows from which dataprovider the data is provided. This is must.
    //using indices we can allow only particular data in the array. The indices in the array starts from 0. here, 0,1 is not range it is just he index 0 and 1.
    @DataProvider(name="testdatalogin", indices = {0,1,2})
    Object[][] loginData(){
        //String data[][], here Object is chosen instead of String because, test data could be anything ie. number, boolean, string etc. So object takes anything.
        //in real scenario we get this data from excel file. We do not hardcode test date like thiss. Also we make separate class for dataproviders.
        Object data[][]={
                {"John Cena", "ThisIsNotAPassword"},
                {"Josh Brolin", "ThisIsAPassword"},
                {"John Doe", "ThisIsNotAPassword"}
        };
        return data;
    }

}
