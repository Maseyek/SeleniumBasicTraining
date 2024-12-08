package scenarios;

import base.BaseTest;
import base.BaseTestWebTable;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class WebTableSimpleTest extends BaseTestWebTable {

    private static Logger log = LoggerFactory.getLogger(WebTableSimpleTest.class);


    @Test
    @DisplayName("Web Table verification")
    public void webTableVerification() throws InterruptedException {
        log.info("Start Test");


        //count how many rows are in table
        List<WebElement> tableRows = driver.findElements(By.cssSelector("#countries tr"));
        log.info("Return amount of countries in table: " + (tableRows.size() - 1));

        //find row with Poland
        //String polandText = tableRows.get(140).getText();
        //log.info("Found: " + polandText);

        //dynamic find row with Poland
        int rowPoland = 0;
        List<WebElement> allRows = driver.findElements(By.cssSelector("#countries tr"));
        for (WebElement singleRow : allRows) {
            if (singleRow.getText().contains("Poland")) break;
            rowPoland++;
        }
        log.info("Index of Poland is: " + (rowPoland + 1));
        WebElement capitalOfPoland = driver.findElement(By.cssSelector("#countries tr:nth-child(" + (rowPoland+1) + ") td:nth-child(3)"));
        log.info("Capital of Poland is " + capitalOfPoland.getText());

        scrollToElement(driver.findElement(By.cssSelector("#countries tr:nth-child(" + (rowPoland+6) + ") td:nth-child(3)")));
        assertThat(capitalOfPoland.getText()).isEqualTo("Warsaw");

        //select next to Poland
        List<WebElement> checkBoxList = driver.findElements(By.cssSelector(".hasVisited[type='checkbox']"));
        WebElement checkBoxPoland = checkBoxList.get(rowPoland - 1);
        log.info("Check box before click - selected: " + checkBoxPoland.isSelected());
        log.info("Check box before click - displayed: " + checkBoxPoland.isDisplayed());
        log.info("Check box before click - enabled: " + checkBoxPoland.isEnabled());



        checkBoxPoland.click();

        log.info("Check box after click - selected: " + checkBoxPoland.isSelected());
        log.info("Check box after click - displayed: " + checkBoxPoland.isDisplayed());
        log.info("Check box after click - enabled: " + checkBoxPoland.isEnabled());

    }


}
