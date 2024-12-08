package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class BaseTest {
    protected static WebDriver driver;
    protected final String browserName = "Chrome";
    protected final String appUrl = "http://www.automationpractice.pl/index.php";

    private static Logger log = LoggerFactory.getLogger(BaseTest.class);

    protected String emailAdd = "XYZ@gmail.com";
    protected String orderR = "123";
    protected String filePath = "C:\\TEST_DATA\\TEST.txt";
    protected String longerText = "Lore ipsum";
    protected String expectedMessage = "Your message has been successfully sent to our team.";
    protected int index = 1;

    @BeforeEach
    public void setup(){
        log.info("Start test");
        driver = getDriver();
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

}
