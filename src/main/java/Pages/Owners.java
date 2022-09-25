package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class Owners extends Page_Base{
    public Owners(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//button[@class='btn btn-default']")
    WebElement  findOwnerBtn;
    @FindBy(css = "a.btn.btn-default")
    WebElement addOwner;





    @FindBy(xpath = "//table[@id='owners']//thead//tr//th")
    public List<WebElement> headers;

    @FindBy(xpath = "//table[@id='owners']//tbody//tr")
    public List<WebElement> rows;




    public void OpenOwner()
    {
        clickOn(findOwnerBtn);
    }

    public void addOwnerScreen()
    {
        clickOn(addOwner);
    }

    public void printOwnersHeader() {
        System.out.println("_____________________________________OWNERS TABLE________________________________________________");
        System.out.println("_________________________________________________________________________________________________");
        for (WebElement element : headers) {

            System.out.printf("%20s","|"+element.getText()+"|");
        }
        System.out.print("\n"+"_________________________________________________________________________________________________"+"\n");
    }
}
