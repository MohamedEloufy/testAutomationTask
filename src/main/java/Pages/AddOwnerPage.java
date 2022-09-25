package Pages;

import com.github.javafaker.Number;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddOwnerPage extends Page_Base{
    public AddOwnerPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "firstName")
    WebElement firstName;

    @FindBy(id = "lastName")
    WebElement lastName;

    @FindBy(id = "address")
    WebElement addresss;

    @FindBy(id = "city")
    WebElement city;

    @FindBy(id = "telephone")
    WebElement telephone;

    @FindBy(xpath = "//div//button[@type='submit']")
    WebElement addOwnerBtn;


    public void submitAddOwner()
    {
        clickOn(addOwnerBtn);
    }


    public void addOwnerData(String fName, String lName, String address, String cityName, String number)
    {
        writeData(firstName,fName);
        writeData(lastName,lName);
        writeData(addresss,address);
        writeData(city,cityName);
        writeData(telephone, number);

    }

}
