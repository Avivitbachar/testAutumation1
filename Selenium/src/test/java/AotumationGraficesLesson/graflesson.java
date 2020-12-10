package AotumationGraficesLesson;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Screen;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class graflesson {
    WebDriver driver;
    Screen screen;

    @BeforeClass

    public void startSession() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.google.com/maps/@31.9668394,34.8924051,14z");
        Thread.sleep (6000);
        screen = new Screen();
}
@Test
public void click () throws FindFailed {


        screen.click("C:\\Users\\avivit.b\\Desktop\\sikuli\\SK.png");
        screen.click("C:\\Users\\avivit.b\\Desktop\\sikuli\\SK2.png");
        screen.type("C:\\Users\\avivit.b\\Desktop\\sikuli\\SK5.png","Israel");
        screen.click("C:\\Users\\avivit.b\\Desktop\\sikuli\\SK4.png");
}


    @AfterClass
    public void closeSession() {
        driver.quit();
    }
}


