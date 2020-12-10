package Lesson2WebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class ex2 {
    @Test
    public void test01()


    {   String expectedResult = "IMDb: Ratings, Reviews, and Where to Watch the Best Movies & TV Shows";
        String expectedResult2 = "https://www.imdb.com/";
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.imdb.com/");
        System.out.println("this is the Title"  + driver.getTitle());

        driver.navigate().refresh();
        System.out.println("this is the current URL" + driver.getCurrentUrl());

        if (expectedResult.equals(driver.getTitle()))
        {
            System.out.println(true);


        }
        else {
            System.out.println(false);
        }
        driver.getCurrentUrl();
        if (expectedResult2.equals(driver.getCurrentUrl())){
            System.out.println(true);
        }

        else System.out.println(false);

        driver.quit();





    }
}
