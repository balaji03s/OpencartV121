package Day44;

import org.testng.annotations.Test;

public class SignupTest {
	
	@Test(priority=1, groups= {"regression"})
	void singByEmail() 
	{
	System.out.println("Sign by email");	
	}

	@Test(priority=2, groups= {"regression"})
	void singByFacebook() 
	{
		System.out.println("sign by facebook");
	}

	@Test(priority=3, groups= {"regression"})
	void singBytwitter() 
	{
		System.out.println("sign by twitter");
	}

	
	
	
	
	
}

