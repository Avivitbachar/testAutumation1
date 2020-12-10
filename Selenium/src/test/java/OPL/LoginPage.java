package OPL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage {
    @FindBy (how = How.NAME ,using = "username2") public WebElement userName;
    @FindBy  (how = How.NAME ,using = "password2") public WebElement passWord;
    @FindBy  (how = How.ID ,using = "submit") public WebElement Submit;



}
