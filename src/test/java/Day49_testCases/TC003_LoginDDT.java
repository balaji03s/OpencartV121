package Day49_testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import Day49_pageObjects.HomePage;
import Day49_pageObjects.LoginPage;
import Day49_pageObjects.MyAccountPage;
import Day49_utilities.DataProviders;

/*Data is valid----login success -test pass
 * 					login failed -test fail							
 * 
 * Data in invalid---login success-test fail
 			         login failed-test pass*/

public class TC003_LoginDDT extends BaseClass {

	@Test(dataProvider="LoginData", dataProviderClass=DataProviders.class, groups="datadriven") //getting data provider from different classes
	public void verify_loginDDT(String email, String pwd, String exp)
	{
		logger.info("******Starting TC003_LoginDDT test****");
		 
		        try {
		        //Homepage
				HomePage hp=new HomePage(driver);
				hp.clickMyAccount();
				hp.clickLogin();
				
				//Loginpage
				LoginPage lp=new LoginPage(driver);
				lp.setEmail(email);
				lp.setPassword(pwd);
				lp.clickLogin();
				
				//MyAccountpage
				MyAccountPage mycc=new MyAccountPage(driver);
				boolean targetpage=mycc.isMyAccountPageExists();	
				 
				if(exp.equalsIgnoreCase("Valid"))
				{
					if(targetpage==true)
					{
						mycc.clickLogout();
						Assert.assertTrue(true);
					}
					else
					{
						Assert.assertTrue(false);
					}
				}
				
				if(exp.equalsIgnoreCase("invalid"))
				{
					if(targetpage==true)
					{
						mycc.clickLogout();
						Assert.assertTrue(true);
					}
					
					else
					{
						Assert.assertTrue(true);
					}
				}
		}catch(Exception e)
		{
			Assert.fail();
		}
				
				
			logger.info("****Finished TC003_LogininDDT****");	
	}

}
