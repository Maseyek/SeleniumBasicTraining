package pagesv2;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ResultPage extends BasePage {
    private static Logger log = LoggerFactory.getLogger(ResultPage.class);

    @FindBy(css = ".alert-success")
    WebElement actualMessage;

    public ResultPage(WebDriver driver) {
        super(driver);
    }

    public String retrieveActualMessage(){
        log.info("Retrieve message " + actualMessage.getText());

        return actualMessage.getText();
    }



}
