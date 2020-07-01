package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DynamicLoadingExample2Page {
    private WebDriver driver;

    private By startButton = By.cssSelector("#start button");
    private By loadingIndicator = By.id("loading");
    private By loadedText= By.id("finish");

    public DynamicLoadingExample2Page(WebDriver driver) {
        this.driver = driver;
    }


    public void clickStart(){
        driver.findElement(startButton).click();
        WebDriverWait wait = new WebDriverWait(driver,7);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(loadedText)));
    }

    public String getLoadedText(){
        return driver.findElement(loadedText).getText();
    }
}
