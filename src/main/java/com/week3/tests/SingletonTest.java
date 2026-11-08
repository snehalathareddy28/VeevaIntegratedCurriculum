
package com.week3.tests;

import com.week3.config.ConfigurationManager;

public class SingletonTest {

    public static void main(String[] args) {

        // Get the Singleton instance for the first time
        ConfigurationManager obj1 =
                ConfigurationManager.getInstance();

        // Get the Singleton instance again
        ConfigurationManager obj2 =
                ConfigurationManager.getInstance();

        // Call the method using obj1
        obj1.displayMessage();

        // Compare both object references
        System.out.println("Are both objects same? " + (obj1 == obj2));

    }
}
