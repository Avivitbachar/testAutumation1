package PizzaQ;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import java.awt.HeadlessException;
import java.awt.Toolkit;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.datatransfer.DataFlavor;

public class pizzaYAM {
    WebDriver driver;

    @BeforeClass
    public void startSession() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://atidcollege.co.il/Xamples/pizza/");
}
@Test public void total01 (){
        driver.findElement(By.className("gform_hidden")).getText();
    Assert.assertEquals("$7.50","$7.50");
}
@Test public void NameAndlastName02 (){
        driver.findElement(By.name("input_22.3")).sendKeys("Avivit");
        driver.findElement(By.name("input_22.6")).sendKeys("Bachar");
        driver.findElement(By.name("input_23")).sendKeys("0545667788");
        Select mypicUp = new Select(driver.findElement(By.id("input_5_21")));
       mypicUp.selectByVisibleText("Delivery   +$3.00");
      driver.findElement(By.className("gform_hidden")).getText();
      Assert.assertEquals("$10.50","$10.50");

}

         @Test public void coupon03 () {
           driver.switchTo().frame(0);
           String COPYTEXT = driver.findElement(By.id("coupon_Number")).getText();
             driver.switchTo().defaultContent();
             driver.findElement(By.name("input_20")).sendKeys(COPYTEXT);

    }



          @Test public void submit (){
              driver.findElement(By.id("gform_submit_button_5")).click();
              Alert popup3 = driver.switchTo().alert();
              String AlertText = popup3.getText();
              Assert.assertEquals(AlertText,"Avivit Bachar 088-234");
              popup3.accept();

    }







    @AfterClass
    public void closeSession() {
        driver.quit();
}
}
