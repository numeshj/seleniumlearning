import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class AlertExampleTest {

    WebDriver driver;
    WebDriverWait wait;

    @BeforeMethod
    public void setUp() {
        // ensure chromedriver binary is available
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        // You can add headless or other options if needed:
        // chromeOptions.addArguments("--headless=new");
        driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://www.leafground.com/alert.xhtml");
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void alertTest() {
        // 1) Simple Alert
        WebElement alertBox = wait.until(ExpectedConditions.elementToBeClickable(By.id("j_idt88:j_idt91")));
        alertBox.click();
        wait.until(ExpectedConditions.alertIsPresent());
        Alert simpleAlert = driver.switchTo().alert();
        simpleAlert.accept();

        // 2) Confirm Alert
        WebElement confirmBox = wait.until(ExpectedConditions.elementToBeClickable(By.id("j_idt88:j_idt93")));
        confirmBox.click();
        wait.until(ExpectedConditions.alertIsPresent());
        Alert confirmAlert = driver.switchTo().alert();
        // dismiss the confirm
        confirmAlert.dismiss();

        // 3) Prompt Dialog
        WebElement promptBox = wait.until(ExpectedConditions.elementToBeClickable(By.id("j_idt88:j_idt104")));
        promptBox.click();
        wait.until(ExpectedConditions.alertIsPresent());
        Alert promptAlert = driver.switchTo().alert();
        String alertText = promptAlert.getText();
        System.out.println("Alert text is : " + alertText);
        // assert there's some text in the prompt message
        Assert.assertTrue(alertText != null && !alertText.isEmpty(), "Prompt alert text should not be empty");
        promptAlert.sendKeys("Numesh Jayamanne");
        promptAlert.accept();

        // Optional: verify result on the page after accepting prompt
        // (example - depends on page behaviour)
        // WebElement result = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("resultElementId")));
        // Assert.assertTrue(result.getText().contains("Numesh"));
    }
}
