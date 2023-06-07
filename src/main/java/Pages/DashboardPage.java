package Pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.locators.RelativeLocator;


public class DashboardPage extends PageBase {
    public DashboardPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "name-lite")
    public WebElement litePlan;
    @FindBy(id = "name-classic")
    public WebElement classicPlan;
    @FindBy(id = "name-premium")
    public WebElement premiumPlan;
    @FindBy(id = "currency-lite")
    public WebElement liteCurrency;
    @FindBy(id = "currency-classic")
    public WebElement classicCurrency;
    @FindBy(id = "currency-premium")
    public WebElement premiumCurrency;
    @FindBy(className = "country-current")
    public WebElement countryCurrentBtn;
    @FindBy(id = "translation-btn")
    public WebElement languageBtn;
    @FindBy(id = "country-selct")
    public WebElement countrySelectAlert;
    @FindBy(id = "bh")
    public WebElement bahrainCountry;
    @FindBy(id = "sa")
    public WebElement ksaCountry;

    @FindBy(id = "kw")
    public WebElement kuwaitCountry;






    public void ClickOnchangeLanguage() {
        clickOn(languageBtn);
    }

    public void openCountryAlert() {
        clickOn(countryCurrentBtn);
    }

    public void setCountryBahrain() {
        clickOn(bahrainCountry);

    }

    public void setCountryKSA() {
        clickOn(ksaCountry);
    }

    public void setCountryKuwait() {
        clickOn(kuwaitCountry);
    }

    public String getLitePlanText() {

        return litePlan.getText();
    }


    public String getClassicPlanText() {
        return classicPlan.getText();
    }

    public String getPremiumPlanText() {
        return premiumPlan.getText();
    }

    public String getLiteCurrency() {
        return liteCurrency.getText();
    }

    public String getClassicCurrency() {
        return classicCurrency.getText();
    }

    public String getPremiumCurrency() {
        return premiumCurrency.getText();
    }

    public String getLanguage() {
        return languageBtn.getText();
    }

    public void chooseWebAppLanguage(String languageValue) {
        if (!getLanguage().equalsIgnoreCase(languageValue)) {
            System.out.println("Current language equals need language");
        } else {
            ClickOnchangeLanguage();
        }
    }


}
