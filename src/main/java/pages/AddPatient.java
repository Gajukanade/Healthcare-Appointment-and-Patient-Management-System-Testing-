package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AddPatient extends BasePage {

    public AddPatient(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	private By addPatientIcon = By.xpath("//button[@name='AddPatientIcon']");
    private By givenNameField = By.id("givenName");
    private By familyNameField = By.id("familyName");
    private By maleGenderOption = By.xpath("//span[contains(text(),'Male')]");
    private By dobField = By.xpath("//div[@role='spinbutton']");
    private By phoneField = By.id("phone");
    private By registerPatientButton = By.xpath("//button[text() = 'Register patient']");

    public void clickAddPatientIcon() {
        clickElement(driver.findElement(addPatientIcon));
    }

    public void enterGivenName(String givenName) {
        sendKeys(driver.findElement(givenNameField), givenName);
    }

    public void enterFamilyName(String familyName) {
        sendKeys(driver.findElement(familyNameField), familyName);
    }

    public void selectMaleGender() {
        clickElement(driver.findElement(maleGenderOption));
    }

    public void enterDOB(String dob) {
        sendKeys(driver.findElement(dobField), dob);
    }

    public void scrollToPhoneField() {
        scrollToElement(driver.findElement(phoneField));
    }

    public void clickRegisterPatient() {
        clickElement(driver.findElement(registerPatientButton));
    }
}
