package com.cybertek.day01_navigation_locators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasicNavigation_LocalHTML_File {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        driver.get("file:///Users/eren/Desktop/HTML_Class/Day02.html");

        driver.quit();


    }
}
