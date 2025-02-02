package tests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
    WebDriver driver;
    
    @BeforeClass
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "D:\\automation jar files\\chromedriver-win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://o3.openmrs.org/openmrs/spa/login");
    }
    
    @Test(priority = 1)
    public void testLogin() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement username = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username")));
        username.sendKeys("admin");

        WebElement continueBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Continue']")));
        continueBtn.click();

        WebElement password = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password")));
        password.sendKeys("Admin123");

        WebElement loginBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Log in']")));
        loginBtn.click();

        // Wait for dashboard or confirmation of login success
        wait.until(ExpectedConditions.urlContains("home"));  // Modify according to actual URL
        System.out.println("Login successful!");
    }
    
    @Test(priority = 2)
    public void addPatient() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        // Click on "Add Patient" icon
        WebElement iconClick = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@name='AddPatientIcon']")));
        iconClick.click();
        
        // Enter given name
        WebElement nameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("givenName")));
        nameField.sendKeys("Virat");
        
        // Enter family name
        WebElement familyName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("familyName")));
        familyName.sendKeys("RCB");
        
	    WebElement gender = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Male']")));
	    gender.click();
	    
	    WebElement dobField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("birthdate")));
	    dobField.click();
//	    dobField.sendKeys("01151995"); // Enter the birthdate
//	    dobField.sendKeys(Keys.ENTER); // Submit the date if required

	    

    }
    @Test(priority = 3)
    public void quitbr() {
//    	driver.quit();
    }
    
}















//package tests;
//
//import java.time.Duration;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.Keys;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//import org.testng.annotations.BeforeClass;
//import org.testng.annotations.Test;
//
//import io.github.bonigarcia.wdm.WebDriverManager;
//
////@Test
//public class BaseTest {
//	WebDriver driver;
//	
//@BeforeClass
//
//	public void setup() {
////		WebDriverManager.chromedriver().setup();
//		System.setProperty("webdriver.chrome.driver", "D:\\automation jar files\\chromedriver-win32\\chromedriver.exe");
//		driver = new ChromeDriver();
//		driver.manage().window().maximize();
//		driver.get("https://o3.openmrs.org/openmrs/spa/login");
//		
//	}
//	
//	
//	@Test(priority = 1)
//	public void testLogin() throws InterruptedException {
//	
//		
//		WebElement username = driver.findElement(By.id("username"));
//		username.sendKeys("admin");
//		Thread.sleep(5000);
//		
//		WebElement continueBtn = driver.findElement(By.xpath("//button[text() = \"Continue\"]"));
//		continueBtn.click();
//		
//		WebElement password = driver.findElement(By.id("password"));
//		password.sendKeys("Admin123");
//		
//		WebElement loginBtn = driver.findElement(By.xpath("//button[text() = \"Log in\"]"));
//		loginBtn.click();
//		Thread.sleep(5000);
//	}
//	
//	@Test(priority = 2)
//	public void addPatient() {
//	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
//
//	    WebElement iconclick = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@name = 'AddPatientIcon']")));
//	    iconclick.click();
//	    
//	    WebElement namefield = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("givenName")));
//	    namefield.sendKeys("virat");
//	    
//	    WebElement familyName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("familyName")));
//	    familyName.sendKeys("RCB");
//	    
//	    WebElement gender = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Male']")));
//	    gender.click();
//	    
//	    
//	    WebElement dobField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("birthdate")));
//	    dobField.clear(); // Clear if pre-filled
//	    dobField.sendKeys("01151995"); // Enter the birthdate
//	    dobField.sendKeys(Keys.ENTER); // Submit the date if required
//
//	}
//
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
////	@Test(priority = 2)
////	public void addPatient() {
////		
////		WebElement iconclick = driver.findElement(By.xpath("//button[@name = \"AddPatientIcon\"]"));
////		iconclick.click();
////		
////		WebElement namefield = driver.findElement(By.id("givenName"));
////		namefield.sendKeys("virat");
////	}
//}
//
