package Base;

import Driver.DriverManager;
import io.qameta.allure.Allure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.ByteArrayInputStream;

public class Testbase {


    @BeforeMethod
    protected void setUp() {
        DriverManager.init();
    }

        @AfterMethod
    protected void tearDown() {
           DriverManager.down();
        }

    public void TakescreenShott(String name)
    {
        Allure.addAttachment(name, new ByteArrayInputStream(((TakesScreenshot) DriverManager.getDriver())
                .getScreenshotAs(OutputType.BYTES)));
    }}

