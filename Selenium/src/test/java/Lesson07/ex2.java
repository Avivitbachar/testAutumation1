package Lesson07;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ex2 {
    WebDriver driver;

    @BeforeClass
    public void startSession() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://atidcollege.co.il/Xamples/ex_locators.html");

}
    @Test
    public void test01_getloactor()
    {

        System.out.println("byid"+ driver.findElement(By.id("locator_id")));

    }
    @Test
    public void test01_getloactor02(){
        System.out.println("byname"+ driver.findElement(By.name("locator_name")));
    }
    @Test
    public void test01_getloactor03(){
        System.out.println("byTagName"+ driver.findElement(By.tagName("p")));
    }
    @Test
    public void test01_getloactor04(){
        System.out.println("byLinkText"+ driver.findElement(By.linkText("Find my locator")));
    }

    @Test
    public void test01_getloactor05(){
        System.out.println("By partialLinkText"+ driver.findElement(By.partialLinkText("myLocator")));
    }

    @Test
    public void test01_getloactor06(){
        System.out.println("By cssSelector"+ driver.findElement(By.cssSelector("#contact_info_left > input")));
    }

    @Test
    public void test01_getloactor07(){
        System.out.println("ByClassName"+ driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/input")));
    }

    @Test
    public void test01_getloactor08(){
        System.out.println("ByXphat"+ driver.findElement(By.xpath("//*[@id=\"contact_info_left\"]/button")));
    }


@AfterClass
public void closeSession1(){

        driver.quit();
}
}




