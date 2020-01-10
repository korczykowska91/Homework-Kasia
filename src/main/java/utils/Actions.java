package utils;

import managers.DriverBoss;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import reports.CustomReporter;

/**
 * Created by kamil.czerwonka on 08.12.2019.
 */
public class Actions {

    public static void click(WebElement element, String name){
        try {
            highlight(element);
            element.click();
        } catch (NoSuchElementException e) {
            Assert.fail("Element : '"+name+"' is not displayed on page");
        }
        CustomReporter.pass("Click on the : '" +name+"' was successfully completed");
    }

    public static void type(WebElement element, String text, String name){
        try {
            element.isDisplayed();
            highlight(element);
            element.clear();
            element.sendKeys(text);
        } catch (NoSuchElementException e) {
            Assert.fail("Element : '"+name+"' is not displayed on page");
        }
        CustomReporter.pass("Type in: '" +name+"' was successfully completed");
    }

    public static void elementIsDisplayed(WebElement element, String name){
        try {
            highlight(element);
            element.isDisplayed();
        } catch (NoSuchElementException e) {
            Assert.fail("Element : '"+name+"' is not displayed on page");
        }
        CustomReporter.pass("Element: '" +name+"' is displayed");
    }

    private static void highlight(WebElement element){
        JavascriptExecutor js = (JavascriptExecutor) DriverBoss.getInstance();
        js.executeScript("arguments[0].style.border='3px ridge green'", element);
    }

}
