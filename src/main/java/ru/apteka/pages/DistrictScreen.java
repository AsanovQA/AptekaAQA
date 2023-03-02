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
    public String district_toolbar = "Регион";
    public String tv_title_str = "Для корректного отображения цен в вашем регионе требуется выбрать город. По умолчанию цены актуальны для Москвы.";
    public String cancel_btn_str = "ПРОДОЛЖИТЬ";
    public String ok_btn_str = "ВЫБРАТЬ ГОРОД";

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
        search.sendKeys(cityName);
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
    public DistrictScreen districtListIsNotEmpty() {
        wait.until(ExpectedConditions.visibilityOf(toolbar));
        district_item.isDisplayed();
        return this;
    }
    public  DistrictScreen districtListIsEmpty() {
        wait.until(ExpectedConditions.visibilityOf(district_item)).isDisplayed();
        return this;
    }
    public void searchToCityNoAutoDest() {
        wait.until(ExpectedConditions.visibilityOf(city_no_autoDest)).isDisplayed();
    }
    public String getSearchString() {
        wait.until(ExpectedConditions.visibilityOf(search));
        return search.getText();
    }

    public String getTvTitleString() {
        return tv_title.getText().replaceAll("\\n", "");
    }
    public String getOkBtnStr() {
        return ok_btn_str;
    }
    public String getCancelBtnStr() {
        return cancel_btn_str;
    }
    public boolean dialogIsEmpty() {
        try {
            dialog_panel.isDisplayed();
        }
        catch (StaleElementReferenceException e) {
            return false;
        }
        return false;
    }
    public DistrictScreen delete_CityName() {
        search.clear();
        return this;
    }
    public String getDistrictTolbar() {
        wait.until(ExpectedConditions.visibilityOf(toolbar));
        return toolbar.getText();
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
    public void tapToCityWithName(String cityname) {
        wait.until(ExpectedConditions.visibilityOf(district_item));
        MobileElement city_wt_name = (MobileElement) driver.findElement(By.xpath("//android.widget.TextView[@text='"+cityname+"']"));
        ApplicationProperties.getInstance();
        ApplicationProperties.setSelectedDistrict(city_wt_name.getText());
        city_wt_name.click();
    }
}

