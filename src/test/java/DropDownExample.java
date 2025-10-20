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
    @BeforeMethod
    public void openLinkTestPage() {

        ChromeOptions chromeOptions = new ChromeOptions();


        driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();

    }

    @Test
    public void leafGroundDropDown() throws InterruptedException {

        // 1.1 Base of select values of drop down
        driver.get("https://www.leafground.com/select.xhtml");
    WebElement dropdown = driver.findElement((By.xpath("//select[@class='ui-selectonemenu']")));
    Select select = new Select(dropdown);
    select.selectByIndex(1);
    Thread.sleep(2000);
    select.selectByVisibleText("Playwright");
    Thread.sleep(2000);
    select.selectByVisibleText("Selenium");
    Thread.sleep(2000);
    select.selectByVisibleText("Puppeteer");
    Thread.sleep(2000);
    select.selectByVisibleText("Cypress");
    Thread.sleep(2000);

        // 1.2 Get the number of options in the drop down
        //generics
        List<WebElement> listOfOptions =  select.getOptions();
        int size = listOfOptions.size();
        System.out.println("Number of elements in the drop down : " + size);

        for (WebElement element:listOfOptions) {
            System.out.println(element.getText());
        }

        // 1.3 Select the dropdown using send keys
        dropdown.sendKeys("Puppeteer");
        Thread.sleep(2000);

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
        driver.get("https://www.google.com/");
        driver.findElements(By.name("q")).get(0).sendKeys("palitha");
        Thread.sleep(2000);
        driver.findElements(By.xpath("))
    }



    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
