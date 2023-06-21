package tests;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import pageobject.AbstractPageObject;


public class TextMessageTest {
    private WebDriver driver;

    @BeforeMethod
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://demoqa.com/buttons");
    }
    @Test
    public void testButtonClick() {
        AbstractPageObject abstractPageObject = new AbstractPageObject(driver);
        abstractPageObject.clickButton();
        abstractPageObject.clickMeButtonClick();
        String actualText = abstractPageObject.getResultText();
        String expectedText = "You have done a dynamic click";
        Assert.assertEquals(actualText, expectedText, "The result text message is not as expected.");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

}
