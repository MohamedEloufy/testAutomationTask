package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class AddPetDetails extends Page_Base{
    public AddPetDetails(WebDriver driver) {
        super(driver);
    }
    @FindBy(id = "name")
    WebElement petName;

    @FindBy(id = "birthDate")
    WebElement petBirthDate;

    @FindBy(id = "type")
    WebElement typeMenu;

    @FindBy(xpath = "//div//button[@class='btn btn-default']")
    WebElement addBtn;



    public void addPet(String name,String date)
    {
        writeData(petName,name);
        writeData(petBirthDate,String.valueOf(date));
        select=new Select(typeMenu);
        select.selectByIndex(2);
    }
    public void clickOnAddPet()
    {
        clickOn(addBtn);
    }
}
