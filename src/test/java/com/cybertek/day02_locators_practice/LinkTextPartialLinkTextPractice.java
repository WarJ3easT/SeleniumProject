package com.cybertek.day02_locators_practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LinkTextPartialLinkTextPractice {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("http://practice.cybertekschool.com");

        //cilick on first link "a/b testing
        WebElement firstLnk = driver.findElement(new By.ByLinkText("A/B Testing"));
        firstLnk.click();

        driver.findElement(By.linkText("A/B Testing")).click();

        //navigate back to home page
        driver.navigate().back();

        //maximize screen here
        




    }
}
