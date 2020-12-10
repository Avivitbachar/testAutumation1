package HandlingEX;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class handEX1 {
    WebDriver driver;

    @BeforeClass
    public void startSession() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://atidcollege.co.il/Xamples/ex_synchronization.html");

}
    @Test public void visible1()  {
        driver.findElement(By.id("btn")).click();
        try {
            Thread.sleep(5000);
            driver.findElement(By.id("checkbox"));
        } catch (Exception e) {
            System.out.println("Failed" + e );
        }

    }
    @AfterClass
    public void closeSession() {
        driver.quit();
    }
}
