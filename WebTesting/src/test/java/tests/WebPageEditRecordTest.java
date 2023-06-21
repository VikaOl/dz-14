package tests;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import pageobject.AbstractPageObject;

public class WebPageEditRecordTest {
    private WebDriver driver;
    @BeforeMethod
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://demoqa.com/webtables");
    }
    @Test
    public void editRecord() {
        AbstractPageObject abstractPageObject = new AbstractPageObject(driver);
        abstractPageObject.clickEditButton();
        WebElement lastNameInput = driver.findElement(By.xpath("//*[@id=\"lastName\"]"));
        lastNameInput.sendKeys("Motyl2");
        abstractPageObject.clickSubmitButton();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
