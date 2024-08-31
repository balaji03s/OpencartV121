package Day43pack;

import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class C2 {
	
	@Test
	void xyz()
	{
		System.out.println("This is xyz class from c2");
	}

	@AfterTest
	void at()
	{
		System.out.println("This is AfterTest method");
	}
}
