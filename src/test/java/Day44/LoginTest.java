package Day44;

import org.testng.annotations.Test;

public class LoginTest {

	@Test(priority=1, groups= {"sanity"})
	void loginByEmail()
	{
		System.out.println("Login by email");
	}
	
	@Test(priority=2, groups= {"sanity"})
	void loginByFacebook()
	{
		System.out.println("Login by facebook");
	
	}
	
	@Test(priority=3, groups= {"sanity"})
	void loginBytwitter()
	{
		System.out.println("Login by twitter");
	}
}
