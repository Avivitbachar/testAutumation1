package alretrx;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ex1 {
    WebDriver driver;

    @BeforeClass
    public void startSession() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://atidcollege.co.il/Xamples/ex_switch_navigation.html");

}
@Test
    public void alert(){
        driver.findElement(By.id("btnAlert")).click();
        Alert popup2 = driver.switchTo().alert();
        popup2.getText();
        popup2.accept();


    }
    @Test

    public void popup(){
        driver.findElement(By.id("btnPrompt")).click();
        Alert popup3 = driver.switchTo().alert();
        popup3.sendKeys("Avivit");
        popup3.accept();
        driver.findElement(By.id("output")).getAttribute("value");
        Assert.assertEquals("Avivit", "Avivit");

    }




    @AfterClass
    public void closeSession() {
        driver.quit();
    }
}
