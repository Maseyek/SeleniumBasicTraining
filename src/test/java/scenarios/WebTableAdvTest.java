package scenarios;

import base.BaseTestWebTable;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;

import static org.assertj.core.api.Assertions.assertThat;

public class WebTableAdvTest extends BaseTestWebTable {


    @Test
    @DisplayName("Web Table verification (ADV)")
    @Tag("WebTable")
    public void checkWebTable(){
        //check capital of any country - Bulgaria Sofia

        String capital = getCapitalForCountry("Bulgaria");
        assertThat(capital).isEqualTo("Sofia");
    }


    @Test
    @DisplayName("Web Table verification 2 (ADV)")
    public void checkWebTable2(){
        //check capital of any country - Burkina Faso - Ouagadougou
        String capital = getCapitalForCountry("Burkina Faso");
        assertThat(capital).isEqualTo("Ouagadougou");
    }

    @Test
    @DisplayName("Web Table verification 3 (XPath)")
    public void checkWebTable3(){
        //check capital of any country (XPath) - Burkina Faso - Ouagadougou
        String capital = getCapitalForCountryXPath("Burkina Faso");
        assertThat(capital).isEqualTo("Ouagadougou");
    }

    @Test
    @DisplayName("Web Table verification - Click Checkbox")
    public void clickCheckbox(){
        //Find checkbox
        WebElement checkbox = findCheckbox(5);
        //Click checkbox
        clickElementAndWait(checkbox);
        //Check if selected
        assertThat(checkbox.isSelected()).isTrue();

    }
}
