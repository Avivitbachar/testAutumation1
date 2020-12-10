package ActionLesson;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Description;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

public class ActionsEX {
    WebDriver driver;

    @BeforeClass
    public void startSession() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://atidcollege.co.il/Xamples/ex_actions.html");
}

@Test  (priority = 0 , description = "see if the element is draguble")
@Description ("drag and droop it ")
public void draggbule (){
        WebElement Draggable = driver.findElement(By.id("draggable"));
        WebElement Droop = driver.findElement(By.id("droppable"));
    Actions action = new Actions(driver);
    action.dragAndDrop(Draggable,Droop).build().perform();
    Assert.assertEquals(driver.findElement(By.id("droppable")).getText(),"Dropped!");
}

@Test (priority = 0,description = "cuntrol alt")
@Description ("bulk all ")
public void bulk (){

    List<WebElement> list=driver.findElements(By.id("contact_info_left"));
    System.out.println(list);
   Actions action = new Actions(driver);
   action.click(list.get(0)).keyDown(Keys.CONTROL).click(list.get(1)).keyUp(Keys.CONTROL).build().perform();
}


@Test (priority = 0,description = "dabble")
@Description ("dabble click ")
public void dabble(){
        WebElement Dclick = driver.findElement(By.id("dbl_click"));
        Actions action = new Actions(driver);
        action.doubleClick(Dclick);
        action.build().perform();
    Assert.assertEquals(driver.findElement(By.id("demo")).getText(),"Hello World");

}

@Test public void hover (){
        WebElement HOVER =driver.findElement(By.id("mouse_hover"));

        Actions action = new Actions(driver);
        action.moveToElement(HOVER).build().perform();
        Assert.assertEquals((HOVER.getCssValue("background-color")),"rgba(255, 255, 0, 0.282)");



}
@Test public void scrooling (){
        WebElement SC = driver.findElement(By.id("scrolled_element"));
    JavascriptExecutor js =(JavascriptExecutor)driver;
    js.executeScript("arguments[0].scrollIntoView(true);",SC);
    Assert.assertEquals(driver.findElement(By.id("scrolled_element")).getText(),"This Element is Shown When Scrolled");

}

    @AfterClass
    public void closeSession() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }
}