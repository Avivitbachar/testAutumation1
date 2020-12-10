package ActionLesson;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import javax.swing.*;

public class InterviewEX {
    WebDriver driver;

    @BeforeClass
    public void startSession() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://todomvc.com/examples/react/#/active");
}
@Test
public void NewAssignMent (){
        driver.findElement(By.className("new-todo")).sendKeys("one assigmnt");
       driver.findElement(By.className("new-todo")).click();
       WebElement duClick =  driver.findElement(By.className("new-todo"));
       Actions action = new Actions(driver);
      action.doubleClick(duClick).build().perform();
     driver.findElement(By.className("new-todo")).sendKeys("one new assigmnt");
     WebElement delClick =  driver.findElement(By.className("new-todo"));
     action.moveToElement(delClick).click().build().perform();

}

}
