package Day;

import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class XpathAxesDemo {

	public static void main(String[] args) {
		
		WebDriver driver= new ChromeDriver();
		driver.get("https://money.rediff.com/gainers/bse/daily/groupa");
		driver.manage().window().maximize();
		
		//self
		String self=driver.findElement(By.xpath("//a[normalize-space()='Zomato']/self::a")).getText();
		System.out.println("Self:" +self);
		
		//Parent
		String Par=driver.findElement(By.xpath("//a[normalize-space()='Zomato']/parent::td")).getText();
		System.out.println("Parent: "+Par);
		
		//Child
		List<WebElement> child =driver.findElements(By.xpath("//a[normalize-space()='Zomato']/ancestor::tr/child::td"));
		System.out.println("Number of element: "+child.size());
		
		//ancestor
		String ans=driver.findElement(By.xpath("//a[normalize-space()='Zomato']/ancestor::tr")).getText();
		System.out.println("Ancestor:"+ans);
		
		//descendants
		List<WebElement> des=driver.findElements(By.xpath("//a[normalize-space()='Zomato']/ancestor::tr/descendant::*"));
		System.out.println("Number of elements: "+des.size());
		
		//following
		List<WebElement> foll=driver.findElements(By.xpath("//a[normalize-space()='Zomato']/ancestor::tr/following::tr"));
		System.out.println("Number of elements: "+foll.size());
		
		//preceding
		List<WebElement>pre=driver.findElements(By.xpath("//a[normalize-space()='Zomato']/ancestor::tr/preceding::tr"));
		System.out.println("Number of elements: "+pre.size());
		
		//following-sibling
		List<WebElement>follsib=driver.findElements(By.xpath("//a[normalize-space()='Zomato']/ancestor::tr/following-sibling::tr"));
		System.out.println("Number of elements: "+follsib.size());
		
		//preceding-sibling
		List<WebElement>presib=driver.findElements(By.xpath("//a[normalize-space()='Zomato']/ancestor::tr/preceding-sibling::tr"));
		System.out.println("Number of elements: "+presib.size());
		
		
	}

}
