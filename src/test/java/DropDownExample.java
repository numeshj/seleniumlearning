import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DropDownExample {

    WebDriver driver;
    @BeforeMethod
    public void openLinkTestPage() {

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setBrowserVersion("135");


        driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.get("https://www.leafground.com/select.xhtml");
    }

    @Test
    public void leafGroundDropDown() throws InterruptedException {

        // 1.1 Base of select values of drop down
    WebElement dropdown = driver.findElement((By.xpath("//select[@class='ui-selectonemenu']")));
    Select select = new Select(dropdown);
    select.selectByIndex(1);
    Thread.sleep(2000);
    select.selectByValue("Playwright");
    Thread.sleep(2000);
    select.selectByVisibleText("Selenium");
    Thread.sleep(2000);

        // 1.2 Select the value "Selenium" from the drop down
        // 1.3 Confirm the selected value is displayed


    }
}
