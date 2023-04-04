package Driver;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class DriverManager {
    static WebDriver driver;
    private static final ThreadLocal<WebDriver> dr=new ThreadLocal<>();
    public static void setDriver(WebDriver driverRf){
        dr.set(driverRf);
    }
    public static WebDriver getDriver(){
        return dr.get();
    }
    public static void unload(){
        dr.remove();
    }
    @BeforeMethod

    public static void init(){
        if(getDriver()==null){
        ChromeOptions chromeOptions=new ChromeOptions();
        chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        DriverManager.setDriver(new ChromeDriver(chromeOptions));

    }}
    @AfterMethod
    public static void down(){
        if(getDriver()!=null){
            getDriver().quit();
            unload();
        }
    }

}
