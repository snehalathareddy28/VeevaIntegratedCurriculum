package PracticalTopicWise.Daily_logs.Day43;

import org.testng.annotations.*;

public class AllAnnotations {
    @BeforeSuite
    void bs(){
        System.out.println("this is BeforeSuite...");
    }

    @AfterSuite
    void as(){
        System.out.println("this is AfterSuite...");
    }

    @BeforeTest
    void bt(){
        System.out.println("this is BeforeTest...");
    }

    @AfterTest
    void at(){
        System.out.println("this is AfterTest method...");
    }

    @BeforeMethod
    void bm(){
        System.out.println("this is Beforemethod...");
    }

    @AfterMethod
    void am(){
        System.out.println("THis is Aftermethod..");
    }

    @Test(priority = 1)
    void tm1(){
        System.out.println("this is test mentod1...");
    }
    void tm2(){
        System.out.println("this is test mentod2...");
    }

}
