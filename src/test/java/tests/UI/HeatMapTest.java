package tests.UI;

import Base.Testbase;
import Driver.DriverManager;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

import page.web.HeatMapPage;

import utils.PropertyReaderOptimized;

public class HeatMapTest extends Testbase {
    @Test(priority =1)
    @Owner("NaniRam")
    @Severity(SeverityLevel.NORMAL)
    @Description("Heatmap App Vwo ")

    public void TestHeatmap() throws Exception {

        DriverManager.getDriver().get(PropertyReaderOptimized.readKeyO("URLHeatmap"));
        DriverManager.getDriver().manage().window().maximize();
        HeatMapPage heatMapPage = new HeatMapPage();
                heatMapPage.HeatMapAssignment();
                String Actual_verificationMassage  = heatMapPage.VerificationMassage();
        System.out.println(Actual_verificationMassage);
        Assertions.assertThat(Actual_verificationMassage)
                .isNotBlank()
                .isNotNull()
                .contains(PropertyReaderOptimized.readKeyO("ExpectedVerificationMdg"));
        TakescreenShott("HeatMap");
    }
}
