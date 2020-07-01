package base;

import com.google.common.io.Files;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import pages.HomePage;
import utils.EventReporter;
import utils.WindowManager;

import java.io.File;
import java.io.IOException;


public class BaseTest {

    protected EventFiringWebDriver driver;
    protected HomePage homePage;

    @BeforeClass
    public void openBrowser()   {
        System.setProperty("webdriver.chrome.driver","resources/chromedriver79.exe");

//        DesiredCapabilities ds = new DesiredCapabilities();
//        ds.setCapability(ChromeOptions.CAPABILITY, getChromeOptions());
        driver = new EventFiringWebDriver( new ChromeDriver(getChromeOptions()));
        driver.register(new EventReporter());

        driver.get("https://the-internet.herokuapp.com/");
        homePage = new HomePage(driver);
        goHome();
        setCookie();
        deleteCookie("rack.session");
    }

    @BeforeMethod
    public void goHome(){
        driver.get("https://the-internet.herokuapp.com/");
    }

    @AfterMethod
    public void recordFailure(ITestResult result) {

        if(ITestResult.FAILURE == result.getStatus())
        {
            System.out.println("This test failed ;) keep working");
            var camera= (TakesScreenshot)driver;

            File screenshot= camera.getScreenshotAs(OutputType.FILE);

            try{

                Files.move(screenshot,new File("resources/screenshots/" + result.getName() + ".png"));
            }catch (IOException e){
                e.printStackTrace();
                System.out.println(":0");
            }
        }


    }

    @AfterClass
    public void closeBrowser(){
        driver.close();
        System.out.println("Browser closed");
    }

    public WindowManager getWindowManager(){
        return new WindowManager(driver);
    }

    private ChromeOptions getChromeOptions(){

        ChromeOptions options = new ChromeOptions();

        options.addArguments("disable-infobars");


        //options.setHeadless(true);
        return options;
    }

    private void setCookie(){

        Cookie cookie = new Cookie.Builder("tau","123")
                .domain("the-internet.herokuapp.com").build();
        driver.manage().addCookie(cookie);
    }

    private void deleteCookie(String nameOfCookie){

        driver.manage().deleteCookieNamed(nameOfCookie);

    }

}
