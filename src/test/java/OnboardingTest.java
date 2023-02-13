import org.junit.Assert;
import org.junit.jupiter.api.Test;
import ru.apteka.pages.OnboardingScreen;

public class OnboardingTest extends TestBase{
    OnboardingScreen onboardingScreen = new OnboardingScreen(driver, wait);

    @Test
    public void equalsFirstOnboarding() {
        Assert.assertEquals(onboardingScreen.getOnbListStr(0), onboardingScreen.getOnbDescription());
        onboardingScreen.isSelected_dot(0);
    }

    @Test
    public void tapNextBtn() {
        Assert.assertEquals(onboardingScreen.getOnbListStr(0), onboardingScreen.getOnbDescription());
        onboardingScreen.tap_nextBtn().waitElement();
        Assert.assertEquals(onboardingScreen.getOnbListStr(1), onboardingScreen.getOnbDescription());
    }

    @Test
    public void tapToDot() {
        Assert.assertEquals(onboardingScreen.getOnbListStr(0), onboardingScreen.getOnbDescription());
        onboardingScreen.dclick(1).waitElement();
        Assert.assertEquals(onboardingScreen.getOnbListStr(1), onboardingScreen.getOnbDescription());
        onboardingScreen.dclick(0).waitElement();
        Assert.assertEquals(onboardingScreen.getOnbListStr(0), onboardingScreen.getOnbDescription());
    }

}
