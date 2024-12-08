package scenarios;

import base.BaseTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pagesv2.FormPage;
import pagesv2.HomePage;
import pagesv2.ResultPage;

import java.time.Duration;

import static org.assertj.core.api.Assertions.assertThat;

public class FillFormAdvPOMElementActionTest extends BaseTest {

    @Test
    @DisplayName("Fill Form - Advanced POM")
    public void fillFormPOM(){
        //set implicit wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.get(appUrl);

        HomePage homePage = new HomePage(driver);
        FormPage formPage = new FormPage(driver);
        ResultPage resultPage = new ResultPage(driver);

        homePage.clickContactUsLink();
        formPage.selectValueFromDropdownList(index)
                .typeEmailAdd(emailAdd)
                .typeOrderReference(orderR)
                .attachFile(filePath)
                .fillMessage(longerText)
                .submit();


        String actualMessage = resultPage.retrieveActualMessage();
        assertThat(actualMessage).isEqualTo(expectedMessage);
    }

}
