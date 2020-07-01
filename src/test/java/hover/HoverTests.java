package hover;

import base.BaseTest;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class HoverTests extends BaseTest {


    @Test
    public void testHoverUser1(){
       var hoversPage = homePage.clickHovers();
       var caption = hoversPage.hoverOverFigure(1);

        assertTrue(caption.isCaptionDisplayed(),"Caption not Displayed");
        assertEquals(caption.getTitle(),"name: user1","Caption title incorrect");
        assertEquals(caption.getLinkText(),"View profile","Caption link text incorrect");
        assertTrue(caption.getLink().endsWith("/users/1"),"Link incorrect");


    }

    @Test
    public void testHoverUser2(){
        var hoversPage = homePage.clickHovers();
        var caption = hoversPage.hoverOverFigure(2);

        assertTrue(caption.isCaptionDisplayed(),"Caption not Displayed");
        assertEquals(caption.getTitle(),"name: user2","Caption title incorrect");
        assertEquals(caption.getLinkText(),"View profile","Caption link text incorrect");
        assertTrue(caption.getLink().endsWith("/users/2"),"Link incorrect");

    }

    @Test
    public void testHoverUser3(){
        var hoversPage = homePage.clickHovers();
        var caption = hoversPage.hoverOverFigure(3);

        assertTrue(caption.isCaptionDisplayed(),"Caption not Displayed");
        assertEquals(caption.getTitle(),"name: user3","Caption title incorrect");
        assertEquals(caption.getLinkText(),"View profile","Caption link text incorrect");
        assertTrue(caption.getLink().endsWith("/users/3"),"Link incorrect");
    }

}
