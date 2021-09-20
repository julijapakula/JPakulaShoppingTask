package core;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.openqa.selenium.Keys.DELETE;

public class BaseFunc {
    Actions actions;
    private WebDriver driver;
    private WebDriverWait wait;

    public BaseFunc() {
        System.setProperty("webdriver.chrome.driver", "C:/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    public void goToUrl(String url) {
        if (url.startsWith("http://") || url.startsWith("https://")) {
        } else {
            url = "http://" + url;
        }
        driver.get(url);
    }

    public void waitClick(By locator) {
        wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
        findElement(locator).click();
    }

    public List<WebElement> findElements(By locator) {
        assertFalse(driver.findElements(locator).isEmpty(), "No elements found by this locator");
        return driver.findElements(locator);
    }

    public WebElement findElement(By locator) {
        return driver.findElement(locator);
    }

    public void clickOnElementById(int id, By locator) {
        findElements(locator).get(id).click();
    }

    public void clickOnElementInListByName(By locator, String name) {
        List<WebElement> listOfElements = findElements(locator);
        for (WebElement we : listOfElements) {
            if (we.getText().toLowerCase().contains(name)) {
                we.click();
                break;
            }
        }
    }
    public void typeToField(By locator, String text) {
        findElement(locator).sendKeys(DELETE);
        findElement(locator).sendKeys(text);
    }
    public void quitBrowser() {
        driver.quit();
    }
}


