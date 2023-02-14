package ru.apteka.action;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;

import java.time.Duration;

public class SwipeHelper {
    AppiumDriver driver;
    public SwipeHelper(AppiumDriver driver) {
        this.driver = driver;
    }

    public void swipe(Direction direction) {
        Dimension dims = driver.manage().window().getSize();
        int width = dims.width/2;
        int height = (int) (dims.height*0.9);
        swipeExecution(direction, width, height);
    }

    public void swipe(Direction direction, WebElement element) {
        Dimension dims = element.getSize();
        int width = dims.width/5;
        int height = dims.height/2;
        swipeExecution(direction, width, height);
    }

    public void swipeExecution(Direction direction, int width, int height) {
        Dimension dims = driver.manage().window().getSize();
        PointOption<?> point = PointOption.point(width, height);
        PointOption<?> end = switch (direction) {
            case LEFT -> PointOption.point((int) (width * 0.1), height);
            case RIGHT -> PointOption.point((int) (dims.width * 0.9), height);
            case UP -> PointOption.point(width, (int) (height * 0.7));
            case DOWN -> PointOption.point(width, (int) (dims.height * 0.1));
        };
        new TouchAction(driver)
                .press(point)
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(300)))
                .moveTo(end)
                .release()
                .perform();
    }
}
