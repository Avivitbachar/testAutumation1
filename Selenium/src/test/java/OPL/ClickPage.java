package OPL;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ClickPage {
    @FindBy(how = How.CSS ,using = "body > div > table > tbody > tr:nth-child(2) > td > a > button") public WebElement BUTTUN;
}
