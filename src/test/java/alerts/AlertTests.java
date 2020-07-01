package alerts;

import base.BaseTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class AlertTests extends BaseTest {

    @Test
    public void testAcceptAlert(){
        var alertsPage = homePage.clickJavaScripsAlerts();

        alertsPage.triggerAlert();
        alertsPage.alert_clickToAccept();
        assertEquals(alertsPage.getResult(),"You successfuly clicked an alert","Results text incorrect");

    }

    @Test
    public void testGetTextFromAlert(){

        var alertsPage= homePage.clickJavaScripsAlerts();

        alertsPage.triggerConfirm();
        String text = alertsPage.alert_getText();
        alertsPage.alert_clickToDismiss();
        assertEquals(text,"I am a JS Confirm","Alert text is incorrect");
    }

    @Test
    public void testSetInputInAlert(){
        var alertPage = homePage.clickJavaScripsAlerts();
        alertPage.triggerPrompt();

        String text = "TAU rocks!";
        alertPage.alert_setInput(text);
        alertPage.alert_clickToAccept();
        assertEquals(alertPage.getResult(),"You entered: " + text,"Result text is incorrect");

    }

}
