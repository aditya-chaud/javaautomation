package Grouping;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Order {
    @Test(priority = 1, groups = {"sanity"})
    void orderLaptop(){
        System.out.println("Ordered laptops");
//        Assert.assertTrue(false);
    }
    @Test(priority = 2, groups = {"sanity, regression","functional"})
    void orderMobile(){
        System.out.println("Ordered phones");
    }
}
