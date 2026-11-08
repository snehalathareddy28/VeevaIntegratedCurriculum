
package com.week3.config;

public class ConfigurationManager {

    // One shared instance
    private static final ConfigurationManager instance =
            new ConfigurationManager();

    // Private constructor
    private ConfigurationManager() {
        System.out.println("Configuration Manager created successfully");
    }

    // Public access method
    public static ConfigurationManager getInstance() {
        return instance;
    }

    public void displayMessage() {
        System.out.println("Using Configuration");
    }
}
