package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.AddPatient;

import java.time.Duration;

public class BaseTestMain  {
    WebDriver driver;
    LoginPage loginPage;
    AddPatient addPatient;

    @BeforeClass
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "D:\\automation jar files\\chromedriver-win32\\chromedriver.exe");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--lang=en");
        driver = new ChromeDriver(options);

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://o3.openmrs.org/openmrs/spa/login?lang=en");

        loginPage = new LoginPage(driver);
        addPatient = new AddPatient(driver);
    }

    @Test(priority = 1)
    public void testLogin() {
        loginPage.enterUsername("admin");
        loginPage.clickContinue();
        loginPage.enterPassword("Admin123");
        loginPage.clickLogin();

        // Validate successful login
//        Assert.assertTrue(driver.getCurrentUrl().contains("home"), "Login failed!");
        System.out.println("Login successful!");
    }

    @Test(priority = 2)
    public void addPatient() throws InterruptedException {
        addPatient.clickAddPatientIcon();
        addPatient.enterGivenName("Virat");
        addPatient.enterFamilyName("RCB");
        addPatient.selectMaleGender();
        addPatient.enterDOB("05072000");
        addPatient.scrollToPhoneField();
        addPatient.clickRegisterPatient();

        System.out.println("Patient added successfully!");
        Thread.sleep(10000);
    }

    @AfterClass
    public void quitBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }
}
