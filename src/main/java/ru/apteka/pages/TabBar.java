package ru.apteka.pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TabBar extends MainScreen{
    TabBar(AppiumDriver<WebElement> driver, WebDriverWait wait) {
        super(driver, wait);
    }
    
}
