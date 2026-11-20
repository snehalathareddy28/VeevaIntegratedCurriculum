package PracticalTopicWise.Daily_logs.Day42Testng;

import org.testng.annotations.Test;

/*
1)open app
2)LOGIN
3)LOGOUT
*/
public class FirstTestCase {

    @Test(priority = 1)
    void openapp()
    {
        System.out.println("opening the app successfully");
    }

    @Test(priority = 2)
    void Login(){
        System.out.println("login successful!");
    }

    @Test(priority = 3)
    void Logout(){
        System.out.println("Logout successful!");
    }
}
