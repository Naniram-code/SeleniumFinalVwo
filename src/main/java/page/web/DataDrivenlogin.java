package page.web;

import base.BasePage;
import org.openqa.selenium.By;

public class DataDrivenlogin extends BasePage {


        By text=By.id("js-notification-box-msg");
        By username=By.id("login-username");
        By password=By.name("password");
        By checkbox=By.xpath("//*[@class='checked-login-icon text--highlight']");

        By loginpageText=By.id("js-sign-in-heading");
        By NetiveTest=By.id("js-notification-box-msg");
        By signIn=By.id("js-login-btn");
        public  String verificationMessage(){
            waitForTitle("Login - VWO");
            return readText(loginpageText);}
        public  String verificationMessagee(){
            waitForTitle("Login - VWO");
            return readText(text);}
        public void inputusername(String email) {
            writetext(username,email);
        }
        public void inputpassword(String pass){
            writetext(password,pass);}
        public void Checkboxclick(){moveToElement(checkbox);}
        public void loginclickButton(){
            click(signIn);}
    public String NegetiveVerificationMsg() {
        waitForTitle("Login - VWO");
        return readText(NetiveTest);
    }

        public DataDrivenlogin LoginVwo(String email, String password)
        {
            goTourl("https://app.vwo.com");
            inputusername(email);
            inputpassword(password);
            Checkboxclick();
            loginclickButton();
            return this;
        }

    }



