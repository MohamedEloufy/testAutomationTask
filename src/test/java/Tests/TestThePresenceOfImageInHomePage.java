package Tests;

import Pages.Home_Page;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestThePresenceOfImageInHomePage extends Test_Base{

    Home_Page homePage;

    @Test
    @Severity(SeverityLevel.NORMAL)
    public void testPresenceOfImage()
    {
        homePage=new Home_Page(getDriver());
        Assert.assertTrue(homePage.image.isDisplayed());
    }
}
