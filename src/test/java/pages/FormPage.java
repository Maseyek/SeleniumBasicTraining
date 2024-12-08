package pages;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FormPage extends BasePage {
    private static Logger log = LoggerFactory.getLogger(FormPage.class);

    @FindBy(css = "#id_contact")
    private WebElement dropdownList;

    @FindBy(id = "email")
    private WebElement email;

    @FindBy(id = "id_order")
    private WebElement orderR;

    @FindBy(id = "fileUpload")
    private WebElement attachFile;

    @FindBy(id = "message")
    private WebElement messageBox;

    @FindBy(css = "#submitMessage")
    private WebElement sendButton;

    public FormPage(WebDriver driver) {
        super(driver);
    }

    public FormPage selectValueFromDropdownList(int index)
    {
        log.info("Select option from dropdown list");
        Select select = new Select(dropdownList);
        select.selectByIndex(index);
        return this;

    }

    public FormPage typeEmailAdd(String value){
        log.info("Fill E-mail - " + value);
        email.sendKeys(value);
        return this;
    }

    public FormPage typeOrderReference(String value){
        log.info("Fill Order reference - " + value);
        orderR.sendKeys(value);
        return this;
    }

    public FormPage attachFile(String value){
        log.info("Fill Attachment file - Path: " + value);
        attachFile.sendKeys(value);
        return this;
    }

    public FormPage fillMessage(String value){
        log.info("Fill Message - Message: " + value);
        messageBox.sendKeys(value);
        return this;
    }

    public FormPage submit(){
        log.info("click send button");
        sendButton.click();
        return this;
    }

}
