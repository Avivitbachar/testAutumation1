package Lesson07;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ex3Wik {
    WebDriver driver;

    @BeforeClass
    public void startSession() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.wikipedia.org/");
}
@Test
    public void webelemntArray()
{
    WebElement mainLogo = driver.findElement(By.className("central-featured-logo"));
    WebElement searchField = driver.findElement(By.id("searchInput"));
    WebElement selectLanguage = driver.findElement(By.id("searchLanguage"));
    WebElement footerSideBar = driver.findElement(By.className("footer-sidebar-content"));
    WebElement wikimedia = driver.findElement(By.linkText("Wikimedia Foundation"));

    WebElement[] wikiElement = {mainLogo, searchField, selectLanguage, footerSideBar, footerSideBar, wikimedia};
    for(int i = wikiElement.length-1; i >=0; i--)
        System.out.println(wikiElement[i]);

    }
    @AfterClass
    public void closeSession()
    {
        driver.quit();
    }
}
