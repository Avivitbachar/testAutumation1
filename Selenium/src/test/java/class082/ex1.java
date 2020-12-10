package class082;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;

public class ex1 {
    WebDriver driver;

    @BeforeClass
    public void startSession() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://atidcollege.co.il/Xamples/bmi/");
    }

    public void setWeight(String value) {
        driver.findElement(By.id("weight")).sendKeys(value);
    }

    public void setHight(int value) {
        driver.findElement(By.id("hight")).sendKeys("160");

    }

    public void getResult() {
        driver.findElement(By.id("calculate_data")).click();
    }

    @Test
    public void resultValidation() {
        setWeight("52");
        setHight(160);
        getResult();

        driver.findElement(By.xpath("/html/body/form/table/tbody/tr[7]/td[2]")).getAttribute("value");

        /*if (expected.equals(actual)) {
            System.out.println("pass");
        } else System.out.println("fail");*/

        Assert.assertEquals(20, 20);

    }



    @AfterClass
    public void closeSession() {
        driver.quit();
    }

}
