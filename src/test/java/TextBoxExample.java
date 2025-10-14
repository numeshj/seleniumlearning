import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TextBoxExample {

    WebDriver driver;
    @BeforeMethod
    public void openLinkTestPage() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.leafground.com/input.xhtml");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void TextBoxTest() {

        //01 Type your name
        WebElement name = driver.findElement(By.id("j_idt88:name"));
        name.sendKeys("Numesh Jayamanne");

        //02 Append Country to this City.
        WebElement appendText = driver.findElement(By.id("j_idt88:j_idt91"));
        appendText.sendKeys("India");

        //03 Verify if text box is disabled
        boolean enabled = driver.findElement(By.name("j_idt88:j_idt93")).isEnabled();
        System.out.println("Is the text box enabled ? " + enabled);

        //04 Clear the typed text.
        WebElement clearText = driver.findElement(By.xpath("//*[@id='j_idt88:j_idt95']"));
        clearText.clear();

        //05 Retrieve the typed text.
        WebElement retrieveText = driver.findElement(By.id("j_idt88:j_idt97"));
        String value = retrieveText.getAttribute("value");
        System.out.println("The typed text is : "+ value);

        //06 Type email and Tab. Confirm control moved to next element.
        WebElement email = driver.findElement(By.id("j_idt88:j_idt99"));
        email.sendKeys("numeshjayamanne@gmail.com"+ Keys.TAB + "Confirm control moved to next element");


    }



}
