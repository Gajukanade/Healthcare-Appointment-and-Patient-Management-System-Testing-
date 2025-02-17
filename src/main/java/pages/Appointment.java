//package pages;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//
//public class Appointment extends BasePage{
//
//	public Appointment(WebDriver driver) {
//		super(driver);
//		// TODO Auto-generated constructor stub
//	}
//
//	
//	private By homeclick = By.xpath("//svg[@aria-label='OpenMRS Logo']");
//	public void Homeclick() {
//        clickElement(driver.findElement(homeclick));
//    }
//	
//}

package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Appointment extends BasePage {

    // Locator for the SVG element
    private By homeclick = By.xpath("//svg[@aria-label='OpenMRS Logo']");

    // Constructor
    public Appointment(WebDriver driver) {
        super(driver);
    }

    // Method to click the Home button
    public void Homeclick() {
        try {
            // Locate the element using By and pass the WebElement to BasePage's clickElement
            WebElement homeElement = driver.findElement(homeclick);
            clickElement(homeElement); // Call BasePage's method to click the element
            System.out.println("Successfully clicked the home element.");
        } catch (Exception e) {
            System.err.println("Error: Unable to click the home element. " + e.getMessage());
        }
    }
}

