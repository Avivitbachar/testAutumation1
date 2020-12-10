package Lesson07;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

public class ex1 {
    WebDriver driver;

    @BeforeClass
    public void startSession() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.selenium.dev/");
    }

    @Test
    public void test01_verifElemnet()
    {

        System.out.println(driver.findElement(By.linkText("Blog")));
    }

    @Test
    public void test02_howMuchLinks()
    {
        List<WebElement>links = driver.findElements(By.tagName("a"));
        List<WebElement>SeleniumLinks = driver.findElements(By.partialLinkText("Selenium"));
        List<WebElement>seleniumLinks = driver.findElements(By.partialLinkText("selenium"));
        System.out.println("Number of the links in the site" +links.size());
        System.out.println("Number of selenium in the site "+seleniumLinks.size());
        System.out.println("Number of Selenium in the site "+SeleniumLinks.size());
    }


    @AfterClass
    public void closeSession() {
        driver.quit();
    }
}


