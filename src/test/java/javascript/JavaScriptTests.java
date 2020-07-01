package javascript;

import base.BaseTest;
import org.testng.annotations.Test;

public class JavaScriptTests extends BaseTest {

    @Test
    public void testScrollToTable(){
        homePage.clickLargeAndDeepDome().scrollToTable();
    }

    @Test
    public void testScrollToFindFifthParagraph(){
        homePage.clickInfiniteScroll().scrollToParagraph(5);


    }
}
