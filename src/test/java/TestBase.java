
import io.appium.java_client.AppiumDriver;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.support.ui.WebDriverWait;

import ru.apteka.config.DriverFactory;

public class TestBase {
    protected static AppiumDriver driver;
    public static WebDriverWait wait;
    private static final DriverFactory driverFactory = new DriverFactory();

    @BeforeClass
    public static void setupDriver() {
        driver = driverFactory.createDriver();
        wait = new WebDriverWait(driver, 10);
    }

    @AfterClass
    public static void quitDriver() {
        driver.quit();
    }



}



