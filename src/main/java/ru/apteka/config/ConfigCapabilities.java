package ru.apteka.config;

import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import ru.apteka.properties.PropertyProvider;
import ru.apteka.properties.PropertyReader;

public class ConfigCapabilities {
    PropertyProvider propertyProvider = new PropertyProvider();
    protected DesiredCapabilities setCommonCapabilities(DesiredCapabilities capabilities) {
        capabilities.setCapability(MobileCapabilityType.NO_RESET, propertyProvider.getResetOption());
        capabilities.setCapability(MobileCapabilityType.FULL_RESET, propertyProvider.getFullReset());
        return capabilities;
    }


}
