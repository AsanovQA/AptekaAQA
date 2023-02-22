package ru.apteka.config;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebElement;
import ru.apteka.properties.PropertyProvider;

public class DriverFactory {

    private final PropertyProvider propertyProvider = new PropertyProvider();
    private final DriverType driverType = new DriverType();
    Platform platform = propertyProvider.platform;

    public AppiumDriver<WebElement> createDriver() {
        return driverType.getDriver(platform, propertyProvider);
    }
}
