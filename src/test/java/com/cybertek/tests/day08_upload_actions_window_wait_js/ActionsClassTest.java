package com.cybertek.tests.day08_upload_actions_window_wait_js;

import com.cybertek.utility.BrowserUtil;
import com.cybertek.utility.TestBase;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ActionsClassTest extends TestBase {

    @Test
    public void testHoverAction(){

        /**
         * //img[1]
         * (//div[@class= 'figure']/img)[1]
         */
        driver.get("http://practice.cybertekschool.com/hovers");

        // locate first image and hover over to the image
        WebElement img1Elm = driver.findElement(By.xpath("(//div[@class= 'figure']/img)[1]"));

        // Create instance of Actions class by passing driver object
        // its coming from here import org.openqa.selenium.interactions.Actions;
        Actions actions = new Actions(driver) ;
        actions.moveToElement(img1Elm).perform();

        BrowserUtil.waitFor(3);

        // and verify User profile 1 displayed with text "name: user1"
        WebElement firstProfileElm = driver.findElement(By.xpath("//h5[.='name: user1']"));
        assertTrue( firstProfileElm.isDisplayed()  ) ;

        // locate second image and hover over to the image
        WebElement img2Elm = driver.findElement(By.xpath("(//div[@class= 'figure']/img)[2]"));
        actions.moveToElement(img2Elm).perform();

        BrowserUtil.waitFor(3);

        actions.moveToElement(img1Elm).pause(2000)
                .moveToElement(img2Elm).pause(2000)
                .moveToElement(img1Elm).pause(2000)
                .moveToElement(img2Elm).pause(2000)
        .perform();



    }

    @Test
    public void testDragAndDrop(){
        driver.get("https://demos.telerik.com/kendo-ui/dragdrop/index");
        BrowserUtil.waitFor(2);

        WebElement smallCircle = driver.findElement(By.id("draggable"));
        WebElement biggerCircle = driver.findElement(By.id("droptarget"));

        //drag
        Actions actions = new Actions(driver);
        actions.dragAndDrop(smallCircle, biggerCircle).perform();

        BrowserUtil.waitFor(2);

        assertEquals("You did great!", biggerCircle.getText());





    }

    @Test
    public void testKeyboardAction(){
      // navigate to google.com
      // hold down to shift enter text "i love selenium"
      //release the shift
      // enter text "i love selenium
      // hold down to command on mac enter "A"
      // release the command
      //then hit backspace to delete
      driver.get(" https://www.google.com");
      // locate searchBox using name value q
        WebElement searchBox = driver.findElement(By.name("q"));
        // create Actions class instance
        Actions actions = new Actions(driver);
        //keyDown method for holding down to certain modifier key like Control, SHIFT and so on
        //keyUp method for releasing what you are holding down to
        //sendKeys method of Actions class is for pressing key that provided
        //pause method Actions class is for pausing in between actions in milliseconds

        // this is enough yo demonstraight
      //  actions.keyDown(Keys.SHIFT).sendKeys("  love selenium")
      //          .pause(2000).keyUp(Keys.SHIFT)
      //          .sendKeys(" i love selenium").pause(2000)
      //          .keyDown(Keys.COMMAND).sendKeys("A") // command +a on mac will select all text
      //          .perform();

        // this is way way way more than enough to demonstraight you can take keyboard actions
        actions.keyDown(Keys.SHIFT).sendKeys("i love selenium")
                .pause(2000).keyUp(Keys.SHIFT)
                .sendKeys(" i love selenium").pause(2000)
                .keyDown(Keys.COMMAND).sendKeys("A") // command +a on mac will select all text
                .keyDown(Keys.COMMAND).pause(2000)
                .sendKeys(Keys.BACK_SPACE)
                .pause(2000)
                .perform();


    }

    @Test
    public void testDoubleClick(){
        //navigate here
        //https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_ondblclick
        //double click on paragraph
        //then assert the new paragraph whit text "Hello world" displayed
        //both of the elements are under iframe with id iframeResult
        driver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_ondblclick");
        BrowserUtil.waitFor(2);
        //both elements are under the frame , so switch into it first
        driver.switchTo().frame("iframeResult");
        WebElement pElm1 = driver.findElement(By.xpath("//p[.='Double-click this paragraph to trigger a function.']"));
        // in order to double-click we will use actions class
        Actions actions = new Actions(driver);
        actions.doubleClick(pElm1).perform();//this is how we double-click

        BrowserUtil.waitFor(2);
    }

    @Test
    public void testRightClick(){
        //navigate to below url
        driver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_oncontextmenu");
        //locate the yellow area css selector div[contextmenu='mymenu']
        //first switch to the iframe
        driver.switchTo().frame("iframeResult");
        WebElement yellowArea = driver.findElement(By.cssSelector("div[contextmenu='mymenu']"));
        //right-click on that area using Actions class method
        Actions actions = new Actions(driver);
        actions.contextClick(yellowArea).perform();

        BrowserUtil.waitFor(1);
        //close
    }

}
