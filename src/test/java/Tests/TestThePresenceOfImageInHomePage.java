package Tests;

import Pages.Home_Page;
import Util.jiraPolicy;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestThePresenceOfImageInHomePage extends Test_Base {


    Home_Page homePage;

    @Test
    @jiraPolicy(logTicketReady = true)
    @Severity(SeverityLevel.NORMAL)
    @Link("https://eloufy.atlassian.net/browse/EL-26")
    @Description("Test the presence of image in dashboard screen" + "\n")
    @Step("Steps to reproduce bug :" + "\n"
            + "1_ Login with username:mohamed , password:Qwerty123 " + "\n"
            + "2_ Open dashboard screen" + "\n"
            + "3_ Wait until screen opened " + "\n"
            + "4_ Click on element X" + "\n"
            + "5_ Click on element y" + "\n"
            + "6_ Click on element z" + "\n")
    public void testPresenceOfImage() throws InterruptedException {

        homePage = new Home_Page(getDriver());
        Assert.assertTrue(homePage.image.isEnabled());
        Thread.sleep(5000);
        Assert.assertEquals(homePage.findOwners.getText(), "FIND OWNERS");


    }

}
