package Day49_testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import Day49_pageObjects.HomePage;
import Day49_pageObjects.LoginPage;
import Day49_pageObjects.MyAccountPage;

public class TC002_LoginTest extends BaseClass {
	
	@Test(groups={"Sanity", "Master"})
	public void verify_login()
	{
		logger.info("*****Starting TC_002 Login Test***");
		
		try
		{
		//Homepage
		HomePage hp=new HomePage(driver);
		hp.clickMyAccount();
		hp.clickLogin();
		
		//Loginpage
		LoginPage lp=new LoginPage(driver);
		lp.setEmail(p.getProperty("email"));
		lp.setPassword(p.getProperty("password"));
		lp.clickLogin();
		
		//MyAccountpage
		MyAccountPage mycc=new MyAccountPage(driver);
		boolean targetpage=mycc.isMyAccountPageExists();
		
		//Assert.assertEquals(targetpage, true, "Login failed");
		Assert.assertTrue(targetpage);
		}
		catch(Exception e)
		{
			Assert.fail();
		}
		
		logger.info("*****Finished TC_002 Login Test***");
		
	}

}
