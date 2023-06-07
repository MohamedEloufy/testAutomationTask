package Tests;

import Pages.DashboardPage;
import Util.jiraPolicy;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class ValidateSubscriptionPackageForKuwaitCountryTest extends TestBase {

    DashboardPage dashboardPage;


    @DataProvider(name = "PackagesData")
    public static Object[][] packages() {
        return new Object[][]{{"English","LITE","CLASSIC","PREMIUM","1.2 KWD/month", "2.5 KWD/month", "4.8 KWD/month"},};
    }
    @Test(dataProvider = "PackagesData")
    @jiraPolicy(logTicketReady = false)
    public void validateKSASubscriptionPackagesTypePrice(String webAppLanguage,String firstPackageType,String secondPackageType,String thirdPackageType,String litePackagePrice,String classicPackagePrice,String premiumPackagePrice)
    {
        dashboardPage=new DashboardPage(getDriver());
        dashboardPage.chooseWebAppLanguage(webAppLanguage);
        dashboardPage.openCountryAlert();
        dashboardPage.setCountryKuwait();
        SoftAssert soft=new SoftAssert();
        soft.assertEquals(dashboardPage.getLitePlanText(),firstPackageType);
        soft.assertEquals(dashboardPage.getClassicPlanText(),secondPackageType);
        soft.assertEquals(dashboardPage.getPremiumPlanText(),thirdPackageType);
        soft.assertEquals(dashboardPage.getLiteCurrency(),litePackagePrice);
        soft.assertEquals(dashboardPage.getClassicCurrency(),classicPackagePrice);
        soft.assertEquals(dashboardPage.getPremiumCurrency(),premiumPackagePrice);
        soft.assertAll();


    }
}
