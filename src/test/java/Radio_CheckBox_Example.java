import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Radio_CheckBox_Example {

    private static final long DEFAULT_SLEEP_MS = 2000L;
    WebDriver driver;

    @BeforeMethod
    public void openLinkTestPage() {

        ChromeOptions chromeOptions = new ChromeOptions();
        driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
    }

    @Test
    public void radioTest() {

        //<<<<<<Radio Button >>>>>>
        // 1) Find the default selected radio button
        driver.get("https://www.leafground.com/radio.xhtml");
        boolean chromeRadioOption = driver.findElement(By.id("j_idt87:console2:0")).isSelected();
        boolean firefoxRadioOption = driver.findElement(By.id("j_idt87:console2:1")).isSelected();
        boolean safariRadioOption = driver.findElement(By.id("j_idt87:console2:2")).isSelected();
        boolean edgeRadioOption = driver.findElement(By.id("j_idt87:console2:3")).isSelected();

         if (chromeRadioOption) {
            String chromeTest = driver.findElement(By.xpath("//label[@for='j_idt87:console2:0']")).getText();
            System.out.println("The default selected radio button is : " + chromeTest);
    }


}
