package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;
import java.util.List;

public class BaseTestWebTable {
    protected static WebDriver driver;
    protected final String browserName = "Chrome";
    protected final String appUrl = "https://cosmocode.io/automation-practice-webtable/";

    private static Logger log = LoggerFactory.getLogger(BaseTestWebTable.class);
    Wait<WebDriver> wait = new FluentWait<>(driver)
            .withTimeout(Duration.ofSeconds(30))
            .pollingEvery(Duration.ofSeconds(2))
            .ignoring(NoSuchElementException.class);

    @BeforeEach
    public void setup(){
        log.info("Start test");
        driver = getDriver();
        driver.get(appUrl);
    }

    @AfterEach
    public void teardown(){
        driver.quit();
        log.info("Driver has been closed successfully");
    }

    private WebDriver getDriver() {
        switch(this.browserName){
            case "Chrome" -> {
                ChromeOptions options = new ChromeOptions();
                //options.addArguments("--headless");
                options.addArguments("--remote-allow-origins=*");
                options.addArguments("--start-maximized");

                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver(options);
            }
            case "Firefox" -> {
                FirefoxOptions options = new FirefoxOptions();
                //options.addArguments("--headless");
                options.addArguments("--remote-allow-origins=*");
                options.addArguments("--start-maximized");

                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver(options);
            }
            case "Edge" -> {
                EdgeOptions options = new EdgeOptions();
                //options.addArguments("--headless");
                options.addArguments("--remote-allow-origins=*");
                options.addArguments("--start-maximized");

                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver(options);
            }
            default -> {throw new UnsupportedOperationException("Unsupported Browser"); }

        }
        return driver;
    }

    protected void scrollToElement(WebElement webElement){
        new Actions(driver).scrollToElement(webElement).perform();
    }

    protected String getCapitalForCountry(String country){
        int rowCountry = 0;
        List<WebElement> allRows = driver.findElements(By.cssSelector("#countries tr"));
        for (WebElement singleRow : allRows) {
            if (singleRow.getText().contains(country)) break;
            rowCountry++;
        }
        WebElement capitalOfCountry = driver.findElement(By.cssSelector("#countries tr:nth-child(" + (rowCountry+1) + ") td:nth-child(3)"));
        return capitalOfCountry.getText();
    }

    protected String getCapitalForCountryXPath(String country){
        WebElement capitalOfCountry = driver.findElement(By.xpath("//table[@id='countries']//tr//*[contains(text(), '"+country+"')]/../following-sibling::td[1]"));
        return capitalOfCountry.getText();
    }

    protected void clickElementAndWait(WebElement element){
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }

    protected WebElement findCheckbox(int index){
        List<WebElement> list = driver.findElements(By.cssSelector(".hasVisited[type='checkbox']"));
        WebElement checkbox = wait.until(ExpectedConditions.elementToBeClickable(list.get(index)));
        scrollToElement(list.get(index + 3));
        return checkbox;
    }
}
