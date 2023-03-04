package ru.apteka.tests.android;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import ru.apteka.pages.DistrictScreen;
@Tag("Android")
public class DistrictTest extends TestBase{
    DistrictScreen districtScreen = new DistrictScreen(driver, wait);
    @Test
    public void equalsDistrictScreen() {
        districtScreen
                .districtScreenIsDisplayed();
    }

    @Test
    public void input_unValidationValue_in_searchRoot() {
        districtScreen
                .tapSearchRoot()
                .sendDistrictKeys("!!#$%");
        districtScreen.districtListIsEmpty();
    }
    @Test
    public void input_validationValue_in_searchRoot() {
        districtScreen
                .tapSearchRoot()
                .sendDistrictKeys("Новосибирск");
        districtScreen.districtListIsNotEmpty();
    }
    @Test
    public void open_skipDistrict_dialog() {
        districtScreen
                .tapBackPress()
                .skipDistrictDialog_isDisplayed()
                .tapToOkBtn();
    }

    @Test
    public void tap_toDistrictListItem() {
        districtScreen.tapToCityWithName();
    }

}
