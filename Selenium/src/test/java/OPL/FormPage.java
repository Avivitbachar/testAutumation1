package OPL;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class FormPage {
    @FindBy(how = How.NAME ,using = "name") public WebElement OC;
    @FindBy  (how = How.NAME ,using = "email") public WebElement AGE;
    @FindBy  (how = How.ID ,using = "email") public WebElement LO;
    @FindBy  (how = How.CSS ,using = "#contact_form > fieldset > ol > li:nth-child(4) > a > input[type=button]") public WebElement Click;

}
