package page.web;

import Driver.DriverManager;
import base.BasePage;
import org.openqa.selenium.By;

public class DashbordPage extends BasePage {



    By UsernameLogin=By.xpath("//span[@class='Fw(semi-bold) ng-binding']");
    By Usermenu=By.xpath("(//img[@alt='Wingify'])[2]");
    By LogOutUser=By.xpath("//li[@no-async-loader='true']");

        public String loginUserName()
        {
            waitForElementToAppear(UsernameLogin);
            return readText(UsernameLogin);
        }
    public void UsermenuOpt(){
            waitForElementToAppear(Usermenu);
            moveToElement(Usermenu);}
    public void logOut(){
        waitForElementToAppear(Usermenu);
        moveToElement(LogOutUser);}

    public DashbordPage LogOutUserFromDashbord(){
            UsermenuOpt();
            logOut();
            waitForLoading();
            return this;


           }

    //public Loginpage afterlogin() {
       // return new Loginpage();
    //}
}



