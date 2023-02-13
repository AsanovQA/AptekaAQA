package ru.apteka.properties;

import org.openqa.selenium.Platform;

public class PropertyProvider {
    private final String deviceName;
    private final String platformVersion;
    private final String platformName;
    private final String automationName;
    private final String appValue;
//    private final String resetOption;
//    private final String fullReset;
//    private final String iosPath = "/src/resources/ios.properties";
    public Platform platform = Platform.ANDROID;
    public PropertyProvider() {
        final String androidPath = "/Users/timurasanov/IdeaProjects/AptekaAQA/src/main/resources/android.properties";
        PropertyReader propertyReader = new PropertyReader(androidPath);
        deviceName = propertyReader.getPropertyByKey("deviceName");
        platformVersion = propertyReader.getPropertyByKey("platformVersion");
        platformName = propertyReader.getPropertyByKey("platformName");
        automationName = propertyReader.getPropertyByKey("automationName");
        appValue = propertyReader.getPropertyByKey("appValue");
//        final String configPath = "/Users/timurasanov/IdeaProjects/AptekaAQA/src/main/resources/config.properties";
//        propertyReader = new PropertyReader(configPath);
//        resetOption = propertyReader.getPropertyByKey("resetOption");
//        fullReset = propertyReader.getPropertyByKey("fullReset");
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
//    public String getResetOption() {
//        return resetOption;
//    }
//    public String getFullReset() {
//        return fullReset;
//    }
}
