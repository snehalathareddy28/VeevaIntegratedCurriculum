package PracticalTopicWise.Daily_logs.Day43;

import org.testng.Assert;
import org.testng.annotations.Test;

public class assertionsDemo {

    /*but writing testcases in the conditional statement the method will allways passes tests
    because,their will be no failed condition which will identified by the method if the method
    contains no error it will passes
     */

    /*Because of this we are using the assertions if the assertions fails test will also fail,
    if it passes the test will also be passed
     */

    @Test
    void testTitle(){
        String exp_title = "Opencart";
        String act_title = "Opencart";

        /*if(exp_title.equals(act_title)){
            System.out.println("test is passed");
        }
        else{
            System.out.println("test is failed");
        }*/
        //Assert.assertEquals(exp_title,act_title);
        Assert.assertEquals("xyz","xyz");
        Assert.assertEquals("abc",123);
       Assert.assertEquals("123",123);

        Assert.assertNotEquals("123",123);//true
        Assert.assertNotEquals(123,123);//false

        Assert.assertTrue(exp_title==act_title);//true
        Assert.assertTrue(1==1);//true
        Assert.assertTrue(1==2);//false

        Assert.assertFalse(1==1);//false
        Assert.assertFalse(1==2);//true

        Assert.fail(); //directly fails

    }



}
