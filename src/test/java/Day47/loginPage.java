package Day47;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class loginPage {
	
	WebDriver driver;
	
	//constructor
	
	loginPage(WebDriver driver)
	{
		this.driver=driver;
		
	}
	//Locators
	
	By txt_username=By.xpath("//input[@placeholder='Username']");
	By txt_password=By.xpath("//input[@placeholder='Password']");
	By btn_login=By.xpath("//button[normalize-space()='Login']");
	
	//Action methods
	
	public void setUserName(String user)
	{
		driver.findElement(txt_username).sendKeys(user);
	}
	
	public void setPassword(String pwd)
	{
		driver.findElement(txt_password).sendKeys(pwd);
	}
	
	public void Clickloginn()
	{
		driver.findElement(btn_login).click();
	}

	
}
