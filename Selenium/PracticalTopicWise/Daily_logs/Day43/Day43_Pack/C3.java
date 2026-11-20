package PracticalTopicWise.Daily_logs.Day43.Day43_Pack;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class C3 {

    @Test
    void pqr(){
        System.out.println("this is abc from C3...");
    }

    @BeforeSuite
    void bs(){
        System.out.println("this is Beforesuite method...");
    }

    @AfterSuite
    void as(){
        System.out.println("THis is Aftersuite method..");
    }
}
