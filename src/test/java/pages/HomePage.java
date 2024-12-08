package pages;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HomePage extends BasePage {
    private static Logger log = LoggerFactory.getLogger(HomePage.class);
    @FindBy(css="#contact-link a")
            WebElement contactUsLink;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    //Click on contact us
    public HomePage clickContactUsLink(){
        contactUsLink.click();
        log.info("Contact Us has been clicked");

        return this;
    }


}
