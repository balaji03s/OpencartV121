package Day44;

import org.testng.annotations.Test;

public class PaymentTest {
	
	@Test(priority=1, groups= {"sanity","regression","functional"})
	void PaymentRupee()
	{
		System.out.println("Payment in rupee");
	}
	
	@Test(priority=2, groups= {"sanity","regression","functional"})
	void PaymentDoller()
	{
		System.out.println("Payment in doller");
	}
	
	

}
