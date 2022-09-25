package Tests;

import Pages.Home_Page;
import Pages.Veterinarians;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class PrintVeterinariansList extends Test_Base{

    Home_Page homePage;
    Veterinarians ver;

    @Test
    @Severity(SeverityLevel.CRITICAL)
    public void printVeterinarians()
    {
        homePage=new Home_Page(getDriver());
        homePage.openVeterinarians();
        ver=new Veterinarians(getDriver());
        ver.printHeader();
        for (int i = 1; i < ver.rows.size()+1; i++)
        {
            for (int j = 1; j < ver.headers.size()+1; j++) {

                WebElement element=
                        getDriver().findElement(By.xpath("//table[@id='vets']/tbody/tr["+i+"]/td["+j+"]"));
                System.out.printf("%20s","|"+element.getText()+"|");

            }
            System.out.print("\n"+"___________________________________"+"\n");

        }


    }
}
