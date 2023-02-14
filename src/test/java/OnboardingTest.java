import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.apteka.pages.OnboardingScreen;

public class OnboardingTest extends TestBase{
    OnboardingScreen onboardingScreen = new OnboardingScreen(driver, wait);

    @Test
    public void equalsFirstOnboarding() {
        Assertions.assertEquals(onboardingScreen.getOnbListStr(0), onboardingScreen.getOnbDescription());
        onboardingScreen.isSelected_dot(0);
    }

    @Test
    public void tapNextBtn() {
        Assertions.assertEquals(onboardingScreen.getOnbListStr(0), onboardingScreen.getOnbDescription());
        onboardingScreen.tap_nextBtn().waitElement();
        Assertions.assertEquals(onboardingScreen.getOnbListStr(1), onboardingScreen.getOnbDescription());
    }

    @Test
    public void tapToDot() {
        Assertions.assertEquals(onboardingScreen.getOnbListStr(0), onboardingScreen.getOnbDescription());
        onboardingScreen.dclick(1).waitElement();
        Assertions.assertEquals(onboardingScreen.getOnbListStr(1), onboardingScreen.getOnbDescription());
        onboardingScreen.dclick(0).waitElement();
        Assertions.assertEquals(onboardingScreen.getOnbListStr(0), onboardingScreen.getOnbDescription());
    }

}
