package com.cybertek.day01_navigation_locators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BasicNavigation_FireFox {

    public static void main(String[] args) {

        WebDriverManager.firefoxdriver().setup();

        WebDriver driver = new FirefoxDriver();

        System.out.println("About to quit");

        driver.quit();
    }
}
