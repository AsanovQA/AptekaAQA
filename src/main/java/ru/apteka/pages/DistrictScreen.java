package ru.apteka.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.apteka.properties.ApplicationProperties;

public class DistrictScreen extends MainScreen {
    public DistrictScreen(AppiumDriver<WebElement> driver, WebDriverWait wait) {
        super(driver, wait);
    }

    @AndroidFindBy(uiAutomator = "resourceIdMatches(\".*id/toolbar\").childSelector(className(\"android.widget.TextView\"))")
    MobileElement toolbar;
    @AndroidFindBy(id = "search_input")
    public MobileElement search;
    @AndroidFindBy(uiAutomator = "resourceIdMatches(\".*id/toolbar\").childSelector(className(\"android.widget.ImageButton\"))")
    MobileElement back_btn;
    @AndroidFindBy (id = "custom")
    MobileElement dialog_panel;
    @AndroidFindBy (id = "tv_title")
    MobileElement tv_title;
    @AndroidFindBy(id = "ok_btn")
    MobileElement dialog_okBtn;
    @AndroidFindBy(id = "cancel_btn")
    MobileElement cancel_btn;
    @AndroidFindBy(id = "city_layout")
    public MobileElement district_item;
    @AndroidFindBy(id = "city_no_autodest")
    MobileElement city_no_autoDest;
    @AndroidFindBy(id = "city_by_location_layout")
    MobileElement city_by_location;
    @AndroidFindBy(id = "permission_message")
    MobileElement permission_message;
    public void districtScreenIsDisplayed() {
        toolbar.isDisplayed();
        search.isDisplayed();
        district_item.isDisplayed();
    }
    public DistrictScreen tapSearchRoot() {
        search.click();
        return this;
    }
    public DistrictScreen sendDistrictKeys(String cityName) {
        search.clear();
        search.sendKeys(cityName);
        driver.hideKeyboard();
        return this;
    }
    public void tap_To_BackBtn() {
        back_btn.click();
    }
    public DistrictScreen skipDistrictDialog_isDisplayed() {
        dialog_panel.isDisplayed();
        tv_title.isDisplayed();
        dialog_okBtn.isDisplayed();
        cancel_btn.isDisplayed();
        return this;
    }
    public boolean districtListIsNotEmpty() {
        return wait.until(ExpectedConditions.visibilityOf(district_item)).isDisplayed();
    }
    public boolean districtListIsEmpty() {
        try {
       wait.until(ExpectedConditions.visibilityOf(district_item));
        } catch (Exception e) {
            return true;
        }
        return false;
    }
    public DistrictScreen tapToFindLocation() {
        city_by_location.click();
        return this;
    }
    public boolean locationPermissionIsDisplayed() {
        return permission_message.isDisplayed();
    }
    public DistrictScreen tapToOkBtn() {
        dialog_okBtn.click();
        return this;
    }
    public DistrictScreen tapToCancelBtn() {
        cancel_btn.click();
        return this;
    }
    public DistrictScreen tapBackPress() {
        driver.navigate().back();
        return this;
    }
    public void tapToCityWithName() {
        wait.until(ExpectedConditions.visibilityOf(district_item));
        MobileElement city_wt_name = (MobileElement) driver.findElement(By.xpath("//android.widget.TextView[@text='"+search.getText()+"']"));
        ApplicationProperties.getInstance();
        ApplicationProperties.setSelectedDistrict(city_wt_name.getText());
        city_wt_name.click();
    }
}

