package wait;

import base.BaseTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class WaitTests extends BaseTest {
    @Test
    public void testWaitingUntilHiddenExample1(){

        var loadingPage = homePage.clickDynamicLoading().clickExample1();
        loadingPage.clickStart();
        assertEquals(loadingPage.getLoadedText(),"Hello World!","Loaded text example1 is incorrect");

    }

    // it needs to go back on the parentpage

    @Test
    public void testWaitingUntilHiddenExample2(){

        var loadingPage = homePage.clickDynamicLoading().clickExample2();
        loadingPage.clickStart();
        assertEquals(loadingPage.getLoadedText(),"Hello World!","Loaded text example2 not correct");


    }


}
