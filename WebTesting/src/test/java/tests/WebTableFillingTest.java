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


public class WebTableFillingTest {
    private WebDriver driver;

    @BeforeMethod
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://demoqa.com/webtables");
    }

    @Test
    public void testButtonClick() {
        AbstractPageObject abstractPageObject = new AbstractPageObject(driver);
        abstractPageObject.clickAddButton();

        WebElement firstNameInput = driver.findElement(By.xpath("//*[@id=\"firstName\"]"));
        firstNameInput.sendKeys("Arkadiusz");

        WebElement lastNameInput = driver.findElement(By.xpath("//*[@id=\"lastName\"]"));
        lastNameInput.sendKeys("Motyl");

        WebElement emailInput = driver.findElement(By.xpath("//*[@id=\"userEmail\"]"));
        emailInput.sendKeys("arkadiusz.example@example.com");

        WebElement ageInput = driver.findElement(By.xpath("//*[@id=\"age\"]"));
        ageInput.sendKeys("25");

        WebElement salaryInput = driver.findElement(By.xpath("//*[@id=\"salary\"]"));
        salaryInput.sendKeys("1000");

        WebElement departmentInput = driver.findElement(By.xpath("//*[@id=\"department\"]"));
        departmentInput.sendKeys("IT");

        abstractPageObject.clickSubmitButton();

    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}