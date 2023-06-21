package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.WebDriverWait;



public class AbstractPageObject {
    private final WebDriver driver;


    public AbstractPageObject(WebDriver driver) {
        this.driver = driver;
    }
    public void clickButton() {
        WebElement button = driver.findElement(By.id("item-4"));
        scrollToElement(button);
        button.click();
    }
    public void clickMeButtonClick() {
        WebElement clickMeButton = driver.findElement(By.xpath("//button[text()='Click Me']"));
        scrollToElement(clickMeButton);
        clickMeButton.click();
    }
    public String getResultText() {
        WebElement resultElement = driver.findElement(By.cssSelector("#dynamicClickMessage"));
        return resultElement.getText();
    }
    private void scrollToElement(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }
    public void clickAddButton() {
        WebElement buttonAdd = driver.findElement(By.cssSelector("#addNewRecordButton"));
        scrollToElement(buttonAdd);
        buttonAdd.click();
    }

    public void clickSubmitButton() {
        WebElement buttonAdd = driver.findElement(By.xpath("//*[@id=\"submit\"]"));
        buttonAdd.click();
    }

    public void clickEditButton () {
        WebElement buttonAdd = driver.findElement(By.xpath("//*[@id=\"edit-record-4\"]/svg"));
        buttonAdd.click();
    }
}
