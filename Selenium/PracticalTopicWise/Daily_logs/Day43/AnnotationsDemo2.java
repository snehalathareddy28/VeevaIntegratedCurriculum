package PracticalTopicWise.Daily_logs.Day43;

import org.testng.annotations.*;

/*
1)login -- @BeforeClass
2)Search -- @Test
3)Advanced search -- @Test
4)Logout -- @AfterClass
 */
public class AnnotationsDemo2 {
        @BeforeClass
        void login(){
            System.out.println("This is login...");
        }

        @Test
        void search(){
            System.out.println("This is search");
        }

        @Test
        void advancedSearch(){
            System.out.println("advanced search....");
        }

        @AfterClass
        void logout(){
            System.out.println("this is logout");
        }
    }

