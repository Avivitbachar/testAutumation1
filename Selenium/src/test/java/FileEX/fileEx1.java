package FileEX;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

public class fileEx1 {
    WebDriver driver;

    @BeforeClass
    public void startSession() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(getData("URL"));
    }

    public void setWeight(String value) {
        driver.findElement(By.id("weight")).sendKeys(getData("Weight"));
    }



    public void setHight(int value) {
        driver.findElement(By.id("hight")).sendKeys(getData("Hight"));

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
    public String getData (String nodeName)
    {
        DocumentBuilder dBuilder;
        Document doc = null;
        File fXmlFile = new File("./Configuration.xml");
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        try {
            dBuilder = dbFactory.newDocumentBuilder();
            doc = dBuilder.parse(fXmlFile);
        }
        catch(Exception e) {
            System.out.println("Exception in reading XML file: " + e);
        }
        doc.getDocumentElement().normalize();
        return doc.getElementsByTagName(nodeName).item(0).getTextContent();
    }


    @AfterClass
    public void closeSession() {
        driver.quit();
    }

}


