package helpers;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.HomePage;

public class ElementAction {
    private static Logger log = LoggerFactory.getLogger(ElementAction.class);


    public static void clickElement(WebElement element){
        log.info("Clicked on element: " + element.getText());
        element.click();

    }

    public static void sendText(WebElement element, String value){
        element.clear();
        element.sendKeys(value);
        log.info("Sent text to element: " + value);
    }

    public static void selectDropDownListByIndex(WebElement element, int index){
        Select select = new Select(element);
        select.selectByIndex(index);
        log.info("Selected index: " + index);
    }

    public static void selectDropDownListByVisibleText(WebElement element, String text){
        Select select = new Select(element);
        select.selectByVisibleText(text);
        log.info("Selected index: " + text);
    }



}
