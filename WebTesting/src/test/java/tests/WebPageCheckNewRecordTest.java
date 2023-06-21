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

public class WebPageCheckNewRecordTest {
        private WebDriver driver;
        @BeforeMethod
        public void setup() {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.get("https://demoqa.com/webtables");
        }
        @Test
                public void CheckNewRecord () {
            AbstractPageObject abstractPageObject = new AbstractPageObject(driver);
            WebElement newRecord = driver.findElement(By.xpath("//rt-td[text()='Arkadiusz']"));

            if (newRecord != null) {
                System.out.println("New record added successfully!");
            } else {
                System.out.println("Failed to add new record.");
            }
        }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
