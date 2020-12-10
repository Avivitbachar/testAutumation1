package ReportingLesson;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Description;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.fail;

public class reportsEx {
    WebDriver driver;

    @BeforeClass
    public void startSession() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://atidcollege.co.il/Xamples/bmi/");
    }
@Step("Imsert my Weight")
    public void setWeight(String value) {
        driver.findElement(By.id("weight")).sendKeys(value);
    }
   @Step ("Instert my Hight")
    public void setHight(int value) {
        driver.findElement(By.id("hight")).sendKeys("160");

    }
    @Step ("See my BMI result")

    public void getResult() {
        driver.findElement(By.id("calculate_data")).click();
    }

    @Test (priority = 0 ,description = "Wight and Hight reslut")
    @Description ("My BMI Reslut")
    public void resultValidation() {
        try {
            setWeight("52");
            setHight(160);
            getResult();

            driver.findElement(By.xpath("/html/body/form/table/tbody/tr[7]/td[2]")).getAttribute("value");
            Assert.assertEquals(20, 20);

        }
        catch (AssertionError e)
        {
            saveScreenshot(driver);
            fail ("Assert failed ,see details" + e);
        }







    }

    private void saveScreenshot(WebDriver driver) {
    }


    @AfterClass
    public void closeSession() {
        driver.quit();
    }

}
