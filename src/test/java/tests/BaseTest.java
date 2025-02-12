package tests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class BaseTest {
    WebDriver driver;

    @BeforeClass
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "D:\\automation jar files\\chromedriver-win32\\chromedriver.exe");
//        driver = new ChromeDriver();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--lang=en");
        driver = new ChromeDriver(options);
       

        driver.manage().window().maximize();
        driver.get("https://o3.openmrs.org/openmrs/spa/login?lang=en");
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

        // Validate successful login
        wait.until(ExpectedConditions.urlContains("home"));
        Assert.assertTrue(driver.getCurrentUrl().contains("home"), "Login failed!");
        System.out.println("Login successful!");
    }

    @Test(priority = 2)
    public void addPatient() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        JavascriptExecutor js = (JavascriptExecutor) driver;

        // Click on "Add Patient" icon
        WebElement iconClick = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@name='AddPatientIcon']")));
        iconClick.click();

        // Enter given name
        WebElement nameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("givenName")));
        nameField.sendKeys("Virat");

        // Enter family name
        WebElement familyName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("familyName")));
        familyName.sendKeys("RCB");

        // Select gender
        WebElement gender = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),'Male')]")));
        gender.click();

        // Enter date of birth
        WebElement dobField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@role='spinbutton']")));

        // Scroll into view and click using JavaScript
        js.executeScript("arguments[0].scrollIntoView(true);", dobField);
        try {
            dobField.sendKeys("05072000");
        } catch (ElementClickInterceptedException e) {
            System.out.println("ElementClickInterceptedException caught. Using JavaScriptExecutor to click.");
            js.executeScript("arguments[0].click();", dobField);
        }
//        WebElement year = driver.findElement(By.xpath("//input[contains(@id, 'react-aria')]"));
        Thread.sleep(3000);
        
        WebElement element = driver.findElement(By.id("phone"));
        js.executeScript("arguments[0].scrollIntoView(true);", element);
        
        WebElement regBtn = driver.findElement(By.xpath("//button[text() = 'Register patient']"));
        regBtn.click();
        
        
//        js = (JavascriptExecutor) driver;
//
//     // Clear the field using JavaScript
//     js.executeScript("arguments[0].value = '';", year);
//
//     // Enter the new value
//     js.executeScript("arguments[0].value = '2000';", year);

        System.out.println("Patient added successfully!");
    

//    WebElement prev = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@aria-label = 'Previous']")));
//    WebElement nextButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@aria-label='Next']")));
//    WebElement displayedMonth = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='calendar-header']//span[@class='month']")));
//    
//    String targetMonth ="July";
    
   
    }
    @AfterClass
    public void quitBrowser() {
//        if (driver != null) {
//            driver.quit();
//        }
    }
}
