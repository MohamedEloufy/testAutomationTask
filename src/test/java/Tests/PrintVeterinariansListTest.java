package Tests;

import Pages.Home_Page;
import Pages.Veterinarians;
import Util.jiraPolicy;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PrintVeterinariansListTest extends Test_Base{

    Home_Page homePage;
    Veterinarians ver;

    @Test
    @jiraPolicy(logTicketReady = true)
    @Severity(SeverityLevel.NORMAL)
    @Link("https://eloufy.atlassian.net/browse/EL-26")
    @Description("PRINT LIST" + "\n")
    @Step("Steps to reproduce bug :" + "\n"
            + "1_ Login with username:mohamed , password:Qwerty123 " + "\n"
            + "2_ Open dashboard screen" + "\n"
            + "3_ Wait until screen opened " + "\n"
            + "4_ Click on element X" + "\n"
            + "5_ Click on element y" + "\n"
            + "6_ Click on element z" + "\n")
    public void printVeterinarians() {
        homePage = new Home_Page(getDriver());
        homePage.openVeterinarians();

        ver = new Veterinarians(getDriver());

    }
}
