package tests;

import Base.Testbase;
import Driver.DriverManager;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.Test;
import page.web.DashbordPage;
import page.web.Loginpage;
import utils.PropertyReaderOptimized;

public class End_to_End_Test extends Testbase {
    @Test(priority = 2)
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
