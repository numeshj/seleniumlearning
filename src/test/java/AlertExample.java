import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AlertExample {


    WebDriver driver;

    @BeforeMethod
    public void openLinkTestPage() {

        ChromeOptions chromeOptions = new ChromeOptions();
        driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.get("https://www.leafground.com/alert.xhtml");
    }

    @Test
    public void alertTest() throws InterruptedException {
        // 1) Alert (Simple Alert)


        WebElement alertBox = driver.findElement(By.id("j_idt88:j_idt91"));
        alertBox.click();
        Thread.sleep(2000);
        Alert alert = driver.switchTo().alert();
        alert.accept();

        // 2) Alert (Confirm Alert)
        WebElement confirmBox  = driver.findElement(By.id("j_idt88:j_idt93"));
        confirmBox .click();
        Thread.sleep(2000);
        Alert confirmAlert = driver.switchTo().alert();
        confirmAlert.dismiss();

        // 3) Alert (Prompt Dialog)
       WebElement  promptCox =  driver.findElement(By.id("j_idt88:j_idt104"));
         promptCox.click();
        Thread.sleep(2000);
        Alert alert2 = driver.switchTo().alert();
        String alertText = alert2.getText();
        System.out.println("Alert text is : " + alertText);
        alert2.sendKeys("Numesh Jayamanne");
        Thread.sleep(2000);
        alert2.accept();


    }






}
