package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OwnerDetailsPage extends Page_Base{
    public OwnerDetailsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[@class='container xd-container']//a[2]")
    WebElement addNewPet;

    public void clickOnAddPet()
    {
        clickOn(addNewPet);
    }
}
