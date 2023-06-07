package Tests;




import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

import java.time.Duration;

public class TestBase {


    public static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    @BeforeTest
    @Parameters({"browser", "url"})
    @Severity(SeverityLevel.BLOCKER)
    public void startDriver(@Optional("chrome") String browserName, String url) {
        if (browserName.equalsIgnoreCase("chrome")) {
            ChromeOptions options=new ChromeOptions();
            options.addArguments("--remote-allow-origins=*");

            driver.set(new ChromeDriver(options));


        } else if (browserName.equalsIgnoreCase("firefox")) {
            driver.set(new FirefoxDriver());


        } else if (browserName.equalsIgnoreCase("chrome-headless")) {

            ChromeOptions options = new ChromeOptions();
            options.addArguments("--headless");
            options.addArguments("window-size=1920,1080");
            driver.set(new ChromeDriver(options));
        }


        getDriver().manage().window().maximize();
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        getDriver().navigate().to(url);


    }

    public WebDriver getDriver() {
        return driver.get();
    }


    @AfterTest
    @Severity(SeverityLevel.MINOR)
    public void closeDriver() {

        getDriver().quit();

    }


}
