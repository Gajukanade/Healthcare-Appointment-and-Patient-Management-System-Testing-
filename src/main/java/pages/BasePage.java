package pages;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
	   protected WebDriver driver;
	    protected WebDriverWait wait;
	    protected JavascriptExecutor js;

	    public BasePage(WebDriver driver) {
	        this.driver = driver;
	        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        this.js = (JavascriptExecutor) driver;
	    }
	    
	    public void clickElement(WebElement element) {
	        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
	    }

	    public void sendKeys(WebElement element, String text) {
	        wait.until(ExpectedConditions.visibilityOf(element)).sendKeys(text);
	    }

	    public void scrollToElement(WebElement element) {
	        js.executeScript("arguments[0].scrollIntoView(true);", element);
	    }
	

}
