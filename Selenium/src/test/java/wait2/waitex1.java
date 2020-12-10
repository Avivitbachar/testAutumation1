package wait2;

import com.google.common.util.concurrent.Uninterruptibles;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class waitex1 {
    WebDriver driver;

    @BeforeClass
    public void startSession() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://atidcollege.co.il/Xamples/ex_synchronization.html");
}
@Test public void test01(){
        driver.findElement(By.id("rendered")).click();
    WebDriverWait wait = new WebDriverWait(driver,10);
    wait.until(ExpectedConditions.textToBe(By.id("finish2"),"My Rendered Element After Fact!"));

}
@Test public void test02(){
        driver.findElement(By.id("hidden")).click();
    Uninterruptibles.sleepUninterruptibly(2, TimeUnit.SECONDS);
    driver.findElement(By.id("contact_info_left"));
}

@Test public void test03 (){
        driver.findElement(By.id("btn")).click();
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        driver.findElement(By.id("message"));
}
    @AfterClass
    public void closeSession() {
        driver.quit();
    }
}
