
import io.appium.java_client.AppiumDriver;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.support.ui.WebDriverWait;

import ru.apteka.config.DriverFactory;

public class TestBase {
    protected static AppiumDriver driver;
    public static WebDriverWait wait;
    private static final DriverFactory driverFactory = new DriverFactory();

    @BeforeAll
    public static void setupDriver() {
        driver = driverFactory.createDriver();
        wait = new WebDriverWait(driver, 10);
    }

    @AfterAll
    public static void quitDriver() {
        driver.quit();
    }



}



