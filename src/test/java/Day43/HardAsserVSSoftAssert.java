package Day43;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class HardAsserVSSoftAssert {

	//@Test
	void test_hardassert()
	{
		System.out.println("Testing");
		System.out.println("Testing123....");
		
		Assert.assertEquals(1, 2);//hard assertion
		
		System.out.println("Testing 456...");
		System.out.println("Testing 789...");
	}
	
	@Test
	void test_softassert()
	{
		System.out.println("Testing");
		System.out.println("Testing123....");
		
		SoftAssert sa=new SoftAssert();
		
		sa.assertEquals(1,2);
		
		System.out.println("Testing 456...");
		System.out.println("Testing 789...");
		
		sa.assertAll();//mandatory
	}
	
	
}
