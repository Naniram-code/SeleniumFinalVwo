package base;

import Driver.DriverManager;
import io.qameta.allure.Allure;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import page.web.WaitForHelper;
import utils.PropertyReaderOptimized;

import java.io.ByteArrayInputStream;
import java.time.Duration;

public class BasePage {
    protected WebDriver driver;

    public BasePage(){}


    public void goTourl(String url)
    {
        DriverManager.getDriver().get(url);
    }
    public void waitForElementToAppear(By elementLocation){
        new WaitForHelper(DriverManager.getDriver()).presenceOfElement(elementLocation);
    }
    public void waitForLoading(){ new  WaitForHelper(DriverManager.getDriver()).implicitWait();}
    public void waitForTitle(String title){
        WebDriverWait wait=new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(10));
        wait.until((ExpectedConditions.titleIs(title)));
    }

    public void click(By elementlocation){DriverManager.getDriver().findElement(elementlocation).click();}
    public void click(WebElement elementlocation){elementlocation.click();}

    public void writetext(By elementlocation,String text ){
        DriverManager.getDriver().findElement(elementlocation).clear();
        DriverManager.getDriver().findElement(elementlocation).sendKeys(text);
    }
    public void writetext(WebElement elementlocation,String text ){
        elementlocation.clear();
        elementlocation.sendKeys(text);
    }
    public String readText(By elementLocation){
        return DriverManager.getDriver().findElement(elementLocation).getText();
     }


    public void moveToElement(By elementLocation){ new Actions(DriverManager.getDriver()).
            moveToElement(DriverManager.getDriver().findElement(elementLocation)).click().build().perform();}
    public void moveToElementDoubleClick(By elementLocation){ new Actions(DriverManager.getDriver()).
            moveToElement(driver.findElement(elementLocation)).doubleClick().build().perform();}
}


