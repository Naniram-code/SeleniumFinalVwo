
package tests.UI;
import Base.Testbase;
import Driver.DriverManager;

import org.assertj.core.api.Assertions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import page.web.DataDrivenlogin;

import utils.excelReader;


public class NegativeLoginTest extends Testbase {

	String sheetName = "sheet1";
	@DataProvider
	public Object[][] getTestData(){ //data from excel file
		Object data[][] = excelReader.getTestData(sheetName);//TestUtil--->getTestData--->read from excel
		return data;
	}
	@Test(priority=1, dataProvider="getTestData")
	public void NegetiveLoginvalidation(String email, String password) throws Exception {
		DataDrivenlogin dataDrivenlogin=new DataDrivenlogin().LoginVwo(email,password);
		DriverManager.getDriver().manage().window().maximize();
		String ExpectedvalidationMassage=dataDrivenlogin.NegetiveVerificationMsg();
		System.out.println("LoginPage="+ExpectedvalidationMassage);
		Assertions.assertThat(ExpectedvalidationMassage)
				.isNotBlank()
				.isNotNull()
				.contains("Your email, password, IP address or location did not match");
		TakescreenShott(" Vwo loginpage");
	}}
	


	
	
	
	

