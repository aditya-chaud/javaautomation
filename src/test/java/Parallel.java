import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Parallel {
    WebDriver driver;
    @BeforeClass
    void openApp() throws InterruptedException{
        driver=new ChromeDriver();
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
    @DataProvider(name="testdatalogin", indices = {0,1})
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










//    @Test
//    void checkBook() throws InterruptedException {
//        WebElement bookApbtn=driver.findElement(By.xpath("//button[@id='btn-book-appointment']"));
//        boolean bookApBtn= bookApbtn.isDisplayed();
//        System.out.println("Booking button visibility status: " + bookApBtn);
//        Thread.sleep(3000);
//    }
}

/*
Parameterization in Selenium means running the same test case with
multiple sets of data — useful for testing forms, login credentials, or search inputs with different values.
Paramet.... can be achieved using
1. @DataProvider annotation: it is mainly used for (data driven testing).
2. Using XML file. Using this we can pass parameters to the test methods.
2 is used generally for (parallel testing).


Excel file----->store data 2d array---->pass in to DataProvider method--->then pass it to test method.(real life project).

DataProvider method is a method, through which we can pass test data to another test method.(It is a method having @DataProvider annotation.
We can pass this test data to more than one test methods.
we can also have multiple dataprovider method in a single class.(but can provide or pass multiple dataproviders to a single test method.
 */