package Pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Home_Page extends Page_Base {
    public Home_Page(WebDriver driver) {
        super(driver);
        jes = (JavascriptExecutor) driver;
    }

    @FindBy(className = "img-responsive")
    public WebElement image;

    @FindBy(xpath = "//a[@title='find owners']")
    WebElement findOwners;


    @FindBy(xpath = "//a[@title='veterinarians']")
    WebElement veterinarians;


    public void openFindOwners() {
        clickOn(findOwners);
    }

    public void openVeterinarians() {
        clickOn(veterinarians);
    }
    public void openOwners()
    {
        clickOn(findOwners);
    }

}
