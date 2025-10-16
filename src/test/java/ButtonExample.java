import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ButtonExample {

    WebDriver driver;
    @BeforeMethod
    public void openLinkTestPage() {

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setBrowserVersion("135");


        driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.get("https://www.leafground.com/button.xhtml");
    }

    @Test
    public void ButtonTest() {
        // 01 Click and Confirm title.
        driver.findElement(By.xpath("//button[@id='j_idt88:j_idt90']")).click();
        String expectedTitle = "Dashboard";
        String actualTitle = driver.getTitle();
        if (actualTitle.contains(expectedTitle)) {
            System.out.println("Actual title contains expected title. Test Passed!");
        } else {
            System.out.println("Actual title does not contain expected title. Test Failed!");
        }
//        Assert.assertEquals(actualTitle, expectedTitle, "Title does not match!");

        // 02 Find the position of the Submit button

        driver.navigate().back();
        WebElement getPosition =  driver.findElement(By.id("j_idt88:j_idt94"));
        Point  xyPosition = getPosition.getLocation();
        int x = xyPosition.getX();
        int y = xyPosition.getY();
        System.out.println("The position of the Submit button is : " + x + " and " + y);

        // 03 Find the color of the save button
        WebElement buttonColor = driver.findElement(By.id("j_idt88:j_idt96"));
        String color = buttonColor.getCssValue("background-color");
        System.out.println("The color of the Save button is : " + color);

        //  04 Find the height and width of this button
        WebElement buttonSize = driver.findElement(By.id("j_idt88:j_idt98") );
        int height = buttonSize.getSize().getHeight();
        int width = buttonSize.getSize().getWidth();
        System.out.println("The height of this button is : " + height);
        System.out.println("The width of this button is : " + width);

        // 03 Click and Confirm title (Image)
        // 04 How many rounded buttons are there?
        // 05 What is the position of the Submit button?
        // 06 What is the background color of the Save button?
        // 07 What is the font size of the Save button?
        // 08 Mouse over on the Image Button and confirm the message
        // 09 Click Me - Button without a name
    }




}
