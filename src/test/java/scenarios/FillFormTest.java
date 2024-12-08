package scenarios;

import base.BaseTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;

import static org.assertj.core.api.Assertions.assertThat;

public class FillFormTest extends BaseTest {
    private static Logger log = LoggerFactory.getLogger(FillFormTest.class);

    @Test
    @DisplayName("Fill form Selenium Basic Training")
    public void fillForm(){

        //set implicit wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.get(appUrl);

        //assertThat(true).isEqualTo(false);
        //1. Click on contact us
        log.info("Click on contact us");
        WebElement contactUsLink = driver.findElement(By.cssSelector("#contact-link a"));
        contactUsLink.click();
        //2. Select option from dropdown list
        log.info("Select option from dropdown list");
        WebElement dropdownList = driver.findElement(By.cssSelector("#id_contact"));
        Select select = new Select(dropdownList);
        select.selectByIndex(1);
        //3. Fill E-mail
        log.info("Fill E-mail - " + emailAdd);
        WebElement email = driver.findElement(By.id("email"));
        email.sendKeys(emailAdd);
        //4. Fill Order reference
        log.info("Fill Order reference - " + orderR);
        WebElement orderRef = driver.findElement(By.id("id_order"));
        orderRef.sendKeys(orderR);
        //5. Fill Attachment file
        log.info("Fill Attachment file - Path: " + filePath);
        WebElement attachFile = driver.findElement(By.id("fileUpload"));
        attachFile.sendKeys(filePath);
        //6. Fill Message
        log.info("Fill Message - Message: " + longerText);
        WebElement messageBox = driver.findElement(By.id("message"));
        messageBox.sendKeys(longerText);
        //7. click send button
        log.info("click send button");
        WebElement sendButton = driver.findElement(By.cssSelector("#submitMessage"));
        sendButton.click();
        //8. Verify text message
        String actualMessage = driver.findElement(By.cssSelector(".alert-success")).getText();

        log.info("Verify text message - Actual message: " + actualMessage);
        assertThat(actualMessage).isEqualTo(expectedMessage);


    }


}
