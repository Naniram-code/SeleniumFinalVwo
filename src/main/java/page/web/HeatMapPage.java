package page.web;

import Driver.DriverManager;
import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.Iterator;
import java.util.Set;

    public class HeatMapPage extends BasePage {
        By Element=By.xpath("//*[@class='view--campaign ng-scope']//li[2]");
       // WebElement frm1= (WebElement) By.id("heatmap-iframe");
        By clickmap=By.xpath("//*[@class='option-tab vwo_player-option']/span");
        By Vtext=By.xpath("//*[@id='vwo-widget-1671204638150']/div/p[2]");

        By HeatMap=By.xpath("//*[@class='option-tab vwo_player-option']/span");
        //By signIn=By.id("js-login-btn");
        public String VerificationMassage(){
            return readText(Vtext);
        }
      public String Titlepage(){
          return Titlepage();
              }
              
        public  HeatMapPage HeatMapAssignment() throws Exception {

            waitForElementToAppear(Element);
            moveToElement(Element);
            waitForLoading();
            Set<String> handles = DriverManager.getDriver().getWindowHandles();
            //System.out.println("Number of windows opened: " + handles.size());
            Iterator<String> it = handles.iterator();//Iterator
                                  it.next();//parent
            String childWindowHanlde = it.next();//child
            DriverManager.getDriver().switchTo().window(childWindowHanlde);
            switchToIframe("heatmap-iframe");
            waitForElementToAppear(clickmap);
            moveToElement(clickmap);
            waitForElementToAppear(HeatMap);
            moveToElement(HeatMap);
            DriverManager.getDriver().switchTo().parentFrame();
            waitForElementToAppear(Vtext);

            return null;
        }


}
