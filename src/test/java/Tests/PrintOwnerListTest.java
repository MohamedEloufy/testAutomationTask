package Tests;

import Pages.Home_Page;
import Pages.Owners;
import Util.jiraPolicy;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import utilities.ScreenRecordUtil;

public class PrintOwnerListTest extends Test_Base{

    Home_Page homePage;
    Owners owners;

    @jiraPolicy(logTicketReady = true)
    @Test
    @Severity(SeverityLevel.CRITICAL)
    public void openFindOwner() throws Exception {
        ScreenRecordUtil.startRecord("openFindOwner");
        homePage=new Home_Page(getDriver());
        homePage.openFindOwners();
        owners=new Owners(getDriver());
        owners.OpenOwner();
        owners.printOwnersHeader();
        for (int i = 1; i < owners.rows.size()+1; i++)
        {
            for (int j = 1; j < owners.headers.size()+1; j++) {

                WebElement element=
                        getDriver().findElement(By.xpath("//table[@id='owners']/tbody/tr["+i+"]/td["+j+"]"));
                System.out.printf("%20s","|"+element.getText()+"|");

            }
            System.out.print("\n"+"_________________________________________________________________________________________________"+"\n");

        }


        ScreenRecordUtil.stopRecord();
    }
}
