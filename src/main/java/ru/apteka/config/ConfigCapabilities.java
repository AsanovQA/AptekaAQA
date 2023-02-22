package ru.apteka.config;

import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.IOSMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import ru.apteka.properties.ApplicationProperties;
import ru.apteka.properties.PropertyProvider;

public class ConfigCapabilities {
    PropertyProvider propertyProvider = new PropertyProvider();
    protected DesiredCapabilities setCommonCapabilities(DesiredCapabilities capabilities) {
        capabilities.setCapability(IOSMobileCapabilityType.AUTO_ACCEPT_ALERTS, propertyProvider.getAcceptPermission());
        capabilities.setCapability(AndroidMobileCapabilityType.AUTO_GRANT_PERMISSIONS, propertyProvider.getAcceptPermission());
        if (ApplicationProperties.getInstance().isOnboardingSeen()) {
            capabilities.setCapability(MobileCapabilityType.NO_RESET, propertyProvider.getNoResetOption());
        }
        capabilities.setCapability(MobileCapabilityType.FULL_RESET, propertyProvider.getFullReset());
        return capabilities;
    }


}
