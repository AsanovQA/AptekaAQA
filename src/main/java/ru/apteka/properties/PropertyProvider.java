package ru.apteka.properties;

import org.openqa.selenium.Platform;

public class PropertyProvider {
    private final String deviceName;
    private final String platformVersion;
    private final String platformName;
    private final String automationName;
    private final String appValue;
    private final String resetOption;
    private final String fullReset;
    private final String permission;

    public Platform platform = Platform.IOS;
    public PropertyProvider() {
        PropertyReader propertyReader = null;
        final String androidPath = "/Users/timurasanov/IdeaProjects/AptekaAQA/src/main/resources/android.properties";
        final String iOSPath = "/Users/timurasanov/IdeaProjects/AptekaAQA/src/main/resources/ios.properties";
        final String configPath = "/Users/timurasanov/IdeaProjects/AptekaAQA/src/main/resources/config.properties";
        switch (platform) {
            case ANDROID ->  propertyReader = new PropertyReader(androidPath);
            case IOS -> propertyReader = new PropertyReader(iOSPath);
        }
        deviceName = propertyReader.getPropertyByKey("deviceName");
        platformVersion = propertyReader.getPropertyByKey("platformVersion");
        platformName = propertyReader.getPropertyByKey("platformName");
        automationName = propertyReader.getPropertyByKey("automationName");
        appValue = propertyReader.getPropertyByKey("appValue");
        propertyReader = new PropertyReader(configPath);
        resetOption = propertyReader.getPropertyByKey("isReset");
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
    public String getResetOption() {
        return resetOption;
    }
    public String getFullReset() {
        return fullReset;
    }

    public String getAcceptPermission() {
        return permission;
    }
}
