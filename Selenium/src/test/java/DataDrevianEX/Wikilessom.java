package DataDrevianEX;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Wikilessom {
    WebDriver driver;

    @BeforeClass
    public void startSession() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.wikipedia.org/");
    }



    @Test (dataProvider = "WikiData")
    public void WikiTest1 (String key , String value){
        driver.findElement(By.id("searchInput")).sendKeys(key);
        driver.findElement(By.cssSelector("#search-form > fieldset > button > i")).submit();
        Assert.assertEquals(value,driver.findElement(By.id("firstHeading")));
    }

    @AfterClass
    public void closeSession() {
        driver.quit();
        }


    @DataProvider (name = "WikiData")
    public Object [][] getDataObject ()
    {
        return new Object[][]{
                {"Automation","בדיקות תוכנה ממוכנות"},
                {"Israel","ישראל (עיתון)"},
                {"blabla","תוצאות החיפוש"}

        };

    }
}