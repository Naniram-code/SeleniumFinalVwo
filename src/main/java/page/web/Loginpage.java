package page.web;

import base.BasePage;
import org.openqa.selenium.By;
import utils.PropertyReaderOptimized;

public class Loginpage extends BasePage {
    //WebDriver driver;




                    By text=By.xpath("//h5[@id='js-sign-in-heading']");
                    By username=By.id("login-username");
                    By Password=By.name("password");
                    By checkbox=By.xpath("//*[@class='checked-login-icon text--highlight']");

                    By loginpageText=By.id("js-sign-in-heading");
                    By signIn=By.id("js-login-btn");
    public String LoginPagevarification() {
       waitForTitle("Login - VWO");
       return readText(text);
    }



    public Loginpage LoginVwo() throws Exception {

        writetext(username, PropertyReaderOptimized.readKeyO("username"));
        writetext(Password, PropertyReaderOptimized.readKeyO("password"));
        moveToElement(checkbox);
        click(signIn);
        return this;
    }
    public DashbordPage afterlogin() {
        return new DashbordPage();
    }

    }

