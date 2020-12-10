package Lesson08;



import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
public class ex1 {
    WebDriver driver;

    @BeforeClass
    public void startSession() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://atidcollege.co.il/Xamples/ex_controllers.html");
}
@Test public void myName ()
{
    driver.findElement(By.name("firstname")).sendKeys("Avivit");
    driver.findElement(By.name("lastname")).sendKeys("Bachar");



    }
    @Test
    public void myCity(){
        {
           Select MYCITY = new Select(driver.findElement(By.id("continents")));
            MYCITY.deselectByIndex(4);
            driver.findElement(By.id("submit")).click();
            if (driver.findElement(By.id("submit")).getText().equals("https://atidcollege.co.il/Xamples/ex_controllers.html?firstname=Avivit&lastname=Bachar&sex=Male&exp=1&datepicker=&photo=&continents=samerica&submit=")){

            }
else System.out.println("not equal");

        }


    }
    @AfterClass
    public void closeSession()
    {
        driver.quit();
    }
}




