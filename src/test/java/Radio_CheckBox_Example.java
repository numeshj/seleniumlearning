import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class Radio_CheckBox_Example {

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

//        boolean chromeRadioOption = driver.findElement(By.id("j_idt87:console2:0")).isSelected();
//        boolean firefoxRadioOption = driver.findElement(By.id("j_idt87:console2:1")).isSelected();
//        boolean safariRadioOption = driver.findElement(By.id("j_idt87:console2:2")).isSelected();
//        boolean edgeRadioOption = driver.findElement(By.id("j_idt87:console2:3")).isSelected();
//
//        if (chromeRadioOption) {
//            String chromeTest = driver.findElement(By.xpath("//label[@for='j_idt87:console2:0']")).getText();
//            System.out.println("The default selected radio button is : " + chromeTest);
//        } else if (firefoxRadioOption) {
//            String firefoxTest = driver.findElement(By.xpath("//label[@for='j_idt87:console2:1']")).getText();
//            System.out.println("The default selected radio button is : " + firefoxTest);
//        } else if (safariRadioOption) {
//            String safariTest = driver.findElement(By.xpath("//label[@for='j_idt87:console2:2']")).getText();
//            System.out.println("The default selected radio button is : " + safariTest);
//        } else if (edgeRadioOption) {
//            String edgeTest = driver.findElement(By.xpath("//label[@for='j_idt87:console2:3']")).getText();
//            System.out.println("The default selected radio button is : " + edgeTest);
//        } else {
//            System.out.println("No radio button is selected by default");
//        }

        List<WebElement> radioElements = driver.findElements(By.xpath("//table[@id='j_idt87:console2']//td//input"));
        int radioCount = radioElements.size();
        System.out.println("Total number of radio buttons : " + radioCount);

        int index = -1;

        for (WebElement radioElement : radioElements) {
            index++;
            if (radioElement.isSelected()) {
                WebElement defaultSelectedRadio = driver.findElement(By.xpath("//label[@for='j_idt87:console2:" + index + "']"));
                String defaultRadioText = defaultSelectedRadio.getText();
                System.out.println("The default selected radio button is : " + defaultRadioText);
                break;
            }
        }

        // 2) select the age group (only if not selected)
//        WebElement myAgeGroup = driver.findElement(By.id("j_idt87:age:1"));
//        boolean isChecked = myAgeGroup.isSelected();
//        if (!isChecked) {
////            myAgeGroup.click();
//            driver.findElement(By.xpath("//label[@for='j_idt87:age:1']")).click();
//        }

        String myAgeGroup = "21-40 Years";

        List<WebElement> ageGroups = driver.findElements(By.xpath("//div[@id='j_idt87:age']//label"));

        if (ageGroups.isEmpty()) {
            System.out.println("No age group elements found for xpath, page structure may have changed.");
            return;
        }

        for (WebElement element : ageGroups) {
            String ageGroupText = element.getText();
            if (ageGroupText.equals(myAgeGroup)) {
               WebElement myAgeRadio = driver.findElement(By.xpath("//label[text()='" + myAgeGroup + "']/parent::div//input"));
               if (!myAgeRadio.isSelected()) {
                   element.click();
               }
                break;
            }
        }
    }

    @Test
    public  void  checkBoxTest() {

     //<<<<<<<<<<<<Check Box Test>>>>>>>>>>>>
     // 1) Select wanted checkboxes and Verifying those check selected status
    driver.get("https://www.leafground.com/checkbox.xhtml");

    List <WebElement> checkBoxList =  driver.findElements(By.xpath("//table[@id='j_idt87:basic']//label"));
    for ( WebElement element :checkBoxList) {
            if ( !(element.getText().equals("Others")) ) {
                element.click();
            }
        }

    for ( int i = 1;  i<=checkBoxList.size()-1;  i++) {
        boolean checkBoxStatus = driver.findElement(By.xpath("(//table[@id='j_idt87:basic']//input)[" + i + "]")).isSelected();
        System.out.println("Check box " + i + " Selected status is : " + checkBoxStatus);

        }





    }
}
