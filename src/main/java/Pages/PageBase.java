package Pages;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;


public class PageBase {

    protected static WebDriver driver;
    public JavascriptExecutor jes;


    public Select select;


    public PageBase(WebDriver driver)
    {
        PageFactory.initElements(driver, this);
    }


    // Method : click on any element
    public static void clickOn(WebElement button)
    {
        button.click();
    }

    // Method : write data on text box
    public static void writeData(WebElement element, String value)
    {
        element.clear();
        element.sendKeys(value);
    }


    // Method : scroll to the bottom of the screen
    public void scrollToBottom()
    {
        jes.executeScript("scrollBy(0,2000)");
    }

    //Method : scroll to the top of the screen
    public void scrollToUP()
    {
        jes.executeScript("scrollBy(2000,0)");
    }



}
