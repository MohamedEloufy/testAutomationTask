package Tests;

import Pages.DashboardPage;
import Util.jiraPolicy;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class ValidateSubscriptionPackageForBahrainCountryTest extends TestBase {

    DashboardPage dashboardPage;


    @DataProvider(name = "PackagesData")
    public static Object[][] packages() {
        return new Object[][]{{"English","LITE","CLASSIC","PREMIUM","2 BHD/month", "3 BHD/month", "6 BHD/month"},};
    }
    @Test(dataProvider = "PackagesData")
    @jiraPolicy(logTicketReady = false)
    public void validateKSASubscriptionPackagesTypePrice(String webAppLanguage,String firstPackageType,String secondPackageType,String thirdPackageType,String litePackagePrice,String classicPackagePrice,String premiumPackagePrice)
    {
        dashboardPage=new DashboardPage(getDriver());
        dashboardPage.chooseWebAppLanguage(webAppLanguage);
        dashboardPage.openCountryAlert();
        dashboardPage.setCountryBahrain();
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
