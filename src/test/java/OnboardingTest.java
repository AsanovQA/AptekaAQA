import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import ru.apteka.pages.OnboardingScreen;
import ru.apteka.properties.ApplicationProperties;

@Tag("Android")
public class OnboardingTest extends TestBase{
    OnboardingScreen onboardingScreen = new OnboardingScreen(driver, wait);

    @Test
    public void equalsFirstOnboarding() {
        Assertions.assertEquals(onboardingScreen.getOnbListStr(0), onboardingScreen.getOnbDescription());
        onboardingScreen.isSelected_dot(0);
    }

    @Test
    public void tapNextBtn_inFirstOnboarding_appearanceSecondOnboarding() {
        Assertions.assertEquals(onboardingScreen.getOnbListStr(0), onboardingScreen.getOnbDescription());
        onboardingScreen.tap_nextBtn().waitElement();
        Assertions.assertEquals(onboardingScreen.getOnbListStr(1), onboardingScreen.getOnbDescription());
        onboardingScreen.tap_nextBtn();
    }

    @Test
    public void tapDot_inFirstOnboarding_appearanceSecondOnboarding_andReturn() {
        Assertions.assertEquals(onboardingScreen.getOnbListStr(0), onboardingScreen.getOnbDescription());
        onboardingScreen.dclick(1).waitElement();
        Assertions.assertEquals(onboardingScreen.getOnbListStr(1), onboardingScreen.getOnbDescription());
        onboardingScreen.dclick(0).waitElement();
        Assertions.assertEquals(onboardingScreen.getOnbListStr(0), onboardingScreen.getOnbDescription());
    }

    @BeforeAll
    public static void closeWithTrueOnboardingSeen() {
        ApplicationProperties.getInstance().setOnboardingSeen(true);
        System.out.println(ApplicationProperties.getInstance().isOnboardingSeen());
    }

}
