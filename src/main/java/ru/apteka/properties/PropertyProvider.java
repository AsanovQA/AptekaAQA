package ru.apteka.properties;

import org.openqa.selenium.Platform;

public class PropertyProvider {
    private final String deviceName;
    private final String platformVersion;
    private final String platformName;
    private final String automationName;
    private final String appValue;
    private final String noResetOption;
    private final String fullReset;
    private final String permission;

    public Platform platform = Platform.ANDROID;
    public PropertyProvider() {
        PropertyReader propertyReader;
        final String androidPath = "src/main/resources/android.properties";
        final String configPath = "src/main/resources/config.properties";
        propertyReader = new PropertyReader(androidPath);
        deviceName = propertyReader.getPropertyByKey("deviceName");
        platformVersion = propertyReader.getPropertyByKey("platformVersion");
        platformName = propertyReader.getPropertyByKey("platformName");
        automationName = propertyReader.getPropertyByKey("automationName");
        appValue = propertyReader.getPropertyByKey("appValue");
        propertyReader = new PropertyReader(configPath);
        noResetOption = propertyReader.getPropertyByKey("noReset");
        fullReset = propertyReader.getPropertyByKey("fullReset");
        permission = propertyReader.getPropertyByKey("acceptAllPermission");

    }
    public String getDeviceName() {
        return deviceName;
    }
    public String getPlatformVersion() {
        return platformVersion;
    }
    public String getPlatformName() {
        return platformName;
    }
    public String getAutomationName() {
        return automationName;
    }
    public String getAppValue() {
        return appValue;
    }
    public String getNoResetOption() {
        return noResetOption;
    }
    public String getFullReset() {
        return fullReset;
    }

    public String getAcceptPermission() {
        return permission;
    }
}
