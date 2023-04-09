package tests.UI;

import Base.Testbase;
import Driver.DriverManager;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;



import org.testng.annotations.Test;

import page.web.DashbordPage;
import page.web.Loginpage;

import utils.PropertyReaderOptimized;
import org.assertj.core.api.Assertions;




public class LoginTest extends Testbase {


    @Test(priority =2)
    @Owner("NaniRam")
    @Severity(SeverityLevel.NORMAL)
    @Description("Verify Positive Login Page")

    public void PositiveLogin() throws Exception {
            DriverManager.getDriver().get(PropertyReaderOptimized.readKeyO("url"));
            Loginpage loginpage = new Loginpage().LoginVwo();
            String actualResult  = new DashbordPage().loginUserName();
           System.out.println(actualResult);
            Assertions.assertThat(actualResult)
                    .isNotBlank()
                    .isNotNull()
                    .contains(PropertyReaderOptimized.readKeyO("expected_username"));

        TakescreenShott(" Vwo DashBoard");
    }

    @Test(priority = 3)
    @Owner("NaniRam")
    @Severity(SeverityLevel.NORMAL)
    @Description("End to End login and logout")
    public void LogOut() throws Exception {
        DriverManager.getDriver().get(PropertyReaderOptimized.readKeyO("url"));
        Loginpage loginpage = new Loginpage().LoginVwo();
        DriverManager.getDriver().manage().window().maximize();
        DashbordPage dashbordPage= new DashbordPage().LogOutUserFromDashbord();
        System.out.println("Login page Verification Text:"+loginpage.LoginPagevarification());
        Assertions.assertThat(loginpage.LoginPagevarification())
                .isNotBlank()
                .isNotNull()
                .contains("SIGN IN TO VWO PLATFORM");
        TakescreenShott(" Vwo loginpage");


    }

}