package ru.apteka.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindAll;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class OnboardingScreen extends MainScreen {

    public OnboardingScreen(AppiumDriver<WebElement> driver, WebDriverWait wait) {
        super(driver, wait);
    }
    @AndroidFindBy(id = "next")
    MobileElement btn_next;
    @AndroidFindAll(value = {
            @AndroidBy(uiAutomator = "resourceIdMatches(\".*id/tab_layout\").childSelector(className(\"android.widget.LinearLayout\")).childSelector(className(\"android.widget.LinearLayout\").index(0))"),
            @AndroidBy(uiAutomator = "resourceIdMatches(\".*id/tab_layout\").childSelector(className(\"android.widget.LinearLayout\")).childSelector(className(\"android.widget.LinearLayout\").index(1))")
    })
    List<MobileElement> dotList;
    List<String> onbListStr = List.of (
            "Огромный выбор лекарств, косметики, линз, товаров для детей и гигиены - для здоровья и красоты",
            "Скидки до 50% 35 000 товаров для красоты и здоровья 25 000 аптек-партнеров");


    // Метод
     public boolean rotateToLandcape() {
        try {
            driver.rotate(ScreenOrientation.LANDSCAPE);
            return true;
        } catch (Exception e) {
            return false;
        }
     }

    public String getOnbListStr(int index) {
        return onbListStr.get(index);
    }

    public String getOnbDescription() {
         MobileElement elem = (MobileElement) driver.findElement(By.id("description"));
        return elem.getText().replaceAll("\\s", " ");
    }

    public OnboardingScreen waitElement() {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("description")));
        return this;
    }

    public OnboardingScreen tap_nextBtn() {
        btn_next.click();
        return this;
    }

    public OnboardingScreen dclick(int dotIndex) {
        dotList.get(dotIndex).click();
        return this;
    }

    public void isSelected_dot(int index) {
        dotList.get(index).isSelected();
    }
}
