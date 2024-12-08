package pagesv2;

import base.BasePage;
import helpers.ElementAction;
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
        ElementAction.selectDropDownListByIndex(dropdownList, index);
        return this;

    }

    public FormPage typeEmailAdd(String value){
        ElementAction.sendText(email, value);
        return this;
    }

    public FormPage typeOrderReference(String value){
        ElementAction.sendText(orderR, value);
        return this;
    }

    public FormPage attachFile(String value){
        ElementAction.sendText(attachFile, value);
        return this;
    }

    public FormPage fillMessage(String value){
        ElementAction.sendText(messageBox, value);
        return this;
    }

    public FormPage submit(){
        ElementAction.clickElement(sendButton);
        return this;
    }

}
