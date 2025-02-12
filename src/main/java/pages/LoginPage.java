package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage {
	
    private By usernameField = By.id("username");
    private By continueButton = By.xpath("//button[text()='Continue']");
    private By passwordField = By.id("password");
    private By loginButton = By.xpath("//button[text()='Log in']");
	
	

	public LoginPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
    public void enterUsername(String username) {
        sendKeys(driver.findElement(usernameField), username);
    }

    public void clickContinue() {
        clickElement(driver.findElement(continueButton));
    }

    public void enterPassword(String password) {
        sendKeys(driver.findElement(passwordField), password);
    }

    public void clickLogin() {
        clickElement(driver.findElement(loginButton));
    }

}
