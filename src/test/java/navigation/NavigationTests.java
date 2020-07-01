package navigation;

import base.BaseTest;
import org.testng.annotations.Test;

public class NavigationTests extends BaseTest {

    @Test
    public void testNavigator(){
        homePage.clickDynamicLoading().clickExample1();
        getWindowManager().goBack();
        getWindowManager().refreshPage();
        getWindowManager().goForward();
        getWindowManager().goTo("https://www.selenium.dev/selenium/docs/api/java/org/openqa/selenium/WebDriver.Navigation");
    }

    @Test
    public void testSwitch(){

        homePage.clickMultipleWindows().clickHere();
        getWindowManager().switchToTab("New Window");

    }
}
