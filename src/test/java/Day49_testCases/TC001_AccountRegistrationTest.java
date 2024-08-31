package Day49_testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import Day49_pageObjects.AccountRegistrationPage;
import Day49_pageObjects.HomePage;

public class TC001_AccountRegistrationTest extends BaseClass {
	
	@Test(groups={"Regression", "Master"})
	public void verify_registration()
	{
		logger.info("*****Starting testcase****");
		try
		{
		HomePage hp=new HomePage(driver);
		hp.clickMyAccount();
	    logger.info("Clicked on my account link"); 
		hp.clickRegister();
		logger.info("Clicked on register link");
		
		AccountRegistrationPage regpage=new AccountRegistrationPage(driver);
		logger.info("Providing customer details");
	
		regpage.setFirstName(randomString().toUpperCase());           // ("Balaji");
		regpage.setLastName(randomString().toUpperCase());           //("Sw");
		regpage.setEmail(randomString()+"@gmail.com");                  //("abcbala@gmail.com");
		regpage.setTelephone(randomNumber());
		
		String password=randomAlphaNumeric();
		
		regpage.setPassword(password);        //("xyz123456");
		regpage.setConfirmPassword(password);
		regpage.setPrivacyPolicy();
		regpage.clickContinue();
		
		logger.info("Validating expected message");
		
		String confmsg=regpage.getConfirmationMsg();
		if(confmsg.equals("Your Account Has Been Created!"))
		{
			Assert.assertTrue(true);
		}
		else {
			logger.error("Test failed....");
			logger.debug("Debug logs..");
			Assert.assertTrue(false);
		}
		
		//Assert.assertEquals(confmsg, "Your Account Has Been Created!!!");	
		}
		catch(Exception e)
		{
			
			Assert.fail();
		}
		logger.info("****Finished Testcase*****");
		}
		
		
		
	}
	

