package ru.apteka.config;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;
import ru.apteka.properties.PropertyProvider;

import java.net.MalformedURLException;
import java.net.URL;

public class DriverType extends ConfigCapabilities {
    public AppiumDriver getDriver(Platform platform, PropertyProvider propertyProvider) {
        AppiumDriver driver;
        switch (platform) {
            case ANDROID -> driver = getAndroidDriver(propertyProvider);
            case IOS -> driver = getIOSDriver(propertyProvider);
            default -> throw new IllegalArgumentException("Platform is not set or recognized!");
        }
        return driver;
    }
    DesiredCapabilities capabilities = new DesiredCapabilities();
    private AppiumDriver getAndroidDriver(PropertyProvider propertyProvider) {
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, propertyProvider.getDeviceName());
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, propertyProvider.getPlatformName());
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, propertyProvider.getPlatformVersion());
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, propertyProvider.getAutomationName());
        capabilities.setCapability(MobileCapabilityType.APP, propertyProvider.getAppValue());
        capabilities.setCapability(AndroidMobileCapabilityType.AUTO_GRANT_PERMISSIONS, "true");
        capabilities.merge(setCommonCapabilities(capabilities));
        try {
            return new AndroidDriver(new URL("http://localhost:4723/wd/hub"), capabilities);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    private AppiumDriver getIOSDriver(PropertyProvider propertyProvider) {
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, propertyProvider.getDeviceName());
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, propertyProvider.getPlatformName());
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, propertyProvider.getPlatformVersion());
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, propertyProvider.getAutomationName());
        capabilities.setCapability(MobileCapabilityType.APP, propertyProvider.getAppValue());
        capabilities.setCapability(AndroidMobileCapabilityType.AUTO_GRANT_PERMISSIONS, "true");
        capabilities.merge(setCommonCapabilities(capabilities));
        try {
            return new IOSDriver<>(new URL("http://localhost:4723/wd/hub"), capabilities);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

}
