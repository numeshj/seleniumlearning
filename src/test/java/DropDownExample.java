import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class DropDownExample {

    WebDriver driver;
    private static final long DEFAULT_SLEEP_MS = 2000L;
    @BeforeMethod
    public void openLinkTestPage() {

        ChromeOptions chromeOptions = new ChromeOptions();


        driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();

    }

    // helper to avoid declaring InterruptedException everywhere
    private void safeSleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            // optionally log
            System.out.println("sleep interrupted: " + e.getMessage());
        }
    }

    @Test
    public void leafGroundDropDown() {

        // 1.1 Base of select values of drop down
        driver.get("https://www.leafground.com/select.xhtml");
        WebElement dropdown = driver.findElement((By.xpath("//select[@class='ui-selectonemenu']")));
        Select select = new Select(dropdown);
        select.selectByIndex(1);
        safeSleep(DEFAULT_SLEEP_MS);
        // Selecting by visible text may throw NoSuchElementException if the text doesn't exist
        try {
            select.selectByVisibleText("Playwright");
            safeSleep(DEFAULT_SLEEP_MS);
            select.selectByVisibleText("Selenium");
            safeSleep(DEFAULT_SLEEP_MS);
            select.selectByVisibleText("Puppeteer");
            safeSleep(DEFAULT_SLEEP_MS);
            select.selectByVisibleText("Cypress");
            safeSleep(DEFAULT_SLEEP_MS);
        } catch (Exception ignored) {
            // ignore if an option isn't present during runtime
        }

        // 1.2 Get the number of options in the dropdown
        //generics
        List<WebElement> listOfOptions =  select.getOptions();
        int size = listOfOptions.size();
        System.out.println("Number of elements in the drop down : " + size);

        for (WebElement element:listOfOptions) {
            System.out.println(element.getText());
        }

        // 1.3 Select the dropdown using send keys
        dropdown.sendKeys("Puppeteer");
        safeSleep(DEFAULT_SLEEP_MS);

        //1.4 Selecting values in a boostrap dropdown
        WebElement dropdown2 =  driver.findElement(By.xpath("//div[@id='j_idt87:country']"));
        dropdown2.click();
        List<WebElement> listOfDropDownValues = driver.findElements(By.xpath("//ul[@id='j_idt87:country_items']/li"));
        for (WebElement element : listOfDropDownValues) {
            String dropDownValue = element.getText();
            if (dropDownValue.equals("USA")) {
                element.click();
                break;
            }
        }
    }

    @Test
    public void googleSearchDropDown() {
        // Open Google and type a query; then list suggestion texts
        driver.get("https://www.google.com/");
        List<WebElement> searchBoxes = driver.findElements(By.name("q"));
        if (searchBoxes.isEmpty()) {
            System.out.println("Search box not found on Google page");
            return;
        }
        WebElement searchBox = searchBoxes.get(0);
        searchBox.sendKeys("palitha");
        safeSleep(DEFAULT_SLEEP_MS);

        // Try to read suggestion items. The exact structure can change, so use a forgiving XPath.
        List<WebElement> suggestions = driver.findElements(By.xpath("//ul[@role='listbox']//li//div[@role='option']"));
        if (suggestions.isEmpty()) {
            System.out.println("No suggestions found");
        } else {
            System.out.println("Google suggestions:");
            for (WebElement s : suggestions) {
                System.out.println(" - " + s.getText());
            }
        }

        // Handle Hidden Auto Suggestions Drop Down and Search using DOM debugger Trick

    }


    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
