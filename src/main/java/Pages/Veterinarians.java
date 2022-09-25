package Pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;


public class Veterinarians extends Page_Base {
    protected WebDriver driver;

    public Veterinarians(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//table[@id='vets']//thead//tr//th")
    public List<WebElement> headers;

    @FindBy(xpath = "//table[@id='vets']//tbody//tr")
    public List<WebElement> rows;


    public void printHeader() {
        System.out.println("________VETERINARIANS TABLE_________");
        System.out.println("________________________________________");
        for (WebElement element : headers) {

            System.out.printf("%20s","|"+element.getText()+"|");

        }
        System.out.print("\n"+"________________________________________"+"\n");
    }


}
